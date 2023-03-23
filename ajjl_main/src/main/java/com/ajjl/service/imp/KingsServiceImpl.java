package com.ajjl.service.imp;

import com.ajjl.dao.MonsterDao;
import com.ajjl.dao.PlayerListDao;
import com.ajjl.pojo.Monster;
import com.ajjl.pojo.PlayerList;
import com.ajjl.service.KingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class KingsServiceImpl implements KingsService {
    @Autowired
    MonsterDao monsterDao;
    @Autowired
    PlayerListDao playerListDao;

    @Override
    public Monster addMonster(Monster monster) {
        monsterDao.insert(monster);
        return monster;
    }

    @Override
    public List<Monster> findMonster(Monster monster) {
        return monsterDao.select(monster);
    }

    @Override
    public PlayerList addPlayerList(PlayerList playerList) {
        playerListDao.insert(playerList);
        return playerList;
    }

    @Override
    public List<Map<String,Object>> findLineupList(Map<String, Object> map) {
        String npcIdStr = (String) map.get("npcId");
        Integer npcId = new Integer(npcIdStr);
        List<Map<String,String>> monsterIdList = (List<Map<String, String>>) map.get("playerList");
        Set<String> idxList = new HashSet<>();
        ArrayList<Map<String,Object>> lineupListTemp = new ArrayList<>();
        ArrayList<Map<String,Object>> lineupList = new ArrayList<>();
        for (Map<String, String> monster : monsterIdList) {
            Integer monsterId = new Integer(monster.get("monsterId"));
            if (lineupListTemp.size() <= 0){
                PlayerList playerList = new PlayerList();
                playerList.setNpcId(npcId);
                playerList.setMonsterId(monsterId);
                List<PlayerList> playerLists = playerListDao.select(playerList);
                if(playerLists == null || playerLists.size() <=0){
                    return null;
                }
                for (PlayerList plist : playerLists) {
                    String idx = plist.getIdx();
                    if (idx != null) {
                        idxList.add(idx);
                    }
                }
                for (String idx : idxList) {
                    PlayerList p2 = new PlayerList();
                    p2.setNpcId(npcId);
                    p2.setIdx(idx);
                    List<PlayerList> p2List = playerListDao.select(p2);
                    Map<String, Object> lineup = new LinkedHashMap<>();
                    lineup.put("npcId",npcId);
                    lineup.put("idx",idx);
                    lineup.put("playerList",p2List);
                    lineupListTemp.add(lineup);
                }
                if (monsterIdList.size() <= 1){
                    lineupList = lineupListTemp;
                }
            }else{
                lineupList = new ArrayList<>();
                for (int i = 0; i < lineupListTemp.size(); i++) {
                    Map<String, Object> map2 = lineupListTemp.get(i);
                    List<PlayerList> playerList = (List<PlayerList>) map2.get("playerList");
                    boolean flag = false;
                    for (int j = 0; j < playerList.size(); j++) {
                        PlayerList p2 = playerList.get(j);
                        Integer mId = p2.getMonsterId();
                        if (mId.equals(monsterId)){
                            flag = true;
                            break;
                        }
                    }
                    if (flag == true){
                        lineupList.add(map2);
                    }
                }
                lineupListTemp = lineupList;
            }
        }
        return lineupList;
    }
}
