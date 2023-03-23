package com.ajjl.dao;

import com.ajjl.pojo.Fight;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface FightDao extends Mapper<Fight>, MySqlMapper<Fight> {
}
