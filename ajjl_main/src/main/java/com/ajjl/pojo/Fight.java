package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fight")
public class Fight {

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
    @Column (name = "buffId")
    private Integer buffId;
    @Column (name = "remark")
    private String remark;

    public Fight() {
    }

    public Fight(Integer id, Integer npcId, String p1Pokemon, String p2Pokemon, String lineupidx, Integer round, String operation, Integer buffId) {
        this.id = id;
        this.npcId = npcId;
        this.p1Pokemon = p1Pokemon;
        this.p2Pokemon = p2Pokemon;
        this.lineupidx = lineupidx;
        this.round = round;
        this.operation = operation;
        this.buffId = buffId;
    }

    public Fight(Integer id, Integer npcId, String p1Pokemon, String p2Pokemon, String lineupidx, Integer round, String operation, Integer buffId, String remark) {
        this.id = id;
        this.npcId = npcId;
        this.p1Pokemon = p1Pokemon;
        this.p2Pokemon = p2Pokemon;
        this.lineupidx = lineupidx;
        this.round = round;
        this.operation = operation;
        this.buffId = buffId;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Fight{" +
                "id=" + id +
                ", npcId=" + npcId +
                ", p1Pokemon='" + p1Pokemon + '\'' +
                ", p2Pokemon='" + p2Pokemon + '\'' +
                ", lineupidx='" + lineupidx + '\'' +
                ", round=" + round +
                ", operation='" + operation + '\'' +
                ", buffId=" + buffId +
                ", remark='" + remark + '\'' +
                '}';
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getBuffId() {
        return buffId;
    }

    public void setBuffId(Integer buffId) {
        this.buffId = buffId;
    }
}
