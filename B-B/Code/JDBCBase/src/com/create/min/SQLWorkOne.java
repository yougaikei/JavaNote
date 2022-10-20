package com.create.min;
import java.sql.*;
import com.create.widgets.JDBCBank;

public class SQLWorkOne {

    public static void main(String[] args) {

        Connection oCon = null;
        PreparedStatement oPre = null;

        try {
            // 获取连接
            oCon = JDBCBank.getConnection();
            // 禁止自动提交
            oCon.setAutoCommit(false);

            // 配置转账当事人
            String oSQLRem = "UPDATE Users SET BBalance = BBalance - ? WHERE BName = ?;";
            oPre = oCon.prepareStatement(oSQLRem);
            oPre.setDouble(1, 1000.00);
            oPre.setString(2, "林耀东");
            oPre.executeUpdate();

            // 模拟异常
            //int i = 1 / 0;

            // 配置转账收取人
            String oSQLAdd = "UPDATE Users SET BBalance = BBalance + ? WHERE BName = ?;";
            oPre = oCon.prepareStatement(oSQLAdd);
            oPre.setDouble(1, 1000.00);
            oPre.setString(2, "刘思轩");
            oPre.executeUpdate();
            oCon.commit();

            // 提示: 转账成功
            System.out.println("转账成功!");

        } catch (SQLException e) {

            // 异常回滚事务
            try {
                oCon.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // 提示: 转账失败
            System.out.println("转账失败!");

            throw new RuntimeException(e);
        } finally {
            JDBCBank.oClose(oCon, oPre);
        }


    }
}
