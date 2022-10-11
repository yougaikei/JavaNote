package com.dbcp.create;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.dbcp.Widgets.DruidWidgets;

public class DruidDemo {

    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection oCon = DruidWidgets.getConnection();

        // 获取连接对象
        Statement oSta = oCon.createStatement();

        // 查询 WHERE ESalary:5000 - 10000 之间的数据
        String oSQL = "SELECT EName FROM oEmployees WHERE ESalary BETWEEN 5000 AND 10000";

        // 执行查询
        ResultSet oRex = oSta.executeQuery(oSQL);

        // 遍历结果集
        while (oRex.next()) {
            System.out.println(oRex.getString("EName"));
        }

        // 关闭资源
        DruidWidgets.oClose(oCon, oSta, oRex);
    }
}
