package com.bind.JDBCAndXML.Widgets;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCWidgets {

    // 定义连接信息
    public static String DRIVERNAME;
    public static String URL;
    public static String USER;
    public static String PASSWORD;

    // 静态代码块，用于加载驱动
    static{
        SAXReader oReader = new SAXReader();
        try {
            // 读取 XML 配置文件
            Document oDocument = oReader.read("./src/com/bind/JDBCAndXML/Widgets/JDBXConfig.xml");

            // 获取连接信息 DRIVERNAME
            DRIVERNAME = oDocument.selectSingleNode("/jdbc/property[@name='driverClass']").getText();

            // 获取连接信息 URL
            URL = oDocument.selectSingleNode("/jdbc/property[@name='url']").getText();

            // 获取连接信息 USER
            USER = oDocument.selectSingleNode("/jdbc/property[@name='user']").getText();

            // 获取连接信息 PASSWORD
            PASSWORD = oDocument.selectSingleNode("/jdbc/property[@name='password']").getText();

            // 注册驱动
            Class.forName(DRIVERNAME);

        } catch (DocumentException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
           e.printStackTrace();
           return null;
        }
    }
}
