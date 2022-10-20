package com.create.widgets;

import java.sql.*;

public class JDBCBank {

    // 将连接信息定义为字符串常量
    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";

    // MySQL Url 地址
    public static final String URL = "jdbc:mysql://localhost:3306/oBank?characterEncoding=UTF-8";
    // MySQL User 用户名
    public static final String USER = "root";
    // MySQL PassWorld 密码
    public static final String PASSWORLD = "123456";

    // 静态代码块
    static {
        try{
            // 注册驱动
            Class.forName(DRIVERNAME);

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection () {
        // 获取连接对象并返回
        try {
            Connection oCon = DriverManager.getConnection(URL, USER, PASSWORLD);
            return oCon;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 关闭资源方式
    public static void oClose(Connection oCon, Statement oSta) {

        if(oCon != null && oSta != null){
            try {
                oCon.close();
                oSta.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void oClose(Connection oCon, Statement oSta, ResultSet oRes) {

        if(oCon != null && oSta != null){
            try {
                oCon.close();
                oSta.close();
                oRes.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


