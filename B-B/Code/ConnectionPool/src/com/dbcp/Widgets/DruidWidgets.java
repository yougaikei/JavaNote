package com.dbcp.Widgets;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DruidWidgets {
    
    // 定义成员变量
    public static DataSource dataSource;

    // 定义静态代码块
    static {

        try {
            // 创建属性集对象
            Properties oPro = new Properties();            
   
            // 获取配置文件
            InputStream oInp = DruidWidgets.class.getClassLoader().getResourceAsStream("druid.properties");

            // 读取配置信息
            oPro.load(oInp);

            // 通过工厂类获取数据源
            dataSource = DruidDataSourceFactory.createDataSource(oPro);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 获取连接对象
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 获取对象连接池的方法
    public static DataSource getDataSource() {
        return dataSource;
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
