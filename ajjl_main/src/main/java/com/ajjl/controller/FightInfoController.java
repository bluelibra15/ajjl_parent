package com.ajjl.controller;

import com.ajjl.common.MyTools;
import com.ajjl.dao.FightLogDao;
import com.ajjl.pojo.Buff;
import com.ajjl.pojo.Fight;
import com.ajjl.pojo.FightLog;
import com.ajjl.pojo.Result;
import com.ajjl.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/fightInfo")
public class FightInfoController {
    @Autowired
    FightService fightService;
    @Autowired
    FightLogDao fightLogDao;
    @RequestMapping("/findFight")
    public Result findFight(@RequestBody Fight fight,String userId,String fightInfo){
        try{
            Fight fightDB = fightService.findFight(fight);
            String logInfo = "[Fight查询成功]--\n[查询条件]:"+fight.toString()+"\n[查询结果]"+fightDB.toString();
            MyTools.logInfo(logInfo);
            FightLog fightLog = new FightLog();
            fightLog.setNpcId(fight.getNpcId());
            fightLog.setLineupidx(fight.getLineupidx());
            fightLog.setP1Pokemon(fight.getP1Pokemon());
            fightLog.setP2Pokemon(fight.getP2Pokemon());
            fightLog.setRound(fight.getRound());
            fightLog.setUserId(userId);
            fightLog.setFightInfo(fightInfo);
            fightLog.setTime(new Date());
            if(fightDB != null){
                fightLog.setOperation(fightDB.getOperation());
                fightLog.setResultId(fightDB.getId());
                fightLog.setRemark(fightDB.getRemark());
            }
            fightLogDao.insert(fightLog);
            return new Result(true,"查询成功",fightDB);
        }catch (Exception e){
            String logInfo = "[Fight查询失败]--\n[查询条件]:"+fight.toString();
            MyTools.logInfo(logInfo);
            FightLog fightLog = new FightLog();
            fightLog.setNpcId(fight.getNpcId());
            fightLog.setLineupidx(fight.getLineupidx());
            fightLog.setP1Pokemon(fight.getP1Pokemon());
            fightLog.setP2Pokemon(fight.getP2Pokemon());
            fightLog.setFightInfo(fightInfo);
            fightLog.setRound(fight.getRound());
            fightLog.setUserId(userId);
            fightLog.setTime(new Date());
            fightLogDao.insert(fightLog);
            return new Result(false,"查询失败");
        }
    }

    @RequestMapping("/addFight")
    public Result addFight(@RequestBody Fight fight){
        try{
            int i = fightService.addFight(fight);
            return new Result(true,"添加成功");
        }catch (Exception e){
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/findBuff")
    public Result findBuff(@RequestBody Buff buff,String userId){
        try{
            Buff buffDB = fightService.findBuff(buff);
            String logInfo = "[Buff查询成功]--\n[查询条件]:"+buff.toString()+"\n[查询结果]"+buffDB.toString();
            MyTools.logInfo(logInfo);
            FightLog fightLog = new FightLog();
            fightLog.setNpcId(0);
            fightLog.setP1Pokemon(buffDB.getP1Pokemon());
            fightLog.setP2Pokemon("Buff");
            fightLog.setResultId(buffDB.getId());
            fightLog.setOperation(buffDB.getOperation());
            fightLog.setRemark(buffDB.getRemark());
            fightLog.setUserId(userId);
            fightLog.setTime(new Date());
            fightLogDao.insert(fightLog);
            return new Result(true,"查询成功",buffDB);
        }catch (Exception e){
            String logInfo = "[Buff查询失败]--\n[查询条件]:"+buff.toString();
            MyTools.logInfo(logInfo);
            return new Result(false,"查询失败");
        }
    }

    @RequestMapping("/addBuff")
    public Result addFight(@RequestBody Buff buff){
        try{
            int i = fightService.addBuff(buff);
            return new Result(true,"添加成功");
        }catch (Exception e){
            return new Result(false,"添加失败");
        }
    }
}
