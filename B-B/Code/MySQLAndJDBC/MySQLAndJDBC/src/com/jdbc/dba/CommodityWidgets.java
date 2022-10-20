package com.jdbc.dba;

import com.jdbc.entity.Commodity;
import com.jdbc.entity.CommodityType;
import com.jdbc.widgets.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CommodityWidgets {
    // 查找指定 ID 的商品: 获得商品名称、价格
    public Commodity getCommodityById(String CId) throws SQLException {

        // A. 创建 QR 对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // B. 编写 SQL 语句 (避免多表查询)
        // 1) 通过商品 ID 查询商品信息
        String sql = "SELECT * FROM `Commodity` WHERE `CId` = ?";

        // C. 执行查询语句
        Commodity oQuery = qr.query(sql, new BeanHandler<Commodity>(Commodity.class), CId);

        // D. 获取外键值
        String CTId = oQuery.getCTId();

        // E. 调取商品类型函数
        CommodityType oCommodityType = getCommodityTypeByCId(CTId);

        oQuery.setCommodityType(oCommodityType);

        return oQuery;
    }

    // 获取指定商品的商品类型: 通过商品的 KEY 外键
    public CommodityType getCommodityTypeByCId(String CTId) throws SQLException {

        // A. 创建 QR 对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // B. 编写 SQL 语句 (避免多表查询)
        // 1) 通过商品 ID 查询商品信息
        String sql = "SELECT * FROM `CommodityType` WHERE `CTId` = ?";

        // C. 执行查询语句
        CommodityType oQuery = qr.query(sql, new BeanHandler<CommodityType>(CommodityType.class), CTId);

        // D. 返回结果 商品类型
        return oQuery;
    }

    // 获取指定商品类型的商品数量( 不是库存 )
    public int getCommodityTypeSumByCommodity(String CId) throws SQLException {

            // A. 创建 QR 对象
            QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

            // B. 编写 SQL 语句 (避免多表查询)
            // 1) 通过商品 ID 查询商品信息
            String sql = "SELECT COUNT(*) FROM `Commodity` WHERE `CTId` = ?";

            // C. 执行查询语句
            Long oQuery = qr.query(sql, new ScalarHandler<>(), CId);

            // D. 返回结果 商品类型
            return oQuery.intValue();
    }

    // 获取指定分类下的所有商品详情 ( Commodity => 复数形式 => Commodities )
    public List<Commodity> getCommoditiesByCommodityType(String CTId) throws SQLException {

        // A. 创建 QR 对象
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        // B. 编写 SQL 语句 (避免多表查询)
        // 1) 通过商品 ID 查询商品信息
        String sql = "SELECT * FROM `Commodity` WHERE `CTId` = ?";

        // C. 执行查询语句
        List<Commodity> oList = qr.query(sql, new BeanListHandler<Commodity>(Commodity.class), CTId);

        // D. 返回结果 商品类型
        return oList;
    }

}
