package com.ajjl.dao;

import com.ajjl.pojo.Monster;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MonsterDao extends Mapper<Monster>, MySqlMapper<Monster> {
}
