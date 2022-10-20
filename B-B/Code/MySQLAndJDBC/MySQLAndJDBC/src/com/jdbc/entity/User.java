package com.jdbc.entity;

/*
 * 用户表:
 *     UId VARCHAR(50) => String => 用户 ID
 *     UName VARCHAR(20) => String => 用户名
 *     USex VARCHAR(10) => String => 用户性别
 *     UBirthday DATE => Date => 用户生日
 *     UPassword VARCHAR(20) => String => 用户密码
 *     UPhone VARCHAR(20) => String => 用户电话
 *     UEmail  VARCHAR(50) => String => 用户邮箱
 *     UIDCard VARCHAR(20) => String => 用户身份证号
 *     UCreateTime TIMESTAMP => Timestamp => 用户创建时间
 */


public class User{
    private String UId;
    private String UName;
    private String USex;
    private String UBirthday;
    private String UPassword;
    private String UPhone;
    private String UEmail;
    private String UIDCard;
    private String UCreateTime;

    public String getUId() {
        return UId;
    }

    public void setUId(String UId) {
        this.UId = UId;
    }

    public String getUName() {
        return UName;
    }

    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUSex() {
        return USex;
    }

    public void setUSex(String USex) {
        this.USex = USex;
    }

    public String getUBirthday() {
        return UBirthday;
    }

    public void setUBirthday(String UBirthday) {
        this.UBirthday = UBirthday;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getUPhone() {
        return UPhone;
    }

    public void setUPhone(String UPhone) {
        this.UPhone = UPhone;
    }

    public String getUEmail() {
        return UEmail;
    }

    public void setUEmail(String UEmail) {
        this.UEmail = UEmail;
    }

    public String getUIDCard() {
        return UIDCard;
    }

    public void setUIDCard(String UIDCard) {
        this.UIDCard = UIDCard;
    }

    public String getUCreateTime() {
        return UCreateTime;
    }

    public void setUCreateTime(String UCreateTime) {
        this.UCreateTime = UCreateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "UId='" + UId + '\'' +
                ", UName='" + UName + '\'' +
                ", USex='" + USex + '\'' +
                ", UBirthday='" + UBirthday + '\'' +
                ", UPassword='" + UPassword + '\'' +
                ", UPhone='" + UPhone + '\'' +
                ", UEmail='" + UEmail + '\'' +
                ", UIDCard='" + UIDCard + '\'' +
                ", UCreateTime='" + UCreateTime + '\'' +
                '}';
    }
}
