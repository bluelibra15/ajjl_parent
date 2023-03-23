package com.ajjl.service;

import com.ajjl.pojo.Skill;

public interface SkillService {
    Skill find(Skill skill);

    int add(Skill skill);
}
