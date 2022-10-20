package com.bind.JDBCAndXML.JDBCFile;

import com.bind.JDBCAndXML.Widgets.JDBCWidgets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCGetStudents {

    public static void main(String[] args) throws SQLException {
        Connection oCon = JDBCWidgets.getConnection();

        Statement oSta = oCon.createStatement();

        String sSql = "select * from oStudent";

        ResultSet oRes = oSta.executeQuery(sSql);

        // 处理结果集对象
        while (oRes.next()) {
            System.out.println(oRes.getString("sName"));
        }

        // 释放资源
        oRes.close();
        oSta.close();
    }

}
