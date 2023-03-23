package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "fightlog")
public class FightLog {

    @Id
    private Integer id;
    @Column(name = "npcId")
    private Integer npcId;
    @Column(name = "p1Pokemon")
    private String p1Pokemon;
    @Column(name = "p2Pokemon")
    private String p2Pokemon;
    @Column(name = "lineupidx")
    private String lineupidx;
    @Column(name = "round")
    private Integer round;
    @Column (name = "operation")
    private String operation;
    @Column (name = "userId")
    private String userId;
    @Column (name = "resultId")
    private Integer resultId;
    @Column(name = "time")
    private Date time;
    @Column(name = "remark")
    private String remark;
    @Column (name = "fightInfo")
    private String fightInfo;

    public FightLog() {
    }

    public FightLog(Integer id, Integer npcId, String p1Pokemon, String p2Pokemon, String lineupidx, Integer round, String operation, String userId, Integer resultId, Date time) {
        this.id = id;
        this.npcId = npcId;
        this.p1Pokemon = p1Pokemon;
        this.p2Pokemon = p2Pokemon;
        this.lineupidx = lineupidx;
        this.round = round;
        this.operation = operation;
        this.userId = userId;
        this.resultId = resultId;
        this.time = time;
    }

    public FightLog(Integer id, Integer npcId, String p1Pokemon, String p2Pokemon, String lineupidx, Integer round, String operation, String userId, Integer resultId, Date time, String remark) {
        this.id = id;
        this.npcId = npcId;
        this.p1Pokemon = p1Pokemon;
        this.p2Pokemon = p2Pokemon;
        this.lineupidx = lineupidx;
        this.round = round;
        this.operation = operation;
        this.userId = userId;
        this.resultId = resultId;
        this.time = time;
        this.remark = remark;
    }

    public FightLog(Integer id, Integer npcId, String p1Pokemon, String p2Pokemon, String lineupidx, Integer round, String operation, String userId, Integer resultId, Date time, String remark, String fightInfo) {
        this.id = id;
        this.npcId = npcId;
        this.p1Pokemon = p1Pokemon;
        this.p2Pokemon = p2Pokemon;
        this.lineupidx = lineupidx;
        this.round = round;
        this.operation = operation;
        this.userId = userId;
        this.resultId = resultId;
        this.time = time;
        this.remark = remark;
        this.fightInfo = fightInfo;
    }

    @Override
    public String toString() {
        return "FightLog{" +
                "id=" + id +
                ", npcId=" + npcId +
                ", p1Pokemon='" + p1Pokemon + '\'' +
                ", p2Pokemon='" + p2Pokemon + '\'' +
                ", lineupidx='" + lineupidx + '\'' +
                ", round=" + round +
                ", operation='" + operation + '\'' +
                ", userId='" + userId + '\'' +
                ", resultId=" + resultId +
                ", time=" + time +
                ", remark='" + remark + '\'' +
                ", fightInfo='" + fightInfo + '\'' +
                '}';
    }

    public String getFightInfo() {
        return fightInfo;
    }

    public void setFightInfo(String fightInfo) {
        this.fightInfo = fightInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNpcId() {
        return npcId;
    }

    public void setNpcId(Integer npcId) {
        this.npcId = npcId;
    }

    public String getP1Pokemon() {
        return p1Pokemon;
    }

    public void setP1Pokemon(String p1Pokemon) {
        this.p1Pokemon = p1Pokemon;
    }

    public String getP2Pokemon() {
        return p2Pokemon;
    }

    public void setP2Pokemon(String p2Pokemon) {
        this.p2Pokemon = p2Pokemon;
    }

    public String getLineupidx() {
        return lineupidx;
    }

    public void setLineupidx(String lineupidx) {
        this.lineupidx = lineupidx;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
