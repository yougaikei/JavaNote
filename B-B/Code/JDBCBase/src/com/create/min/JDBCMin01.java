package com.create.min;
import com.create.widgets.JDBCWidgets;
import org.junit.Test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMin01 {

    // 插入操作:
    // 姓名, 年龄, 性别, 年级, 专业, 缴费状态
    // SName, SAge, SSex, SGrade, SDepartment, STuition;
    // '胡子轩', 22, '男', 3, '语言系', '1';
    @Test
    public void InputData() throws SQLException {
        // 通过 Widgets 工具中的 JDBCWidgets 工具类获取连接
        Connection oCon = JDBCWidgets.getConnection();

        // 获取 Sta 对象
        Statement oSta = oCon.createStatement();

        // 编写 SQL 语句
        String oSQLColumnAdd = "INSERT INTO oStudent(SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('胡子轩', 22, '男', 3, '语言系', '1' );";

        // 执行 SQL 语句
        int oI = oSta.executeUpdate(oSQLColumnAdd);

        // 查看返回语法
        System.out.println(oI);

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta);
    }

    // 更新操作, 将 oSchool 数据库下的 oStudent 表中 ID 为 5 的学生姓名更改为: 苏常青
    @Test
    public void ToUpDate() throws SQLException{

        Connection oCon = JDBCWidgets.getConnection();

        Statement oSta = oCon.createStatement();

        // 书写 MySQL 语句
        String oSQLReplaceIDName = "UPDATE oStudent SET SName = '苏常青' WHERE SID = 5;";

        // 将内容传入 MySQL
        oSta.executeUpdate(oSQLReplaceIDName);

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta);
    }

    // 删除操作, 将 oSchool 数据库下的 oStudent 表中 ID 为 10 的学生删除
    @Test
    public void RemoveData() throws SQLException{

        Connection oCon = JDBCWidgets.getConnection();

        Statement oSta = oCon.createStatement();

        // 书写 MySQL 语句
        String oSQLRemoveID = "DELETE FROM oStudent WHERE SID = 10;";

        // 将内容传入 MySQL
        oSta.executeUpdate(oSQLRemoveID);

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta);

    }
}
