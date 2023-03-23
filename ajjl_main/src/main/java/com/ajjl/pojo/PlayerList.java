package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player_list")
public class PlayerList {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "npcId")
    private Integer npcId;

    @Column(name = "idx")
    private String idx;

    @Column(name = "monsterId")
    private Integer monsterId;

    @Column(name = "firstAttribute")
    private String firstAttribute;

    @Column(name = "secondAttribute")
    private String secondAttribute;

    @Column(name = "characteristic")
    private String characteristic;

    @Column(name = "prop")
    private String prop;

    @Column(name = "skillA")
    private String skillA;

    @Column(name = "skillB")
    private String skillB;

    @Column(name = "skillC")
    private String skillC;

    @Column(name = "skillD")
    private String skillD;

    @Column(name = "note")
    private String note;

    @Column(name = "boostType")
    private String boostType;

    @Column(name = "boostTypeDesc")
    private String boostTypeDesc;

    @Column(name = "speed")
    private String speed;

    @Column(name = "ding")
    private Boolean ding;

    @Column(name = "t_lock")
    private Boolean lock;

    @Column(name = "drug")
    private String drug;

    @Column(name = "weather")
    private String weather;

    @Column(name = "chu")
    private Boolean chu;

    @Column(name = "author")
    private String author;

    @Column(name = "upCount")
    private String upCount;

    @Column(name = "active")
    private Boolean active;

    public PlayerList() {
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

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public Integer getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Integer monsterId) {
        this.monsterId = monsterId;
    }

    public String getFirstAttribute() {
        return firstAttribute;
    }

    public void setFirstAttribute(String firstAttribute) {
        this.firstAttribute = firstAttribute;
    }

    public String getSecondAttribute() {
        return secondAttribute;
    }

    public void setSecondAttribute(String secondAttribute) {
        this.secondAttribute = secondAttribute;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getSkillA() {
        return skillA;
    }

    public void setSkillA(String skillA) {
        this.skillA = skillA;
    }

    public String getSkillB() {
        return skillB;
    }

    public void setSkillB(String skillB) {
        this.skillB = skillB;
    }

    public String getSkillC() {
        return skillC;
    }

    public void setSkillC(String skillC) {
        this.skillC = skillC;
    }

    public String getSkillD() {
        return skillD;
    }

    public void setSkillD(String skillD) {
        this.skillD = skillD;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBoostType() {
        return boostType;
    }

    public void setBoostType(String boostType) {
        this.boostType = boostType;
    }

    public String getBoostTypeDesc() {
        return boostTypeDesc;
    }

    public void setBoostTypeDesc(String boostTypeDesc) {
        this.boostTypeDesc = boostTypeDesc;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Boolean getDing() {
        return ding;
    }

    public void setDing(Boolean ding) {
        this.ding = ding;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Boolean getChu() {
        return chu;
    }

    public void setChu(Boolean chu) {
        this.chu = chu;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUpCount() {
        return upCount;
    }

    public void setUpCount(String upCount) {
        this.upCount = upCount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "PlayerList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", npcId=" + npcId +
                ", idx='" + idx + '\'' +
                ", monsterId=" + monsterId +
                ", firstAttribute='" + firstAttribute + '\'' +
                ", secondAttribute='" + secondAttribute + '\'' +
                ", characteristic='" + characteristic + '\'' +
                ", prop='" + prop + '\'' +
                ", skillA='" + skillA + '\'' +
                ", skillB='" + skillB + '\'' +
                ", skillC='" + skillC + '\'' +
                ", skillD='" + skillD + '\'' +
                ", note='" + note + '\'' +
                ", boostType='" + boostType + '\'' +
                ", boostTypeDesc='" + boostTypeDesc + '\'' +
                ", speed='" + speed + '\'' +
                ", ding=" + ding +
                ", lock=" + lock +
                ", drug='" + drug + '\'' +
                ", weather='" + weather + '\'' +
                ", chu=" + chu +
                ", author='" + author + '\'' +
                ", upCount='" + upCount + '\'' +
                ", active=" + active +
                '}';
    }

    public PlayerList(Integer id, String name, Integer npcId, String idx, Integer monsterId, String firstAttribute, String secondAttribute, String characteristic, String prop, String skillA, String skillB, String skillC, String skillD, String note, String boostType, String boostTypeDesc, String speed, Boolean ding, Boolean lock, String drug, String weather, Boolean chu, String author, String upCount, Boolean active) {
        this.id = id;
        this.name = name;
        this.npcId = npcId;
        this.idx = idx;
        this.monsterId = monsterId;
        this.firstAttribute = firstAttribute;
        this.secondAttribute = secondAttribute;
        this.characteristic = characteristic;
        this.prop = prop;
        this.skillA = skillA;
        this.skillB = skillB;
        this.skillC = skillC;
        this.skillD = skillD;
        this.note = note;
        this.boostType = boostType;
        this.boostTypeDesc = boostTypeDesc;
        this.speed = speed;
        this.ding = ding;
        this.lock = lock;
        this.drug = drug;
        this.weather = weather;
        this.chu = chu;
        this.author = author;
        this.upCount = upCount;
        this.active = active;
    }
}
