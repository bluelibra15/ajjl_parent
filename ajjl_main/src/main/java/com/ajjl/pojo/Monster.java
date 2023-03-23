package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monster")
public class Monster {
    @Id
    private Integer tableId;
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "npcid")
    private Integer npcId;
    @Column(name = "npc")
    private String npc;
    @Column(name = "remark")
    private String remark;

    public Monster() {
    }

    public Monster(Integer tableId, Integer id, String name, Integer npcId, String npc, String remark) {
        this.tableId = tableId;
        this.id = id;
        this.name = name;
        this.npcId = npcId;
        this.npc = npc;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "tableId=" + tableId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", npcId=" + npcId +
                ", npc='" + npc + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNpcId() {
        return npcId;
    }

    public void setNpcId(Integer npcId) {
        this.npcId = npcId;
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
