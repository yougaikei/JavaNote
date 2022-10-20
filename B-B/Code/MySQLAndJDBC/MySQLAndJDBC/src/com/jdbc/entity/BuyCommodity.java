package com.jdbc.entity;

/* 购物表
 * BCId VARCHAR(50) => String => 购物 ID
 * CId VARCHAR(50) => String => 商品 ID => Commodity.CId ( KEY )
 * OId VARCHAR(50) => String => 订单 ID => Order.OId ( KEY )
 * BCNum INT(10) => int => 购买数量
 */

public class BuyCommodity {
    private String BCId;
    private String CId;
    private String OId;

    private Commodity commodity; // 保存商品的详细信息
    private Order order; // 保存订单的详细信息

    public String getBCId() {
        return BCId;
    }

    public void setBCId(String BCId) {
        this.BCId = BCId;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getOId() {
        return OId;
    }

    public void setOId(String OId) {
        this.OId = OId;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "BuyCommodity{" +
                "BCId='" + BCId + '\'' +
                ", CId='" + CId + '\'' +
                ", OId='" + OId + '\'' +
                '}';
    }
}
