package com.ajjl.dao;

import com.ajjl.pojo.PlayerList;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PlayerListDao extends Mapper<PlayerList>, MySqlMapper<PlayerList> {
}
