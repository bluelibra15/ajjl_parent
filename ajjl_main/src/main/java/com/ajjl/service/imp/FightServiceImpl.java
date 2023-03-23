package com.ajjl.service.imp;

import com.ajjl.dao.BuffDao;
import com.ajjl.dao.FightDao;
import com.ajjl.pojo.Buff;
import com.ajjl.pojo.Fight;
import com.ajjl.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class FightServiceImpl implements FightService {
    @Autowired
    FightDao fightDao;
    @Autowired
    BuffDao buffDao;

    @Override
    public Fight findFight(Fight fight) {
        return fightDao.selectOne(fight);
    }

    @Override
    public int addFight(Fight fight) {
        return fightDao.insert(fight);
    }

    @Override
    public Buff findBuff(Buff buff) {
        return buffDao.selectOne(buff);
    }

    @Override
    public int addBuff(Buff buff) {
        return buffDao.insert(buff);
    }
}
