package com.create.min;

import com.create.widgets.JDBCWidgets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchData01 {

    // 查询数据: oSchool => oStudent => WHERE SName = '胡子轩';
    public static void main(String[] args) throws SQLException {
        // 获取连接
        Connection oCon = JDBCWidgets.getConnection();

        // 创建 oSta 对象
        Statement oSta = oCon.createStatement();

        // 编写 MySQL 语句
        String oSQLSearchStudentSNameHZX = "SELECT * FROM oStudent WHERE SName = '胡子轩';";

        // 执行 MySQL 查询语句
        ResultSet oRes = oSta.executeQuery(oSQLSearchStudentSNameHZX);

        // 处理结果集
        while (oRes.next()){
            // 获取数据
            int oSId = oRes.getInt("SId");
            String oSName = oRes.getString("SName");
            int oSAge = oRes.getInt("SAge");
            String oSSex = oRes.getString("SSex");
            int oSGrade = oRes.getInt("SGrade");
            String oSDepartment = oRes.getString("SDepartment");
            int oSTuition = oRes.getInt("STuition");

            // 输出数据
            System.out.println("学号: " + oSId);
            System.out.println("姓名: " + oSName);
            System.out.println("年龄: " + oSAge);
            System.out.println("性别: " + oSSex);
            System.out.println("年级: " + oSGrade);
            System.out.println("系别: " + oSDepartment);
            System.out.println("学费缴纳: " + (oSTuition == 1 ? "是" : "否"));
        }

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta, oRes);
    }
}
