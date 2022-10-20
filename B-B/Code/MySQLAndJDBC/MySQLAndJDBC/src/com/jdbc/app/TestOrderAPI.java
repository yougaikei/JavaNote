package com.jdbc.app;

import com.jdbc.dba.OrderWidgets;
import com.jdbc.entity.Commodity;
import com.jdbc.entity.Order;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class TestOrderAPI {

    OrderWidgets orderWidgets = new OrderWidgets();

    @Test
    public void testGetOrderAllByUserId () throws SQLException {

        // 测试通过用户 ID 查询所有订单
        List<Order> oAllOrder = orderWidgets.getOrderAllByUserId("CD-User-20210101-03");

        // 遍历结果
        for (Order order : oAllOrder) {
            System.out.println(order);
        }

    }

    @Test
    public void testGetCommodityAllByOrderId() throws SQLException {
        List<Commodity> cAllCommodity = orderWidgets.getCommodityAllByOrderId("By-AA-20221012-01");
        for (Commodity commodity : cAllCommodity) {
            System.out.println(commodity);
        }
    }
}
