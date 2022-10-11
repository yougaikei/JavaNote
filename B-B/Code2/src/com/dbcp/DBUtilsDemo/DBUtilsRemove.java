package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.apache.commons.dbutils.QueryRunner;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class DBUtilsRemove {
    @Test
    public void testDBUtils() throws SQLException {
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        // 编写占位符式的 SQL 语句

        String oSQLRemove = "DELETE FROM oEmployees WHERE EId = ?";

        // 设置占位符参数
        int oData_01 = 4;

        // 执行 UpDate 方法
        oQR.update(oSQLRemove, oData_01);
    }
}
