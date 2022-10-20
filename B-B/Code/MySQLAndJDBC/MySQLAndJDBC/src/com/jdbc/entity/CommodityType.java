package com.jdbc.entity;

/*
 * 商品分类表:
 *     CTId VARCHAR(50) => String => 商品分类 ID
 *     CTName VARCHAR(20) => String => 商品分类名称
 *     CTCreateTime TIMESTAMP => String => 商品分类创建时间
 */

public class CommodityType {

    private String CTId;
    private String CTName;
    private String CTCreateTime;

    public String getCTId() {
        return CTId;
    }

    public void setCTId(String CTId) {
        this.CTId = CTId;
    }

    public String getCTName() {
        return CTName;
    }

    public void setCTName(String CTName) {
        this.CTName = CTName;
    }

    public String getCTCreateTime() {
        return CTCreateTime;
    }

    public void setCTCreateTime(String CTCreateTime) {
        this.CTCreateTime = CTCreateTime;
    }


    @Override
    public String toString() {
        return "CommodityType{" +
                "CTId='" + CTId + '\'' +
                ", CTName='" + CTName + '\'' +
                ", CTCreateTime='" + CTCreateTime + '\'' +
                '}';
    }
}
