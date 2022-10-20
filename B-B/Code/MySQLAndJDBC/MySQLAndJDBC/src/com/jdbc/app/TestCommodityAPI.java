package com.jdbc.app;

import com.jdbc.dba.CommodityWidgets;
import com.jdbc.entity.Commodity;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class TestCommodityAPI {

    CommodityWidgets oCommodityWidgets = new CommodityWidgets();

    @Test
    public void testGetCommodityById() throws SQLException {

        Commodity commodityById = oCommodityWidgets.getCommodityById("CD-C-AD");

        // 输出结果
        System.out.println(commodityById.getCName() + " " + commodityById.getCPrice() + " " + commodityById.getCStock() + " " + commodityById.getCommodityType().getCTName());
    }

    @Test
    public void testGetCommodityTypeSumByCommodity() throws SQLException {

        // 获取查询 CId 为 ? 的商品类型的商品数量 (String CId)
        int TypeSum = oCommodityWidgets.getCommodityTypeSumByCommodity("CD-CT-Books");

        // 输出结果
        System.out.println(TypeSum);
    }

    @Test
    public void testGetCommoditiesByCommodityType() throws SQLException {

        List<Commodity> oList = oCommodityWidgets.getCommoditiesByCommodityType("CD-CT-CA");

        for (Commodity oCommodity : oList) {
            System.out.println(oCommodity.getCName() + " " + oCommodity.getCPrice() + "/元; " + oCommodity.getCStock() + "/件; " + oCommodity.getCDescription());
        }

    }

}
