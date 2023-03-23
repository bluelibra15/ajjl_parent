package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "zdjl_user")
public class ZdjlUser {
    @Id
    private Integer id;
    @Column(name = "userId")
    private String userId;
    @Column(name = "regCode")
    private String regCode;
    @Column(name = "status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ZdjlUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", regCode='" + regCode + '\'' +
                ", status=" + status +
                '}';
    }

    public ZdjlUser() {
    }

    public ZdjlUser(Integer id, String userId, String regCode, Integer status) {
        this.id = id;
        this.userId = userId;
        this.regCode = regCode;
        this.status = status;
    }
}
