package com.ajjl.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "regcode")
public class RegCode implements Serializable {
    @Id
    private Integer id;
    @Column(name = "appName")
    private String appName;
    @Column(name = "orderId")
    private String orderId;
    private String type;
    @Column(name = "regCode")
    private String regCode;
    private Integer status;
    private Integer time;
    @Column(name = "multiWindow")
    private Integer multiWindow;
    @Column(name = "beginTime")
    private Date beginTime;
    @Column(name = "endTime")
    private Date endTime;
    private String binding;

    public RegCode() {
    }

    public RegCode(Integer id, String appName, String orderId, String type, String regCode, Integer status, Integer time, Integer multiWindow, Date beginTime, Date endTime, String binding) {
        this.id = id;
        this.appName = appName;
        this.orderId = orderId;
        this.type = type;
        this.regCode = regCode;
        this.status = status;
        this.time = time;
        this.multiWindow = multiWindow;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.binding = binding;
    }

    @Override
    public String toString() {
        return "RegCode{" +
                "id=" + id +
                ", appName='" + appName + '\'' +
                ", orderId='" + orderId + '\'' +
                ", type='" + type + '\'' +
                ", regCode='" + regCode + '\'' +
                ", status=" + status +
                ", time='" + time + '\'' +
                ", multiWindow=" + multiWindow +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", binding='" + binding + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getMultiWindow() {
        return multiWindow;
    }

    public void setMultiWindow(Integer multiWindow) {
        this.multiWindow = multiWindow;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }
}
