package com.jdbc.dba;

import com.jdbc.entity.User;
import org.apache.commons.dbutils.QueryRunner;
import com.jdbc.widgets.DruidUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserWidgets {

    // 注册用户, 接收 User 对象
    public int oRegister(User user) throws SQLException {

        // A. 获取 QR 对象
        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);

        // B. 编写 SQL
        String sql = "INSERT INTO `User` VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        // D. 设置参数
        Object[] oData = {
                user.getUId(),
                user.getUName(),
                user.getUSex(),
                user.getUBirthday(),
                user.getUPassword(),
                user.getUPhone(),
                user.getUEmail(),
                user.getUIDCard(),
                user.getUCreateTime()
        };

        // 执行插入操作
        int update = qr.update(sql, oData);

        return update;
    }

    // 登录用户, 接收 UserName 和 PassWord
    public User oLogin(String UserName, String PassWord) throws SQLException {
        // A. 获取 QR 对象
        QueryRunner qr = new QueryRunner(DruidUtils.dataSource);

        // B. 编写 SQL
        String sql = "SELECT * FROM `User` WHERE `UName` = ? AND `UPassword` = ?";
        // D. 设置参数
        Object[] oData = {
                UserName,
                PassWord
        };

        // 执行查询操作
        User user = qr.query(sql, new BeanHandler<User>(User.class), oData);

        return user;
    }
}
