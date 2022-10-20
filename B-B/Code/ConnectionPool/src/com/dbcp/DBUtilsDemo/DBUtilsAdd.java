package com.dbcp.DBUtilsDemo;
import com.dbcp.Widgets.DruidWidgets;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilsAdd {

    @Test
    public void testDBUtils() throws SQLException {
        QueryRunner oQR = new QueryRunner();

        // 编写占位符式的 SQL 语句
        /** oEmployees
         *  dataType:
         *    EName: String; ( 名前 )
         *    EGender: String;　( 性別 )
         *    EAge: int;　( 年齢 )
         *    EPhone: String;　( 電話番号 )
         *    EAddress: String;　( 住所 )
         *    EEmail: String;　( メールアドレス )
         *    EPassword: String;　( パスワード )
         *    EType: String;　( 勤務形態 )
         *    EStatus: byte;　( 勤務状態 1（在職）と0（離職）のみ )
         *    ESalary: double;　( 給与 )
         *    ECreateTime: Date;　( 登録日時 )
         *    EUpdateTime: Date;　( 更新日時 )
         */
        String oSQLAdd = "INSERT INTO oEmployees(EName, EGender, EAge, EPhone, EAddress, EEmail, EPassword, EType, EStatus, ESalary, ECreateTime, EUpdateTime) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        // 设置占位符参数
        Object[] oData = {"胡子轩", "男", 18, "13811620912", "安徽省蚌埠市", "17612311329@163.com", "000000", "造价员", 1, 5200.00, "2021-02-02", "2019-09-09"};

        // 执行 UpDate 方法
        Connection oCon = DruidWidgets.getConnection();
        int oIsRun = oQR.update(oCon, oSQLAdd, oData);

        // 释放资源
        DbUtils.closeQuietly(oCon);
    }
}
