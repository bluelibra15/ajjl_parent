package com.ajjl.controller;

import com.ajjl.pojo.Player;
import com.ajjl.pojo.Result;
import com.ajjl.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @RequestMapping("/add")
    public Result add(Player player){
        try {
            int i = playerService.add(player);
            return new Result(true,"添加成功");
        } catch (Exception e) {
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/del")
    public Result del(Player player){
        try {
            int i = playerService.del(player);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            return new Result(false,"删除失败");
        }
    }

    @RequestMapping("/findByPlayer")
    public Result findByPlayer(Player player){
        try {
            List<Player> playerList = playerService.findByPlayer(player);
            return new Result(true,"查询成功",playerList);
        } catch (Exception e) {
            return new Result(false,"查询失败");
        }
    }

    @RequestMapping("/update")
    public Result update(Player player){
        try {
            int i = playerService.update(player);
            return new Result(true,"更新成功");
        }catch (Exception e){
            return new Result(false,"更新失败");
        }
    }

    @RequestMapping("/delByPlayer")
    public Result delByPlayer(Player player){
        try {
            int i = playerService.delByPlayer(player);
            return new Result(true,"删除成功");
        }catch (Exception e){
            return new Result(false,"删除失败");
        }
    }
}
