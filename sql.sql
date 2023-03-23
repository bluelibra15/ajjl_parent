use ajjldb;
select npcId,idx,count(idx) from player_list group by npcId,idx