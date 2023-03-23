package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buff")
public class Buff {

    @Id
    private Integer id;
    @Column(name = "tuxiFlag")
    private String tuxiFlag;
    @Column(name = "speedFlag")
    private String speedFlag;
    @Column(name = "jieshi71Flag")
    private String jieshi71Flag;
    @Column(name ="p1Pokemon")
    private String p1Pokemon;
    @Column(name = "operation")
    private String operation;
    @Column (name = "remark")
    private String remark;

    public Buff() {
    }

    public Buff(Integer id, String tuxiFlag, String speedFlag, String jieshi71Flag, String p1Pokemon, String operation) {
        this.id = id;
        this.tuxiFlag = tuxiFlag;
        this.speedFlag = speedFlag;
        this.jieshi71Flag = jieshi71Flag;
        this.p1Pokemon = p1Pokemon;
        this.operation = operation;
    }

    public Buff(Integer id, String tuxiFlag, String speedFlag, String jieshi71Flag, String p1Pokemon, String operation, String remark) {
        this.id = id;
        this.tuxiFlag = tuxiFlag;
        this.speedFlag = speedFlag;
        this.jieshi71Flag = jieshi71Flag;
        this.p1Pokemon = p1Pokemon;
        this.operation = operation;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Buff{" +
                "id=" + id +
                ", tuxiFlag='" + tuxiFlag + '\'' +
                ", speedFlag='" + speedFlag + '\'' +
                ", jieshi71Flag='" + jieshi71Flag + '\'' +
                ", p1Pokemon='" + p1Pokemon + '\'' +
                ", operation='" + operation + '\'' +
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

    public String getTuxiFlag() {
        return tuxiFlag;
    }

    public void setTuxiFlag(String tuxiFlag) {
        this.tuxiFlag = tuxiFlag;
    }

    public String getSpeedFlag() {
        return speedFlag;
    }

    public void setSpeedFlag(String speedFlag) {
        this.speedFlag = speedFlag;
    }

    public String getJieshi71Flag() {
        return jieshi71Flag;
    }

    public void setJieshi71Flag(String jieshi71Flag) {
        this.jieshi71Flag = jieshi71Flag;
    }

    public String getP1Pokemon() {
        return p1Pokemon;
    }

    public void setP1Pokemon(String p1Pokemon) {
        this.p1Pokemon = p1Pokemon;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}