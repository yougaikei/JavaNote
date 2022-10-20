package com.create.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class oCreate01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String oUrl = "jdbc:mysql://localhost:3306/oSchoolData?characterEncoding=UTF-8";
        String oUser = "root";
        String oPass = "123456";

        Connection oData = DriverManager.getConnection(oUrl, oUser, oPass);

        //System.out.println(oData);

        Statement oStatement = oData.createStatement();

        // 创建一张 oClass 表
        String oSql = "CREATE TABLE oClassScheduleCard ( CSCId INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, CSCName INT NOT NULL, CSCStudent INT NOT NULL, CSCTeacher INT NOT NULL, CSCRemark varchar(50), CONSTRAINT IsClass FOREIGN KEY (CSCName) REFERENCES oCourse (CId), CONSTRAINT IsStudent FOREIGN KEY (CSCStudent) REFERENCES oStudent (SId), CONSTRAINT IsTeacher FOREIGN KEY (CSCTeacher) REFERENCES oTeacher (TId) );";
        int oI = oStatement.executeUpdate(oSql);

        System.out.println(oI);

        // 关闭流
        oStatement.close();
        oData.close();
    }
}
