package com.ajjl.service.imp;

import com.ajjl.dao.AccountDao;
import com.ajjl.pojo.Account;
import com.ajjl.pojo.Player;
import com.ajjl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    public int add(Account account) {
        int insert = accountDao.insert(account);
        return insert;
    }

    @Override
    public List<Account> findByAccount(Account account) {
        return accountDao.select(account);
    }

    @Override
    public int update(Account account) {
        return accountDao.updateByPrimaryKeySelective(account);
    }
}
