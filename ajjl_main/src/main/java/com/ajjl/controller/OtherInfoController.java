package com.ajjl.controller;

import com.ajjl.pojo.OtherInfo;
import com.ajjl.pojo.Result;
import com.ajjl.service.OtherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otherInfo")
public class OtherInfoController {

    @Autowired
    OtherInfoService otherInfoService;

    @RequestMapping("/add")
    public Result add(OtherInfo otherInfo){
        try {
            otherInfoService.add(otherInfo);
            return new Result(true,"添加成功");
        }catch (Exception e){
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/find")
    public Result find(OtherInfo otherInfo){
        try {
            OtherInfo otherInfoDB = otherInfoService.find(otherInfo);
            return new Result(true,"查询成功",otherInfoDB);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"查询失败");
        }
    }
    @RequestMapping("/del")
    public Result del(OtherInfo otherInfo){
        try {
            otherInfoService.del(otherInfo);
            return new Result(true,"删除成功",otherInfo);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
