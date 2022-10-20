package com.jdbc.dba;

import com.jdbc.entity.BuyCommodity;
import com.jdbc.entity.Commodity;
import com.jdbc.entity.CommodityType;
import com.jdbc.entity.Order;
import com.jdbc.widgets.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderWidgets {

    // 通过用户 ID 查询所有订单
    public List<Order> getOrderAllByUserId (String UId) throws SQLException {

        // 创建 QR 对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 书写 SQL 语句
        String SQL = "SELECT * FROM `Order` WHERE `UId` = ?";

        // 执行 SQL 语句
        List<Order> OrderList = qr.query(SQL, new BeanListHandler<Order>(Order.class), UId);

        // 返回结果
        return OrderList;

    }

    // 获取指定订单编号中的所有商品信息
    public List<Commodity> getCommodityAllByOrderId(String OId) throws SQLException {

        // 创建 QR 对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // 书写 SQL 语句
        String SQL = "SELECT * FROM `BuyCommodity` WHERE `OId` = ?";

        // 执行 SQL 语句
        List<BuyCommodity> oList = qr.query(SQL, new BeanListHandler<BuyCommodity>(BuyCommodity.class), OId);

        // 查询商品信息
        // 创建集合保存商品信息
        List<Commodity> CommodityList = new ArrayList<>();

        // 定义 CommodityWidgets 对象
        CommodityWidgets commodityWidgets = new CommodityWidgets();

        // 遍历订单项集合, 获取 CId
        for (BuyCommodity buyCommodity : oList) {

            // 获取 CId
            String CId = buyCommodity.getCId();

            // 调用商品 API, 通过商品 ID 查询商品信息
            Commodity Commodities = commodityWidgets.getCommodityById(CId);

            // 将商品信息添加到集合中
            CommodityList.add(Commodities);

        }

        // 返回值
        return CommodityList;
    }
}
