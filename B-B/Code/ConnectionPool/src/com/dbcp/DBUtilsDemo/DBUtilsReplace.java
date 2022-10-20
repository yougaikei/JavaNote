package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.apache.commons.dbutils.QueryRunner;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DBUtilsReplace {
    // 替换方法
    @Test
    public void testDBUtilsReplace() throws SQLException {
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        String oSQLReplace = "UPDATE oEmployees SET ESalary  = ? WHERE EName = ?";
        Object[] oParamsReplace = { 13140.00 , "胡子轩"};

        // 自动模式不需要传入 Connection 对象
        oQR.update(oSQLReplace, oParamsReplace);

    }


}
