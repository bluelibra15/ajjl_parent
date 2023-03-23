package com.ajjl.controller;

import com.ajjl.common.QiniuUtils;
import com.ajjl.pojo.Result;
import com.ajjl.pojo.ZdjlUser;
import com.ajjl.service.ZdjlUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/zdjl")
public class ZdjlController {

    @Autowired
    private ZdjlUserService zdjlUserService;

    @RequestMapping("/uploadImage")
    public Result uploadImage(@RequestBody Map<String,String> map){
        try{
            String imageBase64 = map.get("imageBase64");
            String imageName = map.get("imageName");
            byte [] byteArray = Base64.getDecoder().decode(imageBase64);
            QiniuUtils.upload2Qiniu(byteArray,imageName);
            return new Result(true,"上传成功",imageName);
        }catch (Exception e){
            return new Result(false,"上传失败");
        }

    }

    @RequestMapping("/userBind")
    public Result userBind(@RequestBody ZdjlUser zdjlUser){
        try{
            String str = zdjlUserService.bind(zdjlUser);
            return new Result(true,"绑定验证成功",str);
        }catch (Exception e){
            return new Result(false,"绑定验证异常");
        }
    }

    @RequestMapping("/userBind2")
    public Result userBind2(String userId,String regCode,Integer status){
        try{
            ZdjlUser zdjlUser = new ZdjlUser();
            zdjlUser.setUserId(userId);
            zdjlUser.setRegCode(regCode);
            zdjlUser.setStatus(status);
            String str = zdjlUserService.bind(zdjlUser);
            return new Result(true,"绑定验证成功",str);
        }catch (Exception e){
            return new Result(false,"绑定验证异常");
        }
    }


    @RequestMapping("/userHeart")
    public Result userHeart(String userId){
        try {
            String str = zdjlUserService.heart(userId);
            return new Result(true,"心跳验证成功",str);
        } catch (Exception e) {
            return new Result(false,"心跳验证异常");
        }
    }

    @RequestMapping("/getZdjlUser")
    public Result getZdjlUser(ZdjlUser zdjlUser){
        try {
            List<ZdjlUser> zdjlUsers = zdjlUserService.getZdjlUser(zdjlUser);
            return new Result(true,"查询成功",zdjlUsers);
        }catch (Exception e){
            return new Result(false,"查询失败");
        }
    }

    @RequestMapping("/addZdjlUser")
    public Result addZdjlUser(ZdjlUser zdjlUser){
        try {
            int i = zdjlUserService.addZdjlUser(zdjlUser);
            return new Result(true,"添加成功",zdjlUser);
        }catch (Exception e){
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/updateZdjlUserByRegCode")
    public Result updateZdjlUserByRegCode(){
        try {
            zdjlUserService.updateZdjlUserByRegCode();
            return new Result(true,"更新成功");
        }catch (Exception e){
            return new Result(false,"更新失败");
        }
    }
}
