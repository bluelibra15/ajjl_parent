package com.ajjl.service.imp;

import com.ajjl.common.JedisUtils;
import com.ajjl.common.MyTools;
import com.ajjl.dao.RegCodeDao;
import com.ajjl.dao.ZdjlUserDao;
import com.ajjl.pojo.RegCode;
import com.ajjl.pojo.Result;
import com.ajjl.pojo.ZdjlUser;
import com.ajjl.service.ZdjlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ZdjlUserServiceImpl implements ZdjlUserService {
    @Autowired
    private ZdjlUserDao zdjlUserDao;
    @Autowired
    private RegCodeDao regCodeDao;
    @Autowired
    private JedisUtils jedisUtils;

    //绑定卡密和用户
    @Override
    public String bind(ZdjlUser zdjlUser) {
        /*
        检查卡密是否存在
        如果存在
        检查卡密是否被绑定
        如果绑定
            返回 “卡密已绑定”
        否则
            返回 “卡密不存在”
        * */
        RegCode regCode = new RegCode();
        regCode.setRegCode(zdjlUser.getRegCode());
        List<RegCode> regCodes = regCodeDao.select(regCode);
        if(regCodes == null || regCodes.size() <= 0){
            return "卡密不存在";
        }
        RegCode regCodeDB = regCodes.get(0);
        String binding = regCodeDB.getBinding();
        if(binding != null){
            return "卡密已被绑定";
        }

        if(!regCodeDB.getRegCode().equalsIgnoreCase(zdjlUser.getUserId())){
            String[] split = zdjlUser.getUserId().split("_");
            String appName = split[0];
            if(regCodeDB.getAppName() == null || appName == null){
                return "卡密功能信息错误";
            }
            if(!regCodeDB.getAppName().equalsIgnoreCase(appName)  &&
                    !"qq".equalsIgnoreCase(appName) &&
                    !"weixin".equalsIgnoreCase(appName)){
                return "卡密功能不正确-卡密功能:"+regCodeDB.getAppName()+"-需要功能:"+appName;
            }
        }
        ZdjlUser selectZdjlUser = new ZdjlUser();
        selectZdjlUser.setUserId(zdjlUser.getUserId());
        List<ZdjlUser> zdjlUsers = zdjlUserDao.select(selectZdjlUser);
        /*
        根据userId查询表中是否已存在这个用户，
        如果存在则根据主键id执行更新操作，
        否则直接添加
        * */
        int i = -1;
        if(zdjlUsers == null || zdjlUsers.size() <= 0){
            i = zdjlUserDao.insert(zdjlUser);
        }else{
            ZdjlUser zdjlUserDB = zdjlUsers.get(0);
            zdjlUser.setId(zdjlUserDB.getId());
            i = zdjlUserDao.updateByPrimaryKey(zdjlUser);
        }

        /*
        获取卡密类型
        并根据卡密类型判断卡密结束时间
        更新卡密的开始时间和结束时间
        设置卡密的绑定userId
        * */
        String type = regCodeDB.getType();

        Date endTime = MyTools.getDate(regCodeDB.getTime());

        regCodeDB.setBeginTime(new Date());
        regCodeDB.setEndTime(endTime);
        regCodeDB.setBinding(zdjlUser.getUserId());
        regCodeDao.updateByPrimaryKey(regCodeDB);

        return "绑定成功";
    }

    //心跳验证
    @Override
    public String heart(String userId) throws ParseException {
        Jedis jedis = jedisUtils.getJedis();
        //在redis中查询是否有该用户的时间信息
        String userEndTimeKey = userId+"|EndTime";
        String userEndTimestr = jedis.get(userEndTimeKey);
        //格式化日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date userEndTime = null;
        Boolean testGroup = false;
        //如果查询到了对应的日期信息，则赋值给userEndTime
        if(userEndTimestr != null){
            if (userEndTimestr.indexOf("测试组") >= 0){
                testGroup = true;
            }
            userEndTime = dateFormat.parse(userEndTimestr.substring(0,userEndTimestr.indexOf("|")));
        }else{
            ZdjlUser zdjlUser = new ZdjlUser();
            zdjlUser.setUserId(userId);
            List<ZdjlUser> zdjlUsers = zdjlUserDao.select(zdjlUser);
            if(zdjlUsers == null || zdjlUsers.size() <= 0){
                jedisUtils.close(jedis);
                return "用户未绑定卡密信息!";
            }
            ZdjlUser zdjlUserDB = zdjlUsers.get(0);
            String code = zdjlUserDB.getRegCode();
            if(code == null || "".equals(code)){
                jedisUtils.close(jedis);
                return "用户未绑定卡密信息!";
            }
            RegCode regCode = new RegCode();
            regCode.setRegCode(code);
            List<RegCode> regCodes = regCodeDao.select(regCode);
            if(regCodes == null || regCodes.size() <= 0){
                jedisUtils.close(jedis);
                return "用户绑定的卡密无效!";
            }
            RegCode regCodeDB = regCodes.get(0);
            String type = regCodeDB.getType();
            if("测试组".equals(type)){
                testGroup = true;
            }
            userEndTime = regCodeDB.getEndTime();
            userEndTimestr = dateFormat.format(userEndTime);
            //将过期日期信息保存到redis中
            jedis.setex(userEndTimeKey,86400,userEndTimestr+"|"+type);
        }

        //比较卡密信息是否过期
        Date now = new Date();
        if(now.after(userEndTime)){
            jedisUtils.close(jedis);
            jedis.del(userEndTimeKey);
            return "卡密已过期!";
        }

        //设置心跳验证("保证无法多开")
        String userHeartKey = userId + "|Heart";
        String userHeartTime = jedis.get(userHeartKey);
        if(userHeartTime != null){
            jedisUtils.close(jedis);
            return "用户已登录!如确定未登录,请60s后再试!";
        }
        Date heartTime = new Date();
        String heartTimeStr = dateFormat.format(heartTime);
        //设置过期时间为55
        jedis.setex(userHeartKey,55,heartTimeStr);
        jedisUtils.close(jedis);
        if(testGroup){
            return "心跳验证成功|testGroup-"+userEndTimestr;
        }
        return "心跳验证成功-"+userEndTimestr;
    }

    @Override
    public List<ZdjlUser> getZdjlUser(ZdjlUser zdjlUser) {
        return zdjlUserDao.select(zdjlUser);
    }

    @Override
    public int addZdjlUser(ZdjlUser zdjlUser) {
        return zdjlUserDao.insert(zdjlUser);
    }

    @Override
    public void updateZdjlUserByRegCode() {
        List<ZdjlUser> zdjlUsers = zdjlUserDao.selectAll();
        for (ZdjlUser zdjlUser : zdjlUsers) {
            if(zdjlUser != null && zdjlUser.getRegCode() != null){
                String userId = zdjlUser.getUserId();
                String[] split = userId.split("_");
                if("qq".equalsIgnoreCase(split[0]) || "weixin".equalsIgnoreCase(split[0])){
                    String regCodeStr = zdjlUser.getRegCode();
                    RegCode regCode = new RegCode();
                    regCode.setRegCode(regCodeStr);
                    List<RegCode> select = regCodeDao.select(regCode);
                    if(select != null && select.size() > 0){
                        RegCode regCodeDB = select.get(0);
                        String appName = regCodeDB.getAppName();
                        ZdjlUser zdjlUserTemp = new ZdjlUser();
                        zdjlUserTemp.setStatus(0);
                        zdjlUserTemp.setRegCode(regCodeStr);
                        zdjlUserTemp.setUserId(appName+"_"+userId);
                        zdjlUserDao.insert(zdjlUserTemp);
                    }
                }
            }
        }
    }

}
