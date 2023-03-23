package com.ajjl.dao;

import com.ajjl.pojo.Player;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface PlayerDao extends Mapper<Player>,MySqlMapper<Player> {
}
