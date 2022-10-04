package com.create.min;
// 链入自己的工具类
import com.create.widgets.JDBCWidgets;

// 链入 MySQL 工具类
import java.sql.*;
import java.util.Scanner;

public class RefuseIntrusionSQL01 {

    // RefuseIntrusionSQL -- 拒绝注入SQL语句
    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection oCon = JDBCWidgets.getConnection();

        // MySQL 语句; 使用 ? 占位符的方式去接收参数
        String oSQL = "SELECT * FROM oStudent WHERE SName = ? AND SPassword = ?";

        // 获取预处理对象
        PreparedStatement oPst = oCon.prepareStatement(oSQL);

        // 获取用户输入部分
        // 创建 oSta 对象
        Statement oSta = oCon.createStatement();
        Scanner oSca = new Scanner(System.in);
        System.out.println("请输入姓名: ");

        // 获取用户输入
        String oSName = oSca.nextLine();

        // 提示用户输入密码
        System.out.println("请输入密码: ");

        // 获取用户输入
        String oSPassword = oSca.nextLine();

        // 关闭 oSca 流
        oSca.close();

        // 设置参数 (问号的位置, 参数的值)
        oPst.setString(1, oSName);
        oPst.setString(2, oSPassword);

        // 执行 MySQL 查询语句; 此处使用的是预处理对象所以不需要传入 SQL 语句
        ResultSet oRes = oPst.executeQuery();

        // 判断结果
        if (oRes.next()){
            System.out.println("尊敬的用户: " + oSName + " 已成功登录!");
        }else{
            System.out.println("用户名或密码错误!请核对后再试!");
        }

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta, oRes);
    }
}
