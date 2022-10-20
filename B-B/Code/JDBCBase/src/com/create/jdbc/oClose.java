package com.create.jdbc;
import java.sql.*;

public class oClose {
    public static void main(String[] args) {
        Connection oCon = null;
        Statement oSta = null;
        ResultSet oRes = null;
        try {

            oCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/oSchoolData?characterEncoding=utf-8", "root", "123456");

            oSta = oCon.createStatement();

            // 创建执行语句
            String oSql = "SELECT * FROM oStudent";

            // 执行语句
            oRes = oSta.executeQuery(oSql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oRes.close();
                oSta.close();
                oCon.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
