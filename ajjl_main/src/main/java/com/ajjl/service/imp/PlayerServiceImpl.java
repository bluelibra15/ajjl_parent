package com.ajjl.service.imp;

import com.ajjl.dao.PlayerDao;
import com.ajjl.pojo.Player;
import com.ajjl.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerDao playerDao;
    @Override
    public int add(Player player) {
        return playerDao.insert(player);
    }

    @Override
    public int del(Player player) {
        return playerDao.delete(player);
    }

    @Override
    public List<Player> findByPlayer(Player player) {
        return playerDao.select(player);
    }

    @Override
    public int update(Player player) {
        return playerDao.updateByPrimaryKeySelective(player);
    }

    @Override
    public int delByPlayer(Player player) {
        return playerDao.delete(player);
    }
}
