package com.ajjl.service.imp;

import com.ajjl.common.MyTools;
import com.ajjl.dao.RegCodeDao;
import com.ajjl.pojo.RegCode;
import com.ajjl.service.RegCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RegCodeServiceImpl implements RegCodeService {

    @Autowired
    private RegCodeDao regCodeDao;

    @Override
    public void test(){
        System.out.println("this is test");
    }

    @Override
    public PageInfo<RegCode> findAll(Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<RegCode> regCodes = regCodeDao.selectAll();
        PageInfo<RegCode> pageInfo = new PageInfo<>(regCodes);
        return pageInfo;
    }


    @Override
    public List<RegCode> addRegCode(Integer num,String appName,String type,Integer time,Integer multiWindow) {
        List<RegCode> regCodes = new ArrayList<>();
        //生成订单号
        String ordeId = MyTools.getUUID();
        //生成指定个数 卡密,并创建RegCode对象
        for (Integer i = 0; i < num; i++) {
            String regStr = MyTools.getRegCode();
            RegCode regCode = new RegCode(0,appName,ordeId,type,regStr,0,time,multiWindow,null,null,null);
            regCodes.add(regCode);
        }
        regCodeDao.insertList(regCodes);
        return regCodes;
    }


}
