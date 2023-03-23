package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "otherinfo")
public class OtherInfo{

    @Id
    private Integer id;
    @Column(name ="infokey")
    private String key;
    @Column(name = "value")
    private String value;

    public OtherInfo() {
    }

    @Override
    public String toString() {
        return "OtherInfo{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public OtherInfo(Integer id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
