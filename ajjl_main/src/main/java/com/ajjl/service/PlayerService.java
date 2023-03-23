package com.ajjl.service;

import com.ajjl.pojo.Player;

import java.util.List;

public interface PlayerService {
    int add(Player player);

    int del(Player player);

    List<Player> findByPlayer(Player player);

    int update(Player player);

    int delByPlayer(Player player);
}
