package com.ajjl.dao;

import com.ajjl.pojo.FightLog;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface FightLogDao extends Mapper<FightLog>, MySqlMapper<FightLog> {
}
