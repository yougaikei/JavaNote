package com.dbcp.Widgets;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0Widgets {

    // 创建连接池对象, C3P0 => DataSource API 的实现类
    public static ComboPooledDataSource oCPDS = new ComboPooledDataSource("mysql");

    // 获取连接池的方法
    public static Connection getConnection() throws Exception {
        return oCPDS.getConnection();
    }

    // 释放数据库连接
    public static void oClose(Connection oCon, Statement oSta) {
        if (oCon != null && oSta != null) {
            try {
                oCon.close();
                oSta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 重载方法
    public static void oClose(Connection oCon, Statement oSta, ResultSet oRes) {
        if (oCon != null && oSta != null && oRes != null) {
            try {
                oCon.close();
                oSta.close();
                oRes.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
