package com.ajjl.controller;

import com.ajjl.pojo.Account;
import com.ajjl.pojo.Result;
import com.ajjl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/add")
    public Result add(Account account){
        try{
            if (account.getCode() == null || "".equals(account.getCode())){
                account.setCode("0");
            }
            if (account.getStatus() == null || "".equals(account.getStatus())){
                account.setStatus(0);
            }
            accountService.add(account);
            return new Result(true,"添加成功");
        }catch (Exception e){
            return new Result(false,"添加失败");
        }
    }

    @RequestMapping("/findByAccount")
    public Result findByAccount(Account account){
        try {
            List<Account> accountList =accountService.findByAccount(account);
            Account acc = accountList.get(0);
            acc.setStatus(1);
            accountService.update(acc);
            List<Account> accounts = new ArrayList<>();
            accounts.add(acc);
            return new Result(true,"查询成功",accounts);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"查询失败");
        }

    }

    @RequestMapping("/update")
    public Result update(Account account){
        try{
            int i = accountService.update(account);
            return new Result(true,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"更新失败");
        }
    }
}

