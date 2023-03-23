package com.ajjl.service;

import com.ajjl.pojo.Buff;
import com.ajjl.pojo.Fight;

import java.util.Map;

public interface FightService {

    Fight findFight(Fight fight);

    int addFight(Fight fight);

    Buff findBuff(Buff buff);

    int addBuff(Buff buff);
}
