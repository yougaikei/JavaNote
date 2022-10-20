package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.apache.commons.dbutils.QueryRunner;

public class DBUtilsOne {

    // QueryRunner Demo
    public static void main(String[] args) {

        // One: Manual mode
        QueryRunner oQR = new QueryRunner();

        // Two: DataSource mode
        QueryRunner oQR2 = new QueryRunner(DruidWidgets.getDataSource());
    }

}
