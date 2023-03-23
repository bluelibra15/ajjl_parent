package com.ajjl.dao;


import com.ajjl.pojo.Skill;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SkillDao extends Mapper<Skill>, MySqlMapper<Skill> {
}
