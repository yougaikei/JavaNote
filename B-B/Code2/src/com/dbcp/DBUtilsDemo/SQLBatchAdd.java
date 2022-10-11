package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLBatchAdd {

    // 目标: 向 SQL 中批量添加 100 条数据
    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection oCon = DruidWidgets.getConnection();

        // 创建预处理语句
        String oSQLDataAdd = "INSERT INTO oBatch(BName) VALUES(?)";
        PreparedStatement oPre = oCon.prepareStatement(oSQLDataAdd);

        // 批量添加数据
        for(int i = 0; i < 100; i++){
            oPre.setString(1, "Tom" + (i < 10 ? "0" + i : i));

            // 添加到批处理
            oPre.addBatch();
        }

        // 添加时间戳
        long oRunTime = System.currentTimeMillis();

        // 执行批处理
        oPre.executeBatch();

        // 添加时间戳
        long oEndTime = System.currentTimeMillis();

        // 打印时间
        System.out.println("批量添加 100 条数据, 耗时: " + (oEndTime - oRunTime) + " (ms)毫秒");

        // 释放资源
        DruidWidgets.oClose(oCon, oPre);

    }
}
