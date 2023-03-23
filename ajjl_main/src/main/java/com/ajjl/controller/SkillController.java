package com.ajjl.controller;

import com.ajjl.pojo.Result;
import com.ajjl.pojo.Skill;
import com.ajjl.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @RequestMapping("/find")
    public Result find(Skill skill){
        try{
            Skill skillDB =skillService.find(skill);
            return new Result(true,"查询成功",skillDB);
        }catch (Exception e){
            return new Result(false,"查询失败");
        }
    }

    @RequestMapping("/add")
    public Result add(Skill skill){
        try {
            skillService.add(skill);
            return new Result(true,"添加成功");
        }catch (Exception e){
            return new Result(false,"添加失败");
        }
    }
}
