package com.jdbc.app;

import com.jdbc.dba.UserWidgets;
import com.jdbc.entity.User;
import com.jdbc.widgets.UserIDUtils;
import org.testng.annotations.Test;
import com.jdbc.widgets.DateUtils;

import java.sql.SQLException;

public class TestUserAPI {
    UserWidgets userWidgets = new UserWidgets();

    // 测试注册接口
    @Test
    public void testRegister() throws SQLException {
        // 创建 User
        User oUser = new User();
        oUser.setUId(UserIDUtils.getUserID());
        oUser.setUName("刘欣怡");
        oUser.setUSex("女");
        oUser.setUBirthday("2003-02-10");
        oUser.setUPassword("123456");
        oUser.setUPhone("12345678901");
        oUser.setUEmail("1122334455@qq.com");
        oUser.setUIDCard("242193200302101314");
        oUser.setUCreateTime(DateUtils.getDateFormart());

        // 注册用户
        int register = userWidgets.oRegister(oUser);

        // 判断结果
        if (register > 0) {
            System.out.println("恭喜 " + oUser.getUName() + " 注册成功!");
        } else {
            System.out.println("注册失败");
        }
    }

    // 测试登录接口
    @Test
    public void testLogin() throws SQLException {

        // 登录用户: 调用 UserWidgets 的 oLogin 方法
        User oUser = userWidgets.oLogin("胡媚娘", "123456");

        // 判断结果
        if (oUser != null) {
            System.out.println("恭喜 " + oUser.getUName() + " 登录成功!");
        } else {
            System.out.println("登录失败");
        }
    }
}
