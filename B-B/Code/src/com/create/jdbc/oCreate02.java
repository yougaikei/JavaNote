package com.create.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class oCreate02 {
    public static void main(String[] args) throws  Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 书写连接字符串
        String oUrl = "jdbc:mysql://localhost:3306/oSchoolData?characterEncoding=utf-8";

        // 获取连接
        Connection oCon = DriverManager.getConnection(oUrl, "root", "123456");

        // 获取语句执行平台
        Statement oSta = oCon.createStatement();

        // 执行sql语句: 查询 oSchoolData 数据库中的 oStudent 表中的所有数据
        String sql = "SELECT * FROM oStudent;";

        // 执行sql语句
        oSta.executeQuery(sql);

        // 获取返回值, 是结果集对象
        ResultSet oRes = oSta.executeQuery(sql);

        // 处理结果集对象
       //boolean oNext = oRes.next();
       //System.out.println(oNext);

        // 获取 ID
        //int oSId = oRes.getInt("SId");
        // 通过列名的方式获取
        //System.out.println("通过列名的方式获取: " + oSId);
        // 通过列号的方式获取
        //int oSId2 = oRes.getInt(1);
        //System.out.println("通过列号的方式获取: " + oSId2);

        // 通过 while 遍历结果集
        while(oRes.next()){
            // 获取 SId
            int SId = oRes.getInt("SId");
            // 获取 SName
            String SName = oRes.getString("SName");
            // 获取 SAge
            int SAge = oRes.getInt("SAge");
            // 获取 SSex
            String SSex = oRes.getString("SSex");

            // 输出
            System.out.println("ID: " + SId + " ; 姓名: " + SName + " ; 年龄: " + SAge + " ; 性别: " + SSex);
        }

       // Close
       oRes.close();
       oSta.close();
       oCon.close();


    }
}
