package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import com.dbcp.entiy.oEmployees;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBUtilsSearch {

    // 查询操作 ArrayHandler => WHERE EId = 8
    @Test
    public void testGetElementById() throws SQLException {

        // 创建一个 QueryRunner 对象
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        // 编写占位符式的 SQL 语句
        String oSQLSearch = "SELECT * FROM oEmployees WHERE EId = ?";
        Object[] oReturnData = oQR.query(oSQLSearch, new ArrayHandler(), 8);

        // 打印输出
        System.out.println(Arrays.toString(oReturnData));

    }

    // 查询操作 ArrayListHandler => SearchAll
    @Test
    public void testGetAllElements() throws SQLException {

        // 创建一个 QueryRunner 对象
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        // 编写占位符式的 SQL 语句
        String oSQLSearch = "SELECT * FROM oEmployees";
        List<Object[]> oReturnData = oQR.query(oSQLSearch, new ArrayListHandler());

        // 打印输出
        for( Object[] oData : oReturnData ) {
            System.out.println(Arrays.toString(oData));
        }

    }

    // 查询操作 BeanHandler => WHERE EId = 8
    @Test
    public void testGetJavaBeanById() throws SQLException {

        // 创建一个 QueryRunner 对象
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        // 编写占位符式的 SQL 语句
        String oSQLSearch = "SELECT * FROM oEmployees WHERE EId = ?";
        oEmployees oReturnData = oQR.query(oSQLSearch, new BeanHandler<oEmployees>(oEmployees.class), 8);

        // 打印输出
        System.out.println(oReturnData);

    }

    // 查询操作 BeanListHandler => SearchAll
    @Test
    public void testGetJavaBeanList() throws SQLException {

        // 创建一个 QueryRunner 对象
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        // 编写占位符式的 SQL 语句
        String oSQLSearch = "SELECT * FROM oEmployees WHERE ESalary > ?";
        List<oEmployees> oReturnData = oQR.query(oSQLSearch, new BeanListHandler<oEmployees>(oEmployees.class), 10000);

        // 打印输出
        for(oEmployees oData : oReturnData) {
            System.out.println(oData);
        }

    }

    // 查询操作 MapHandler => WHERE EName = "胡子轩"
    @Test
    public void testGetMapById() throws SQLException {

        // 创建一个 QueryRunner 对象
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        // 编写占位符式的 SQL 语句
        String oSQLSearch = "SELECT * FROM oEmployees WHERE EName = ?";
        Map<String, Object> oReturnData = oQR.query(oSQLSearch, new MapHandler(), "胡子轩");
        Set<Map.Entry<String, Object>> oReturnDataSetEntry = oReturnData.entrySet();

        // 打印输出
        for(Map.Entry<String, Object> oData : oReturnDataSetEntry) {
            System.out.println(oData.getKey() + " : " + oData.getValue());
        }
    }

    // 查询操作 ScalarHandler => SearchAll => GETESalarySum
    @Test
    public void testAllSalarySum() throws SQLException {

        // 创建一个 QueryRunner 对象
        QueryRunner oQR = new QueryRunner(DruidWidgets.getDataSource());

        // 编写占位符式的 SQL 语句
        String oSQLSearch = "SELECT SUM(ESalary) FROM oEmployees";
        Double oReturnData = (Double) oQR.query(oSQLSearch, new ScalarHandler<>());

        // 打印输出
        System.out.println("经合计, 工资总额为: " + oReturnData + "元");

    }

}
