package com.dbcp.create;
import com.dbcp.Widgets.DBCPWidget;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPDemo {

    public static void main(String[] args) throws SQLException {

        // 从 DBCP 中获取连接
        Connection oCon = DBCPWidget.getConnection();

        // 获取查询对象: Statement
        Statement oSta = oCon.createStatement();

        // 查询所有员工姓名
        String oSQLName = "SELECT EName FROM oEmployees";
        ResultSet oRex = oSta.executeQuery(oSQLName);

        int oCount = 0;
        // 遍历结果集
        while (oRex.next()) {
            ++oCount;
            System.out.println("第 " + (oCount > 9 ? oCount: ("0" + oCount))+ " 名是: " + oRex.getString("EName"));
        }

        // 关闭资源
        DBCPWidget.oClose(oCon, oSta, oRex);
    }
}
