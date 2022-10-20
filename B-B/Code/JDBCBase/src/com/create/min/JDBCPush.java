package com.create.min;

import com.create.widgets.JDBCWidgets;

import java.sql.*;

public class JDBCPush {

    public static void main(String[] args) throws SQLException {

        // 创建链接
        Connection oCon = JDBCWidgets.getConnection();

        // 获取执行平台
        Statement oSta = oCon.createStatement();

        // 书写两条 SQL 语句
        String oSQLAddYKX = "INSERT INTO oStudent(SName, SAge, SSex, SGrade, SDepartment, STuition, SPassword) VALUES('杨凯溪', 22, '男', 3, '医学系', '1', 123456);";
        String oSQLAddBSZ = "INSERT INTO oStudent(SName, SAge, SSex, SGrade, SDepartment, STuition, SPassword) VALUES('白素贞', 1700, '女', 3, '道法系', '1', 123456);";

        // 执行 SQL 语句
        oSta.executeUpdate(oSQLAddYKX);
        oSta.executeUpdate(oSQLAddBSZ);

        // 使用 ? 作为占位符
        String oSQLAdd = "INSERT INTO oStudent(SName, SAge, SSex, SGrade, SDepartment, STuition, SPassword) VALUES(?, ?, ?, ?, ?, ?, ?);";

        // 创建预编译对象
        PreparedStatement oPre = oCon.prepareStatement(oSQLAdd);

        // 插入数据
        oPre.setString(1, "李奥雪");
        oPre.setInt(2, 20);
        oPre.setString(3, "女");
        oPre.setInt(4, 3);
        oPre.setString(5, "医学系");
        oPre.setString(6, "1");
        oPre.setInt(7, 123456);

        // 执行 SQL 语句
        oPre.executeUpdate();

        // 关闭资源
        oSta.close();
        oPre.close();
        oCon.close();
    }
}
