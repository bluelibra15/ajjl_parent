package com.ajjl.service;

import com.ajjl.pojo.Account;
import com.ajjl.pojo.Player;

import java.util.List;

public interface AccountService {
    int add(Account account);

    List<Account> findByAccount(Account account);

    int update(Account account);
}
