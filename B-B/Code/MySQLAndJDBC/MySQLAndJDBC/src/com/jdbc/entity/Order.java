package com.jdbc.entity;

/*
 * 订单表:
 *     OId VARCHAR(50) => String => 订单 ID
 *     OCreateTime TIMESTAMP => Timestamp => 订单创建时间
 *     OMoney DOUBLE(10,2) => double => 订单金额
 *     OName VARCHAR(50) => String => 订单名称
 *     OPhone VARCHAR(20) => String => 订单电话
 *     OAddress VARCHAR(100) => String => 订单地址
 *     OStatus INT(2) => String => 订单状态
 *     UId VARCHAR(50) => String => 用户 ID => User.UId ( KEY )
 */

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String OId;
    private String OCreateTime;
    private double OMoney;
    private String OName;
    private String OPhone;
    private String OAddress;
    private String OStatus;
    private String UId;

    // 一个订单中包含了多个订单项的信息
    List<BuyCommodity> oList = new ArrayList<>();

    private User user; // 一个订单对应一个用户, 此处引入用户 ( User ) 对象

    public String getOId() {
        return OId;
    }

    public void setOId(String OId) {
        this.OId = OId;
    }

    public String getOCreateTime() {
        return OCreateTime;
    }

    public void setOCreateTime(String OCreateTime) {
        this.OCreateTime = OCreateTime;
    }

    public double getOMoney() {
        return OMoney;
    }

    public void setOMoney(double OMoney) {
        this.OMoney = OMoney;
    }

    public String getOName() {
        return OName;
    }

    public void setOName(String OName) {
        this.OName = OName;
    }

    public String getOPhone() {
        return OPhone;
    }

    public void setOPhone(String OPhone) {
        this.OPhone = OPhone;
    }

    public String getOAddress() {
        return OAddress;
    }

    public void setOAddress(String OAddress) {
        this.OAddress = OAddress;
    }

    public String getOStatus() {
        return OStatus;
    }

    public void setOStatus(String OStatus) {
        this.OStatus = OStatus;
    }

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "OId='" + OId + '\'' +
                ", OCreateTime='" + OCreateTime + '\'' +
                ", OMoney=" + OMoney +
                ", OName='" + OName + '\'' +
                ", OPhone='" + OPhone + '\'' +
                ", OAddress='" + OAddress + '\'' +
                ", OStatus='" + OStatus + '\'' +
                ", UId='" + UId + '\'' +
                '}';
    }
}
