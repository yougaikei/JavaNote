package com.dbcp.create;
import com.dbcp.Widgets.C3P0Widgets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C3P0Demo {

    public static void main(String[] args) throws Exception {

        // 获取连接
        Connection oCon = C3P0Widgets.getConnection();

         //获取语句执行平台
        String oSQLWHEREEName = "SELECT * FROM oEmployees WHERE EName = ?";
        PreparedStatement oPre = oCon.prepareStatement(oSQLWHEREEName);

        // 设置参数
        oPre.setString(1, "王子怡");

        // 执行SQL
        ResultSet oRes = oPre.executeQuery();

        // 查询返回的结果
        while (oRes.next()) {
            System.out.println("员工 ID: " + oRes.getInt("EId"));
            System.out.println("员工姓名: " + oRes.getString("EName"));
            System.out.println("员工性别: " + oRes.getString("EGender"));
            System.out.println("员工年龄: " + oRes.getInt("EAge"));
            System.out.println("员工电话: " + oRes.getString("EPhone"));
            System.out.println("员工地址: " + oRes.getString("EAddress"));
            System.out.println("员工邮箱: " + oRes.getString("EEmail"));
            System.out.println("员工密码: " + oRes.getString("EPassword"));
            System.out.println("员工类型: " + oRes.getString("EType"));
            System.out.println("员工状态: " + oRes.getByte("EStatus"));
            System.out.println("员工薪资: " + oRes.getDouble("ESalary"));
            System.out.println("员工入职时间: " + oRes.getDate("ECreateTime"));
            System.out.println("员工更新时间: " + oRes.getDate("EUpdateTime"));
        }

        // 释放资源
        C3P0Widgets.oClose(oCon, oPre, oRes);
    }
}
