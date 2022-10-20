package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class getSQLByPrepareStatement {

    // 获取表元信息 通过 ResultSetMetaData
    @Test
    public void getSQLByPrepareStatement() throws Exception {

        // 获取数据库连接
        Connection oCon = DruidWidgets.getConnection();

        // 获取预处理对象
        PreparedStatement oRre = oCon.prepareStatement("SELECT * FROM oEmployees");

        // 获取结果集
        ResultSet oRes = oRre.executeQuery();

        // 获取结果集元数据
        ResultSetMetaData oRSMD = oRes.getMetaData();

        // 分隔符
        System.out.println("=================== 列 数 =================");

        // 获取列数
        int oColumnCount = oRSMD.getColumnCount();
        System.out.println("列数为: " + oColumnCount);

        // 分隔符
        System.out.println("=================== 列 名 =================");

        // 获取列名
        for (int i = 1; i <= oColumnCount; i++) {
            String oColumnName = oRSMD.getColumnName(i);
            System.out.println("列名为: " + oColumnName);
        }

        // 分隔符
        System.out.println("=================== 类 型 =================");

        // 获取列类型
        for (int i = 1; i <= oColumnCount; i++) {
            String oColumnType = oRSMD.getColumnTypeName(i);
            System.out.println("列类型为: " + oColumnType);
        }

        // 释放资源
        DruidWidgets.oClose(oCon, oRre, oRes);

    }
}
