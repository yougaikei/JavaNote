package com.dbcp.entiy;

import java.io.Serializable;
import java.util.Date;

public class oEmployees implements Serializable {
    /** oEmployees
     *  dataType:
     *    EId: int; ( ID is Key )
     *    EName: String; ( 名前 )
     *    EGender: String;　( 性別 )
     *    EAge: int;　( 年齢 )
     *    EPhone: String;　( 電話番号 )
     *    EAddress: String;　( 住所 )
     *    EEmail: String;　( メールアドレス )
     *    EPassword: String;　( パスワード )
     *    EType: String;　( 勤務形態 )
     *    EStatus: byte;　( 勤務状態 1（在職）と0（離職）のみ )
     *    ESalary: double;　( 給与 )
     *    ECreateTime: Date;　( 登録日時 )
     *    EUpdateTime: Date;　( 更新日時 )
     */

    private int EId;
    private String EName;
    private String EGender;
    private int EAge;
    private String EPhone;
    private String EAddress;
    private String EEmail;
    private String EPassword;
    private String EType;
    private byte EStatus;
    private double ESalary;
    private Date ECreateTime;
    private Date EUpdateTime;

    // 空参
    public oEmployees() {
    }

    public int getEId() {
        return EId;
    }

    public void setEId(int EId) {
        this.EId = EId;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public String getEGender() {
        return EGender;
    }

    public void setEGender(String EGender) {
        this.EGender = EGender;
    }

    public int getEAge() {
        return EAge;
    }

    public void setEAge(int EAge) {
        this.EAge = EAge;
    }

    public String getEPhone() {
        return EPhone;
    }

    public void setEPhone(String EPhone) {
        this.EPhone = EPhone;
    }

    public String getEAddress() {
        return EAddress;
    }

    public void setEAddress(String EAddress) {
        this.EAddress = EAddress;
    }

    public String getEEmail() {
        return EEmail;
    }

    public void setEEmail(String EEmail) {
        this.EEmail = EEmail;
    }

    public String getEPassword() {
        return EPassword;
    }

    public void setEPassword(String EPassword) {
        this.EPassword = EPassword;
    }

    public String getEType() {
        return EType;
    }

    public void setEType(String EType) {
        this.EType = EType;
    }

    public byte getEStatus() {
        return EStatus;
    }

    public void setEStatus(byte EStatus) {
        this.EStatus = EStatus;
    }

    public double getESalary() {
        return ESalary;
    }

    public void setESalary(double ESalary) {
        this.ESalary = ESalary;
    }

    public Date getECreateTime() {
        return ECreateTime;
    }

    public void setECreateTime(Date ECreateTime) {
        this.ECreateTime = ECreateTime;
    }

    public Date getEUpdateTime() {
        return EUpdateTime;
    }

    public void setEUpdateTime(Date EUpdateTime) {
        this.EUpdateTime = EUpdateTime;
    }

    // 全参
    public oEmployees(int EId, String EName, String EGender, int EAge, String EPhone, String EAddress, String EEmail, String EPassword, String EType, byte EStatus, double ESalary, Date ECreateTime, Date EUpdateTime) {
        this.EId = EId;
        this.EName = EName;
        this.EGender = EGender;
        this.EAge = EAge;
        this.EPhone = EPhone;
        this.EAddress = EAddress;
        this.EEmail = EEmail;
        this.EPassword = EPassword;
        this.EType = EType;
        this.EStatus = EStatus;
        this.ESalary = ESalary;
        this.ECreateTime = ECreateTime;
        this.EUpdateTime = EUpdateTime;
    }

    // toString
    @Override
    public String toString() {
        return "oEmployees{" +
                "EId=" + EId +
                ", EName='" + EName + '\'' +
                ", EGender='" + EGender + '\'' +
                ", EAge=" + EAge +
                ", EPhone='" + EPhone + '\'' +
                ", EAddress='" + EAddress + '\'' +
                ", EEmail='" + EEmail + '\'' +
                ", EPassword='" + EPassword + '\'' +
                ", EType='" + EType + '\'' +
                ", EStatus=" + EStatus +
                ", ESalary=" + ESalary +
                ", ECreateTime=" + ECreateTime +
                ", EUpdateTime=" + EUpdateTime +
                '}';
    }
}
