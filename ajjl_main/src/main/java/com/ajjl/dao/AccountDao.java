package com.ajjl.dao;

import com.ajjl.pojo.Account;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface AccountDao extends Mapper<Account>, MySqlMapper<Account> {
}
