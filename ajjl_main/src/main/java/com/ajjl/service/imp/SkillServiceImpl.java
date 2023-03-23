package com.ajjl.service.imp;

import com.ajjl.dao.SkillDao;
import com.ajjl.pojo.Skill;
import com.ajjl.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
    @Autowired
    SkillDao skillDao;

    @Override
    public Skill find(Skill skill) {
        return skillDao.selectOne(skill);
    }

    @Override
    public int add(Skill skill) {
        return skillDao.insert(skill);
    }
}
