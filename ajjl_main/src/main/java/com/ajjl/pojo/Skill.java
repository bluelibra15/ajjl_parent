package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    private int id;
    @Column(name = "skillname")
    private String skillname;
    @Column(name = "type")
    private Integer type;
    @Column(name = "attribute")
    private Integer attribute;

    public Skill() {
    }

    public Skill(int id, String skillname, Integer type, Integer attribute) {
        this.id = id;
        this.skillname = skillname;
        this.type = type;
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillname='" + skillname + '\'' +
                ", type=" + type +
                ", attribute=" + attribute +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAttribute() {
        return attribute;
    }

    public void setAttribute(Integer attribute) {
        this.attribute = attribute;
    }
}
