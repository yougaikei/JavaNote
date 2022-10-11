package com.dbcp.DBUtilsDemo;
import com.dbcp.Widgets.DruidWidgets;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class getSQLByConnection {

    // 获取数据库元数据信息 通过 DatabaseMetaData
    @Test
    public void getSQLByConnection() throws Exception {

        // 获取数据库连接
        Connection oCon = DruidWidgets.getConnection();

        // 获取数据库元数据
        DatabaseMetaData oDBMD = oCon.getMetaData();

        // 获取数据库的地址
        String oUrl = oDBMD.getURL();
        System.out.println("数据库地址为: " + oUrl);

        // 获取用户信息
        String oUserName = oDBMD.getUserName();
        System.out.println("数据库用户名为: " + oUserName);

        // 获取产品名称
        String oProductName = oDBMD.getDatabaseProductName();
        System.out.println("数据库产品名称为: " + oProductName);

        // 获取数据库版本
        String oProductVersion = oDBMD.getDatabaseProductVersion();
        System.out.println("数据库版本为: " + oProductVersion);

        // 获取数据库驱动名称
        String oDriverName = oDBMD.getDriverName();
        System.out.println("数据库驱动名称为: " + oDriverName);

        // 获取数据库是否为只读 if true 只读 else 可写
        boolean oReadOnly = oDBMD.isReadOnly();
        System.out.println("数据库是否为只读: " + oReadOnly);

        // 4. 释放资源
        oCon.close();
    }
}
