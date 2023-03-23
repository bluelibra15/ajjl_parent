package com.ajjl.service;

import com.ajjl.pojo.Monster;
import com.ajjl.pojo.PlayerList;

import java.util.List;
import java.util.Map;

public interface KingsService {
    Monster addMonster(Monster monster);

    List<Monster> findMonster(Monster monster);

    PlayerList addPlayerList(PlayerList playerList);

    List<Map<String,Object>> findLineupList(Map<String, Object> map);
}
