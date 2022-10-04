package com.create.min;

// 引入自创工具类
import com.create.widgets.JDBCWidgets;

// 引入 MySQL 驱动包
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 引入 Java 输入类
import java.util.Scanner;

public class IntrusionSQL01 {

    // 演示SQL注入
    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection oCon = JDBCWidgets.getConnection();

        // 创建 oSta 对象
        Statement oSta = oCon.createStatement();

        // 获取用户输入
        Scanner oSca = new Scanner(System.in);

        // 提示用户输入
        System.out.println("请输入学生姓名: ");

        // 获取用户输入
        String oSName = oSca.nextLine();

        // 提示用户输入密码
        System.out.println("请输入密码: ");

        // 获取用户输入
        String oSPassword = oSca.nextLine();

        // 关闭 oSca 流
        oSca.close();

        // 编写 MySQL 语句
        String oSQLSearchStudent = "SELECT * FROM oStudent WHERE SName = '" + oSName + "' AND SPassword = '" + oSPassword + "';";

        // 执行 MySQL 查询语句
        ResultSet oRes = oSta.executeQuery(oSQLSearchStudent);

        // 处理结果集, 进行判断
        if(oRes.next()){
            System.out.println("尊敬的用户: " + oSName + " 已成功登录!");
        }else{
            System.out.println("用户名或密码错误!请核对后再试!");
        }

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta, oRes);
    }
}

/**
 *  A、正常登录
 *  胡子轩,
 *  123456
 *
 *  B、SQL注入
 *  ABCDEFG
 *  123456' OR '1' = '1
 * */
