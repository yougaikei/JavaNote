package com.dbcp.Widgets;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPWidget {

    // 数据库连接信息
    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/oCompany?characterEncoding=UTF-8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    // 数据库连接池
    public static BasicDataSource dataSource = new BasicDataSource();

    // 使用静态代码块初始化数据库连接池
    static {
        dataSource.setDriverClassName(DRIVERNAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
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
