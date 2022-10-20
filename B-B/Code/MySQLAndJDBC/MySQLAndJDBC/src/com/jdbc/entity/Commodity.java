package com.jdbc.entity;

/*
 * 商品表
 *     CId VARCHAR(50) => String => 商品 ID
 *     CName VARCHAR(20) => String => 商品名称
 *     CPrice DOUBLE(10,2) => double => 商品价格
 *     CStock INT(10) => int => 商品库存
 *     CDescription VARCHAR(100) => String => 商品描述
 *     CCreateTime TIMESTAMP => String => 商品创建时间
 *     CStatus INT(1) => int => 商品状态
 *     CTId VARCHAR(50) => String => 商品分类 ID => CommodityType.CTId ( KEY )
 */

public class Commodity {
    private String CId;
    private String CName;
    private double CPrice;
    private int CStock;
    private String CDescription;
    private String CCreateTime;
    private int CStatus;
    private String CTId;

    private CommodityType commodityType; // 保存分类的详细信息

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public double getCPrice() {
        return CPrice;
    }

    public void setCPrice(double CPrice) {
        this.CPrice = CPrice;
    }

    public int getCStock() {
        return CStock;
    }

    public void setCStock(int CStock) {
        this.CStock = CStock;
    }

    public String getCDescription() {
        return CDescription;
    }

    public void setCDescription(String CDescription) {
        this.CDescription = CDescription;
    }

    public String getCCreateTime() {
        return CCreateTime;
    }

    public void setCCreateTime(String CCreateTime) {
        this.CCreateTime = CCreateTime;
    }

    public int getCStatus() {
        return CStatus;
    }

    public void setCStatus(int CStatus) {
        this.CStatus = CStatus;
    }

    public String getCTId() {
        return CTId;
    }

    public void setCTId(String CTId) {
        this.CTId = CTId;
    }

    public CommodityType getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(CommodityType commodityType) {
        this.commodityType = commodityType;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "CId='" + CId + '\'' +
                ", CName='" + CName + '\'' +
                ", CPrice=" + CPrice +
                ", CStock=" + CStock +
                ", CDescription='" + CDescription + '\'' +
                ", CCreateTime='" + CCreateTime + '\'' +
                ", CStatus=" + CStatus +
                ", CTId='" + CTId + '\'' +
                '}';
    }
}
