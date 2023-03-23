package com.ajjl.controller;

import com.ajjl.pojo.RegCode;
import com.ajjl.pojo.Result;
import com.ajjl.service.RegCodeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regCode")
public class RegCodeController {

    @Autowired
    RegCodeService regCodeService;

    //查询所有的卡密信息
    @RequestMapping("/findAll")
    public Result findAll(
            //参数:当前页码,每页展示数据数量
            @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        PageInfo<RegCode> pageInfo = regCodeService.findAll(currentPage,pageSize);
        return new Result(true,"查询成功",pageInfo);
    }

    @RequestMapping("/addRegCode")
    public Result addRegCode(
            //参数:生成卡密数量,应用名字,卡密类型,时长,多开数
            @RequestParam("num") Integer num,
            @RequestParam(value = "appName",defaultValue = "无") String appName,
            @RequestParam(value = "type",defaultValue = "") String type,
            @RequestParam(value = "time",defaultValue = "") Integer time,
            @RequestParam(value = "multiWindow",defaultValue = "1") Integer multiWindow){
        try {
            //效验参数
            if ((num == null || num <= 0) ||
                (type == null || "".equals(type)) ||
                (time == null || "".equals(time))){
                return new Result(false,"参数错误");
            }
            //添加并返回添加的卡密
            List<RegCode> regCodes = regCodeService.addRegCode(num,appName,type,time,multiWindow);
            return new Result(true,"添加成功",regCodes);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败,发生异常");
        }
    }
}
