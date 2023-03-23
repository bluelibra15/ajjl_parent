package com.ajjl.controller;

import com.ajjl.dao.BuffDao;
import com.ajjl.pojo.Monster;
import com.ajjl.pojo.PlayerList;
import com.ajjl.pojo.Result2;
import com.ajjl.service.KingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kings")
public class KingsController {
    @Autowired
    private KingsService kingsService;

    @RequestMapping("/addMonster")
    public Result2 addMonster(@RequestBody Monster monster){
        try {
            monster = kingsService.addMonster(monster);
            return new Result2(true,"添加成功",monster);
        }catch (Exception e){
            return new Result2(false,"添加失败");
        }
    }

    @RequestMapping("/findMonster")
    public Result2 findMonster(@RequestBody Monster monster){
        try {
            List<Monster> monsterList = kingsService.findMonster(monster);
            return new Result2(true,"查询成功",monsterList);
        }catch (Exception e){
            return new Result2(false,"查询失败");
        }
    }

    @RequestMapping("/addPlayerList")
    public Result2 addPlayerList(@RequestBody PlayerList playerList){
        try {
            playerList = kingsService.addPlayerList(playerList);
            return new Result2(true,"添加成功",playerList);
        }catch (Exception e){
            return new Result2(false,"添加失败");
        }
    }


    @RequestMapping("/findLineupList")
    public Result2 findLineupList(@RequestBody Map<String,Object> map){
        try {
            List<Map<String,Object>> lineupList = kingsService.findLineupList(map);
            Map<String,Object> resultMap = new LinkedHashMap();
            resultMap.put("count",lineupList.size());
            resultMap.put("lineupList",lineupList);
            return new Result2(true,"查询成功",resultMap);
        }catch (Exception e){
            return new Result2(false,"查询失败");
        }
    }

}
