# JDBC 技术

---

## 1. 概述

- Java数据库连接，（Java Database Connectivity，简称JDBC）是Java语言中用来规范客户端程序如何来访问数据库的应用程序接口，提供了诸如查询和更新数据库中数据的方法。JDBC也是Sun Microsystems的商标。
- JDBC 是一套接口, 具体实现类是由厂商提供给我们的, 最终这些实现类被封成了一个 jar 包, 这个 jar 包就是整个数据库的驱动了。

---

## 2. 安装方法

- 将 MyJar 软件包放置于 D 盘下, 再用 IDEA 创建一个项目后, 配置项目的全局变量, 并将 MyJar 引入

<img src='./img/JDBC-01.png' alt='步骤-01' title="步骤-01" />
	
<img src='./img/JDBC-02.png' alt='步骤-02' title="步骤-02" />
	
<img src='./img/JDBC-03.png' alt='步骤-03' title="步骤-03" />
	
<img src='./img/JDBC-04.png' alt='步骤-04' title="步骤-04" />

---

## 3. 注册方式

- 创建一个新项目, 并在 src 目录下创建一个 软包, 在创建一个方法, 在方法中引入以下内容:

``` java
package com.create.jdbc;
import java.sql.DriverManager;

public class oCreate01{
    
    public static void main(String[] args) throws Exception{
        // 注册驱动 ( 可以省略, 现在暂时不建议 )
		Class.forName("com.mysql.jdbc.Driver");
    }
}
```

---

## 4. 连接方式

- 使用以下方式进行连接

```java
java.sql.Connection con = DriverManager.getConnection(String Url, String User, String PassWord)
```

- 注解

``` md
String Url
	说明: MySQL 的地址, 
	示例: 一般为 jdbc:mysql://localhost:3306/..?characterEncoding=UTF-8
String User
	说明: MySQL 的用户名,
	示例: 一般为 root
String PassWord
	说明: MySQL 的登录密码,
	示例: 一般为 123456
```

- 使用

```java
package com.create.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;

public class oCreate01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String oUrl = "jdbc:mysql://localhost:3306/oSchoolData?characterEncoding=UTF-8";
        String oUser = "root";
        String oPass = "123456";

        Connection oData = DriverManager.getConnection(oUrl, oUser, oPass);

        //System.out.println(oData);
    }
}
```

---

## 5. 获取语句执行对象

- 在 Java 执行 SQL 语句的方法, 再执行之前在数据库中创建 oSchool 数据库, 并创建 oTeacher 和 oStudent, oCourse 表单 ( 详见 ./code/CreateSchool.sql )

```java
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

        // 创建一张 oClass 表 => 此处是执行的语句
        String oSql = "";
        int oI = oStatement.executeUpdate(oSql);

        System.out.println(oI);

        // 关闭流
        oStatement.close();
        oData.close();
    }
}

```

- 创建 oClass 案例 ( 详见: ./Code/CreateClass.sql ):

```sql
CREATE TABLE oClassScheduleCard (
    -- ID （ IsKey ）
    CSCId INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -- 课程名称
    CSCName INT NOT NULL,
    -- 选课学生
    CSCStudent INT NOT NULL,
    -- 授课老师
    CSCTeacher INT NOT NULL,
    -- 备注
    CSCRemark varchar(50),
    -- 外键 01: 课程名称 与 oCourse 的 ID 关联
    CONSTRAINT IsClass FOREIGN KEY (CSCName) REFERENCES oCourse (CId),
    -- 外键 02: 选课学生 与 oStudent 的 ID 关联
    CONSTRAINT IsStudent FOREIGN KEY (CSCStudent) REFERENCES oStudent (SId),
    -- 外键 03: 授课老师 与 oTeacher 的 ID 关联
    CONSTRAINT IsTeacher FOREIGN KEY (CSCTeacher) REFERENCES oTeacher (TId)
)
```

---

## 6. 处理结果集

- 使用 java.sql.* 处理的查询返回结果为结果集对象, 在后期处理需要对其进行遍历, 并拼接

``` java
package com.create.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class oCreate02 {
    public static void main(String[] args) throws  Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 书写连接字符串
        String oUrl = "jdbc:mysql://localhost:3306/oSchoolData?characterEncoding=utf-8";

        // 获取连接
        Connection oCon = DriverManager.getConnection(oUrl, "root", "123456");

        // 获取语句执行平台
        Statement oSta = oCon.createStatement();

        // 执行sql语句: 查询 oSchoolData 数据库中的 oStudent 表中的所有数据
        String sql = "SELECT * FROM ostudent;";

        // 执行sql语句
        oSta.executeQuery(sql);

        // 获取返回值, 是结果集对象
        ResultSet oRes = oSta.executeQuery(sql);

        // 处理结果集对象
       //boolean oNext = oRes.next();
       //System.out.println(oNext);

        // 获取 ID
        //int oSId = oRes.getInt("SId");
        // 通过列名的方式获取
        //System.out.println("通过列名的方式获取: " + oSId);
        // 通过列号的方式获取
        //int oSId2 = oRes.getInt(1);
        //System.out.println("通过列号的方式获取: " + oSId2);

        // 通过 while 遍历结果集
        while(oRes.next()){
            // 获取 SId
            int SId = oRes.getInt("SId");
            // 获取 SName
            String SName = oRes.getString("SName");
            // 获取 SAge
            int SAge = oRes.getInt("SAge");
            // 获取 SSex
            String SSex = oRes.getString("SSex");

            // 输出
            System.out.println("ID: " + SId + " ; 姓名: " + SName + " ; 年龄: " + SAge + " ; 性别: " + SSex);
        }

       // Close
       oRes.close();
       oSta.close();
       oCon.close();


    }
}

```

---

## 7. 关闭流释放资源

- 在每回使用完资源后, 请记得按照顺序以此闭合

```java
package com.create.jdbc;
import java.sql.*;

public class oClose {
    public static void main(String[] args) {
        Connection oCon = null;
        Statement oSta = null;
        ResultSet oRes = null;
        try {

            oCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/oSchoolData?characterEncoding=utf-8", "root", "123456");

            oSta = oCon.createStatement();

            // 创建执行语句
            String oSql = "SELECT * FROM oStudent";

            // 执行语句
            oRes = oSta.executeQuery(oSql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                oRes.close();
                oSta.close();
                oCon.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

```

---

## 8. DIY 一个工具类

- 创建一个工具类来节约代码量

```java
package com.create.widgets;

import java.sql.*;

public class JDBCWidgets {

    // 将连接信息定义为字符串常量
    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";

    // MySQL Url 地址
    public static final String URL = "jdbc:mysql://localhost:3306/oSchoolData?characterEncoding=UTF-8";
    // MySQL User 用户名
    public static final String USER = "root";
    // MySQL PassWorld 密码
    public static final String PASSWORLD = "123456";

    // 静态代码块
    static {
        try{
            // 注册驱动
            Class.forName(DRIVERNAME);

        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection () {
        // 获取连接对象并返回
        try {
            Connection oCon = DriverManager.getConnection(URL, USER, PASSWORLD);
            return oCon;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 关闭资源方式
    public static void oClose(Connection oCon, Statement oSta) {

        if(oCon != null && oSta != null){
            try {
                oCon.close();
                oSta.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void oClose(Connection oCon, Statement oSta, ResultSet oRes) {

        if(oCon != null && oSta != null){
            try {
                oCon.close();
                oSta.close();
                oRes.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

```

---

## 9. 使用 自定义工具类

### 1. 创建数据

- 在之前我们使用了 oStatement.executeUpdate(String MySQL); 执行语句的对象, 现在我们直接使用自己创建的工具类去对数据库进行新增一条数据的书写:

```java
// 包名位置
package com.create.min;

// 链入自己的工具类
import com.create.Widgets.JDBCWidgets;
// 这里是 IDEA 自带的一个注解功能, 可以对代码块进行运行, 测试..
import org.junit.Test;
// 这里是 MySQL 工具类
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// 配置类
public class JDBCMin01 {
    
    // 插入操作:
    // 姓名, 年龄, 性别, 年级, 专业, 缴费状态
    // SName, SAge, SSex, SGrade, SDepartment, STuition;
    // '胡子轩', 22, '男', 3, '语言系', '1';
    @Test
    public void InputData() throws SQLException {
        // 通过 Widgets 工具中的 JDBCWidgets 工具类获取连接
        Connection oCon = JDBCWidgets.getConnection();

        // 获取 Sta 对象
        Statement oSta = oCon.createStatement();

        // 编写 SQL 语句
        String oSQLColumnAdd = "INSERT INTO oStudent(SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('胡子轩', 22, '男', 3, '语言系', '1' );";

        // 执行 SQL 语句
        int oI = oSta.executeUpdate(oSQLColumnAdd);

        // 查看返回语法
        System.out.println(oI);

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta);
    }
      
}
```

### 2. 更新操作

- 对数据库原有的内容进行更新迭代

```java
// 包名位置
package com.create.min;

// 链入自己的工具类
import com.create.Widgets.JDBCWidgets;
// 这里是 IDEA 自带的一个注解功能, 可以对代码块进行运行, 测试..
import org.junit.Test;
// 这里是 MySQL 工具类
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// 配置类
public class JDBCMin01 {
    
    // 插入操作:
    // 姓名, 年龄, 性别, 年级, 专业, 缴费状态
    // SName, SAge, SSex, SGrade, SDepartment, STuition;
    // '胡子轩', 22, '男', 3, '语言系', '1';
    // [ === 这里是 {{ 创建数据 }} === ]
    
    // 更新操作, 将 oSchool 数据库下的 oStudent 表中 ID 为 5 的学生姓名更改为: 苏常青
    @Test
    public void ToUpDate() throws SQLException{

        Connection oCon = JDBCWidgets.getConnection();

        Statement oSta = oCon.createStatement();

        // 书写 MySQL 语句
        String oSQLReplaceIDName = "UPDATE oStudent SET SName = '苏常青' WHERE SID = 5;";

        // 将内容传入 MySQL
        oSta.executeUpdate(oSQLReplaceIDName);

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta);
    }
}
```

### 3. 删除操作

- 对数据库的指定数据进行删除操作

```java
// 包名位置
package com.create.min;

// 链入自己的工具类
import com.create.Widgets.JDBCWidgets;
// 这里是 IDEA 自带的一个注解功能, 可以对代码块进行运行, 测试..
import org.junit.Test;
// 这里是 MySQL 工具类
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// 配置类
public class JDBCMin01 {
    
    // 插入操作:
    // 姓名, 年龄, 性别, 年级, 专业, 缴费状态
    // SName, SAge, SSex, SGrade, SDepartment, STuition;
    // '胡子轩', 22, '男', 3, '语言系', '1';
    // [ === 这里是 {{ 创建数据 }} === ]
    
    // 更新操作, 将 oSchool 数据库下的 oStudent 表中 ID 为 5 的学生姓名更改为: 苏常青
    // [ === 这里是 {{ 更新操作 }} === ]
    
    // 删除操作, 将 oSchool 数据库下的 oStudent 表中 ID 为 10 的学生删除
    @Test
    public void RemoveData() throws SQLException{

        Connection oCon = JDBCWidgets.getConnection();

        Statement oSta = oCon.createStatement();

        // 书写 MySQL 语句
        String oSQLRemoveID = "DELETE FROM oStudent WHERE SID = 10;";

        // 将内容传入 MySQL
        oSta.executeUpdate(oSQLRemoveID);

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta);

    }
}
```

---

## 10. 查询操作

- 同样使用自己创建的工具类进行查询操作

```java
// 包名
package com.create.min;
// 引入自己创建的工具类
import com.create.widgets.JDBCWidgets;
// 引入 MySQL 的工具类
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchData01 {

    // 查询数据: oSchool => oStudent => WHERE SName = '胡子轩';
    public static void main(String[] args) throws SQLException {
        // 获取连接
        Connection oCon = JDBCWidgets.getConnection();

        // 创建 oSta 对象
        Statement oSta = oCon.createStatement();

        // 编写 MySQL 语句
        String oSQLSearchStudentSNameHZX = "SELECT * FROM oStudent WHERE SName = '胡子轩';";

        // 执行 MySQL 查询语句
        ResultSet oRes = oSta.executeQuery(oSQLSearchStudentSNameHZX);

        // 处理结果集
        while (oRes.next()){
            // 获取数据
            int oSId = oRes.getInt("SId");
            String oSName = oRes.getString("SName");
            int oSAge = oRes.getInt("SAge");
            String oSSex = oRes.getString("SSex");
            int oSGrade = oRes.getInt("SGrade");
            String oSDepartment = oRes.getString("SDepartment");
            int oSTuition = oRes.getInt("STuition");

            // 输出数据
            System.out.println("学号: " + oSId);
            System.out.println("姓名: " + oSName);
            System.out.println("年龄: " + oSAge);
            System.out.println("性别: " + oSSex);
            System.out.println("年级: " + oSGrade);
            System.out.println("系别: " + oSDepartment);
            System.out.println("学费缴纳: " + (oSTuition == 1 ? "是" : "否"));
        }

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta, oRes);
    }
}

```

---

## 11. SQL 注入

- 利用 SQL 的查询语句进行注入
- 在测试之前请在 MySQL 中添加 SPassword 列 ( 详见: ./Code/CreatPwdColumn.sql )

```java
package com.create.min;

// 引入自创工具类
import com.create.widgets.JDBCWidgets;

// 引入 MySQL 驱动包
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 引入 Java 输入类
import java.util.Scanner;

public class IntrusionSQL01 {

    // 演示SQL注入
    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection oCon = JDBCWidgets.getConnection();

        // 创建 oSta 对象
        Statement oSta = oCon.createStatement();

        // 获取用户输入
        Scanner oSca = new Scanner(System.in);

        // 提示用户输入
        System.out.println("请输入学生姓名: ");

        // 获取用户输入
        String oSName = oSca.nextLine();

        // 提示用户输入密码
        System.out.println("请输入密码: ");

        // 获取用户输入
        String oSPassword = oSca.nextLine();

        // 关闭 oSca 流
        oSca.close();

        // 编写 MySQL 语句
        String oSQLSearchStudent = "SELECT * FROM oStudent WHERE SName = '" + oSName + "' AND SPassword = '" + oSPassword + "';";

        // 执行 MySQL 查询语句
        ResultSet oRes = oSta.executeQuery(oSQLSearchStudent);

        // 处理结果集, 进行判断
        if(oRes.next()){
            System.out.println("尊敬的用户: " + oSName + " 已成功登录!");
        }else{
            System.out.println("用户名或密码错误!请核对后再试!");
        }

        // 关闭流
        JDBCWidgets.oClose(oCon, oSta, oRes);
    }
}

/**
 *  A、正常登录
 *  胡子轩,
 *  123456
 *  尊敬的用户: 胡子轩 已成功登录!
 * ===========================
 *  B、SQL注入
 *  ABCD
 *  ABCD' OR '1' = '1
 *  尊敬的用户: ABCD 已成功登录!
 * */

```

---

## 12. 避免 SQL 注入

- 为了防止以上的情况的方式, 所以不能过于信任非普通用户的输入结果...如果要解决掉 SQL 注入的问题, 就不能让用户输入的内容和我们编译的 SQL 语句直接进行拼接
- 预处理对象: PrepareStatement 是一个预处理对象, 属于 Statement 接口的子接口, 该接口有预编译功能, 可以更好的执行 SQL 语句的效果, 并且通过占位符的方式设置参数可以有效的防止 SQL 注入

```java
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

```

---

## 13. JDBC 事务的方法

- 在使用 JDBC 事务方法的时候有三个事务管理的方法:
  - setAutoCommit(): 参数为 true || false, 表示关闭自动提交; 开关事务
  - commit(): 提交事务
  - rollback(): 回滚事务
- 在使用以上方式之前先创建一个模拟项目: 银行转账项目数据库, 为一会儿的测试做准备, 使用 MySQL 语句创建数据库和表, 并创建三个虚拟用户备用, 创建语句如下 ( 详见: ./Code/CreateBank.sql ):

``` sql
-- 创建一个银行的数据库
-- 1. 创建一个数据库
CREATE DATABASE bank CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 2. 在这个数据库中创建一个表 Users
CREATE TABLE Users(
    BId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    BName VARCHAR(20) NOT NULL,
    BAge INT NOT NULL,
    BGender VARCHAR(10) NOT NULL,
    BBirthday DATE NOT NULL,
    BPassword VARCHAR(20) NOT NULL,
    BBalance FLOAT NOT NULL,
    BPhone VARCHAR(20) NOT NULL,
    -- 设置 BType 只能是 0 或 1 [ 0: 借记卡, 1: 信用卡 ]
    BType TINYINT(1) NOT NULL CHECK(BType IN (0, 1)),
    -- 设置 BState 只能是 0 或 1 [ 0: 正常, 1: 锁定 ]
    BState TINYINT(1) NOT NULL CHECK(BState IN (0, 1))
);

-- 3. 创建 10 个虚拟用户
INSERT INTO Users(BName, BAge, BGender, BBirthday, BPassword, BBalance, BPhone, BType, BState) VALUES("刘思轩", 16, '女', '2004-01-01', '123456', 1000, '12822222901', 0, 0);
INSERT INTO Users(BName, BAge, BGender, BBirthday, BPassword, BBalance, BPhone, BType, BState) VALUES("李佳怡", 16, '女', '2008-02-22', '123456', 1000, '13141831301', 0, 0);
INSERT INTO Users(BName, BAge, BGender, BBirthday, BPassword, BBalance, BPhone, BType, BState) VALUES("林耀东", 22, '男', '2018-02-22', '123456', 99999, '1763625901', 0, 0);

```

- 使用方式如下:

```java
package com.create.min;
import java.sql.*;
import com.create.widgets.JDBCBank;

public class SQLWorkOne {

    public static void main(String[] args) {

        Connection oCon = null;
        PreparedStatement oPre = null;

        try {
            // 获取连接
            oCon = JDBCBank.getConnection();
            // 禁止自动提交
            oCon.setAutoCommit(false);

            // 配置转账当事人
            String oSQLRem = "UPDATE Users SET BBalance = BBalance - ? WHERE BName = ?;";
            oPre = oCon.prepareStatement(oSQLRem);
            oPre.setDouble(1, 1000.00);
            oPre.setString(2, "林耀东");
            oPre.executeUpdate();

            // 模拟异常
            //int i = 1 / 0;

            // 配置转账收取人
            String oSQLAdd = "UPDATE Users SET BBalance = BBalance + ? WHERE BName = ?;";
            oPre = oCon.prepareStatement(oSQLAdd);
            oPre.setDouble(1, 1000.00);
            oPre.setString(2, "刘思轩");
            oPre.executeUpdate();
            oCon.commit();

            // 提示: 转账成功
            System.out.println("转账成功!");

        } catch (SQLException e) {

            // 异常回滚事务
            try {
                oCon.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // 提示: 转账失败
            System.out.println("转账失败!");

            throw new RuntimeException(e);
        } finally {
            JDBCBank.oClose(oCon, oPre);
        }


    }
}

```

<b style="background-color: #E6A23C;color: white;border-radius:4px;padding: 5px;">※ 注意: <i style="text-decoration: underline;">如果需要使用自定义工具类, 记得新建一个工具类, 并修改里面的 SQL 地址指向 ( oSchoolData => oBank ) </i> </b>

---

# 连接池技术

---

## 1. 概述

- 连接池结束的作用是: 创建和管理一个连接的缓冲池，这些连接准备好被任何需要它们的线程使用
- 连接池技术可以管理数据库连接并可以重复的使用连接, 且在关闭连接的时候并不代表销毁掉 connection, 只会将连接进行归还

---

## 2. 准备操作

- 在正式演示连接池的功能之前, 需要创建所需的数据库, 本次将使用 MySQL 创建一个员工数据库( 详见: ./Code/CreateCompany.sql )

---

## 3. DBCP 连接池

- 本次将使用 DBCP 连接池, 该链接池为开源项目
- 添加 commons-dbcp-11.4.jar 和 commons-pool-1.5.6.jar 至之前创建的 MyJar 文件夹中
- 常见配置项:
  - DriverClassName: 数据可的驱动名称  ( * )
  - URL: 数据库地址  ( * )
  - Username: 账户名称  ( * )
  - Password: 账户密码  ( * )
  - MaxActive: 最大连接量
  - MaxIdle: 最大空闲连接
  - MinIdle: 最小空闲连接
  - initialSize: 初始化连接

---

## 4. 创建工具类

- 创建一个 DBCP 的工具类

```java
package com.dbcp.Widgets;

import org.apache.commons.dbcp.BasicDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPWidgetOne {

    // 数据库连接信息
    public static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/oCompany?characterEncoding=UTF-8";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456";

    // 数据库连接池
    public static BasicDataSource dataSource = new BasicDataSource();

    // 使用静态代码块初始化数据库连接池
    static {
        dataSource.setDriverClassName(DRIVERNAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    // 获取数据库连接
    public static Connection getConnection() throws SQLException {
        Connection oCon = dataSource.getConnection();
        return oCon;
    }

    // 释放数据库连接
    public static void oClose(Connection oCon, Statement oSta) {
        if (oCon != null && oSta != null) {
            try {
                oCon.close();
                oSta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 重载方法
    public static void oClose(Connection oCon, Statement oSta, ResultSet oRes) {
        if (oCon != null && oSta != null && oRes != null) {
            try {
                oCon.close();
                oSta.close();
                oRes.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

```

---

## 5. 测试工具类

```java
package com.dbcp.create;
import com.dbcp.Widgets.DBCPWidgetOne;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCPDemo {

    public static void main(String[] args) throws SQLException {

        // 从 DBCP 中获取连接
        Connection oCon = DBCPWidgetOne.getConnection();

        // 获取查询对象: Statement
        Statement oSta = oCon.createStatement();

        // 查询所有员工姓名
        String oSQLName = "SELECT EName FROM oEmployees";
        ResultSet oRex = oSta.executeQuery(oSQLName);

        int oCount = 0;
        // 遍历结果集
        while (oRex.next()) {
            ++oCount;
            System.out.println("第 " + (oCount > 9 ? oCount: ("0" + oCount))+ " 名是: " + oRex.getString("EName"));
        }

        // 关闭资源
        DBCPWidgetOne.oClose(oCon, oSta, oRex);
    }
}

```

---

## 6. C3P0连接池

- 将 c3p0-0.9.5.2.jar 引入到 MyJar 文件夹中, 并将 c3p0-config.xml 引入到当前目录下新建 public ( 公共 ) 文件中, <b style="color: red;">并配置内部的 SQL 地址! 且 c3p0-config.xml 这个名称时默认读取文件名, 请勿更改</b> 
- 配置项目
  - User: 账户名称  ( * )
  - Password: 账户密码  ( * )
  - DriverClass: 数据可的驱动名称  ( * )
  - JdbcURL: 数据库地址 ( * )
  - InitialPoolSize: 连接池初始化时创建的连接数 ( 默认为: 3 )
  - MaxPoolSize: 最大连接数 ( 默认为: 15 )
  - MinPoolSize: 最小连接数 ( 默认为: 10 )
  - MaxIdleTime: 连接的最大空闲时间, 某个数据库超过该时间还未使用则会断开该连接, 且如果为 0 则永远不会断开连接 ( 默认为: 0 )

---

## 7. 创建工具类

- 此处创建的是 C3P0 的工具类

```java
package com.dbcp.Widgets;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0WidgetsOne {

    // 创建连接池对象, C3P0 => DataSource API 的实现类
    public static ComboPooledDataSource oCPDS = new ComboPooledDataSource("mysql");

    // 获取连接池的方法
    public static Connection getConnection() throws Exception {
        return oCPDS.getConnection();
    }

    // 释放数据库连接
    public static void oClose(Connection oCon, Statement oSta) {
        if (oCon != null && oSta != null) {
            try {
                oCon.close();
                oSta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 重载方法
    public static void oClose(Connection oCon, Statement oSta, ResultSet oRes) {
        if (oCon != null && oSta != null && oRes != null) {
            try {
                oCon.close();
                oSta.close();
                oRes.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

```

---

## 8. 测试工具类

```java
package com.dbcp.create;
import com.dbcp.Widgets.C3P0WidgetsOne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class C3P0Demo {

    public static void main(String[] args) throws Exception {

        // 获取连接
        Connection oCon = C3P0WidgetsOne.getConnection();

         //获取语句执行平台
        String oSQLWHEREEName = "SELECT * FROM oEmployees WHERE EName = ?";
        PreparedStatement oPre = oCon.prepareStatement(oSQLWHEREEName);

        // 设置参数
        oPre.setString(1, "王子怡");

        // 执行SQL
        ResultSet oRes = oPre.executeQuery();

        // 查询返回的结果
        while (oRes.next()) {
            System.out.println("员工 ID: " + oRes.getInt("EId"));
            System.out.println("员工姓名: " + oRes.getString("EName"));
            System.out.println("员工性别: " + oRes.getString("EGender"));
            System.out.println("员工年龄: " + oRes.getInt("EAge"));
            System.out.println("员工电话: " + oRes.getString("EPhone"));
            System.out.println("员工地址: " + oRes.getString("EAddress"));
            System.out.println("员工邮箱: " + oRes.getString("EEmail"));
            System.out.println("员工密码: " + oRes.getString("EPassword"));
            System.out.println("员工类型: " + oRes.getString("EType"));
            System.out.println("员工状态: " + oRes.getByte("EStatus"));
            System.out.println("员工薪资: " + oRes.getDouble("ESalary"));
            System.out.println("员工入职时间: " + oRes.getDate("ECreateTime"));
            System.out.println("员工更新时间: " + oRes.getDate("EUpdateTime"));
        }

        // 释放资源
        C3P0WidgetsOne.oClose(oCon, oPre, oRes);
    }
}

```

---

## 9. Druid 连接池

- 该连接池是由阿里巴巴(alibaba)开发的号称为监控而生的数据库连接池, 且是目前最好的数据库连接池, 不论是从功能、性能、扩展性等方面都超越了其他的连接池, 且加入可日志监控, 可以很好的监控 DB 池连接和 SQL 的执行情况 ( 禁得住中国的双十一 [狗头保命] )
- 将 druid-1.0.0.jar 导入到 MyJar 文件夹中, 并将 druid.properties 文件放入 public ( 公共 ) 文件中, <b style="color: red;">并配置内部的 SQL 地址!</b>



---

## 10. 创建工具类

- 创建 Druid 连接池的工具类

```java
package com.dbcp.Widgets;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DruidWidgetsOne {
    
    // 定义成员变量
    public static DataSource dataSource;

    // 定义静态代码块
    static {

        try {
            // 创建属性集对象
            Properties oPro = new Properties();            
   
            // 获取配置文件
            InputStream oInp = DruidWidgetsOne.class.getClassLoader().getResourceAsStream("druid.properties");

            // 读取配置信息
            oPro.load(oInp);

            // 通过工厂类获取数据源
            dataSource = DruidDataSourceFactory.createDataSource(oPro);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 获取连接对象
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 释放数据库连接
    public static void oClose(Connection oCon, Statement oSta) {
        if (oCon != null && oSta != null) {
            try {
                oCon.close();
                oSta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 重载方法
    public static void oClose(Connection oCon, Statement oSta, ResultSet oRes) {
        if (oCon != null && oSta != null && oRes != null) {
            try {
                oCon.close();
                oSta.close();
                oRes.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

```

---

## 11. 测试工具类

``` java
package com.dbcp.create;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.dbcp.Widgets.DruidWidgetsOne;

public class DruidDemo {

    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection oCon = DruidWidgetsOne.getConnection();

        // 获取连接对象
        Statement oSta = oCon.createStatement();

        // 查询 WHERE ESalary:5000 - 10000 之间的数据
        String oSQL = "SELECT EName FROM oEmployees WHERE ESalary BETWEEN 5000 AND 10000";

        // 执行查询
        ResultSet oRex = oSta.executeQuery(oSQL);

        // 遍历结果集
        while (oRex.next()) {
            System.out.println(oRex.getString("EName"));
        }

        // 关闭资源
        DruidWidgetsOne.oClose(oCon, oSta, oRex);
    }
}

```

---

## 12. DBUtils 工具类

- Commons DBUtils 是 Apache 组织提供的一个对 JDBC 进行建议封装的开源工具类库, 使用 JDBC 应用程序时使用该工具类可以大幅提升程序的开发速度, 且不会影响性能
- 使用方便: 使用时需要项目导入 commons-dbutils-1.6.jar 包, 内部提供了专属的 SQL 语句操作的 API ( QueryRunner )

---

## 13. 封装数据库类

- 封装一个数据库类组件, JavaBean 就是一个类, 开发中通常会封装这样的一个类, 它可以实现:

  - 序列化 API, Serializable

  - 提供私有字段: 

    ```java
    private Type( 类型 ) Name( 变量名 );
    ```

  - 提供 getter 和 setter 方法, 且需要提供空参构造函数

```java
package com.dbcp.entiy;

import java.io.Serializable;
import java.util.Date;

public class oEmployees implements Serializable {
    /** oEmployees
     *  dataType:
     *    EId: int; ( ID is Key )
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

    private int EId;
    private String EName;
    private String EGender;
    private int EAge;
    private String EPhone;
    private String EAddress;
    private String EEmail;
    private String EPassword;
    private String EType;
    private byte EStatus;
    private double ESalary;
    private Date ECreateTime;
    private Date EUpdateTime;

    // 空参
    public oEmployees() {
    }

    public int getEId() {
        return EId;
    }

    public void setEId(int EId) {
        this.EId = EId;
    }

    public String getEName() {
        return EName;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public String getEGender() {
        return EGender;
    }

    public void setEGender(String EGender) {
        this.EGender = EGender;
    }

    public int getEAge() {
        return EAge;
    }

    public void setEAge(int EAge) {
        this.EAge = EAge;
    }

    public String getEPhone() {
        return EPhone;
    }

    public void setEPhone(String EPhone) {
        this.EPhone = EPhone;
    }

    public String getEAddress() {
        return EAddress;
    }

    public void setEAddress(String EAddress) {
        this.EAddress = EAddress;
    }

    public String getEEmail() {
        return EEmail;
    }

    public void setEEmail(String EEmail) {
        this.EEmail = EEmail;
    }

    public String getEPassword() {
        return EPassword;
    }

    public void setEPassword(String EPassword) {
        this.EPassword = EPassword;
    }

    public String getEType() {
        return EType;
    }

    public void setEType(String EType) {
        this.EType = EType;
    }

    public byte getEStatus() {
        return EStatus;
    }

    public void setEStatus(byte EStatus) {
        this.EStatus = EStatus;
    }

    public double getESalary() {
        return ESalary;
    }

    public void setESalary(double ESalary) {
        this.ESalary = ESalary;
    }

    public Date getECreateTime() {
        return ECreateTime;
    }

    public void setECreateTime(Date ECreateTime) {
        this.ECreateTime = ECreateTime;
    }

    public Date getEUpdateTime() {
        return EUpdateTime;
    }

    public void setEUpdateTime(Date EUpdateTime) {
        this.EUpdateTime = EUpdateTime;
    }

    // 全参
    public oEmployees(int EId, String EName, String EGender, int EAge, String EPhone, String EAddress, String EEmail, String EPassword, String EType, byte EStatus, double ESalary, Date ECreateTime, Date EUpdateTime) {
        this.EId = EId;
        this.EName = EName;
        this.EGender = EGender;
        this.EAge = EAge;
        this.EPhone = EPhone;
        this.EAddress = EAddress;
        this.EEmail = EEmail;
        this.EPassword = EPassword;
        this.EType = EType;
        this.EStatus = EStatus;
        this.ESalary = ESalary;
        this.ECreateTime = ECreateTime;
        this.EUpdateTime = EUpdateTime;
    }

    // toString
    @Override
    public String toString() {
        return "oEmployees{" +
                "EId=" + EId +
                ", EName='" + EName + '\'' +
                ", EGender='" + EGender + '\'' +
                ", EAge=" + EAge +
                ", EPhone='" + EPhone + '\'' +
                ", EAddress='" + EAddress + '\'' +
                ", EEmail='" + EEmail + '\'' +
                ", EPassword='" + EPassword + '\'' +
                ", EType='" + EType + '\'' +
                ", EStatus=" + EStatus +
                ", ESalary=" + ESalary +
                ", ECreateTime=" + ECreateTime +
                ", EUpdateTime=" + EUpdateTime +
                '}';
    }
}

```

---

## 14. 创建 QR 核心类方法

- 创建 QR 核心类的方法:

```java
// A、为 DruidWidgets 封装一个 getDatasOURE() 方法

// 获取对象连接池的方法
    public static DataSource getDataSource() {
        return dataSource;
    }
```

- 接下来创建 QueryRunner 核心类

```java
package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.apache.commons.dbutils.QueryRunner;

public class DBUtilsOne {

    // QueryRunner Demo
    public static void main(String[] args) {

        // One: Manual mode ( 手动方法 )
        QueryRunner oQR = new QueryRunner();

        // Two: DataSource mode ( 自动方法 )
        QueryRunner oQR2 = new QueryRunner(DruidWidgets.getDataSource());
    }

}

```

---

## 15. 添加方法

- 使用 QueryRunner 核心类对 MySQL 进行数据新增的方式

```java
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
        String oSQLAdd = "INSERT INTO oEmployees(EName, EGender, EAge, EPhone, EAddress, EEmail, EPassword, EType, EStatus, ESalary, ECreateTime, EUpdateTime) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // 设置占位符参数
        Object[] oData = {"胡子轩", "男", 18, "13811620912", "安徽省蚌埠市", "17612311329@163.com", "000000", "造价员", 1, 5200.00, "2021-02-02", "2019-09-09"};

        // 执行 UpDate 方法
        Connection oCon = DruidWidgets.getConnection();
        int oIsRun = oQR.update(oCon, oSQLAdd, oData);

        // 释放资源
        DbUtils.closeQuietly(oCon);
    }
}

```

---

## 16. 修改操作

- 使用 QueryRunner 对原有数据进行修改

```java
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

```

---

## 17. 删除操作

- 使用 QueryRunner 对数据进行删除

```java
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

```

---

## 18. 查询操作

- 使用 QueryRunner 对数据进行查询
- ResultSetHandler API:
  - ArrayHandler: 将结果集中的第一条记录封装到一个 Obj 数组中, 数组中的每一个元素就是它的每一个字段
  - ArrayListHandler: 将结果集中的每一条记录都封装到 Obj 数组中, 将这些数组封装在一个 List 集合内
  - BeanHandler: 将结果集中的第一条数据封装到一个指定的 JavaBean 中
  - BeanListHandler: 将结果集中的每一条数据都封装到指定的 JavaBean 中, 再将这些 JavaBean 数据封装到一个 List 集合内
  - ColumnListHandler: 将结果集中指定的列字段值封装到一个 List 集合内
  - KeyedHandler: 将结果集中的每一条记录封装到 Map< String, Object > , 再将这个 Map 集合作为另一个 Map 的 Value, 另一个 Map 集合的 Key 就是指定的字段值
  - MapHandler: 将结果集中第一条数据封装到 Map < Str, Obj > 集合中, key 就是字段名称, Value 就是字段值, 再将这些 Map 封装到一个 List 集合中
  - ScalarHandler: 用于封装单个数据, 如表查询操作等

### 1. ArrayHandler 的使用

- 此处将使用 ArrayHandler 查询 oEmployees 表中 ID 为 8 的用户

```java
package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;

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

}

```

### 2. ArrayListHandler 的使用

- 本次将使用 ArrayListHandler 查询 oEmployees 表中的所有数据

```java
package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBUtilsSearch {

    // 查询操作 ArrayHandler => WHERE EId = 8
    // 此处省略沉余的查询操作( 详见: 18.1 ArrayHandler 的使用 )...

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

}

```

### 3. BeanHandler 的使用

- 此处将使用 BeanHandler 查询 oEmployees 表中 ID 为 8 的用户, 并将它封装到指定的 JavaBean 中

```java
package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import com.dbcp.entiy.oEmployees;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBUtilsSearch {

    // 查询操作 ArrayHandler => WHERE EId = 8
    // 此处省略沉余的查询操作( 详见: 18.1 ArrayHandler 的使用 )...

    // 查询操作 ArrayListHandler => SearchAll
    // 此处省略沉余的查询操作( 详见: 18.2 ArrayListHandler 的使用 )...

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

}

```

### 4. BeanListHandler 的使用

- 本次将使用 BeanListHandler 查询 oEmployees 表中的工资 (  ) 大于 1W 的数据, 并封装到 JavaBean 中

```java
package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import com.dbcp.entiy.oEmployees;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class DBUtilsSearch {

    // 查询操作 ArrayHandler => WHERE EId = 8
    // 此处省略沉余的查询操作( 详见: 18.1 ArrayHandler 的使用 )...

    // 查询操作 ArrayListHandler => SearchAll
    // 此处省略沉余的查询操作( 详见: 18.2 ArrayListHandler 的使用 )...

    // 查询操作 BeanHandler => WHERE EId = 8
    // 此处省略沉余的查询操作( 详见: 18.3 BeanHandler 的使用 )...
    
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

}

```

### 5. MapHandler 的使用

- 本次将使用 MapHandler 查询 oEmployees 表中姓名为 胡子轩 的用户, 并封装到 Map 中

```java
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
    // 此处省略沉余的查询操作( 详见: 18.1 ArrayHandler 的使用 )...

    // 查询操作 ArrayListHandler => SearchAll
    // 此处省略沉余的查询操作( 详见: 18.2 ArrayListHandler 的使用 )...

    // 查询操作 BeanHandler => WHERE EId = 8
    // 此处省略沉余的查询操作( 详见: 18.3 BeanHandler 的使用 )...
    
    // 查询操作 BeanListHandler => SearchAll
    // 此处省略沉余的查询操作( 详见: 18.4 BeanListHandler 的使用 )...

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


}

```

### 6. ScalarHandler 的使用

- 本次将使用 ScalarHandler 查询 oEmployees 表中所有人, 并计算出这些人工资的总和

```java
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
    // 此处省略沉余的查询操作( 详见: 18.1 ArrayHandler 的使用 )...

    // 查询操作 ArrayListHandler => SearchAll
    // 此处省略沉余的查询操作( 详见: 18.2 ArrayListHandler 的使用 )...

    // 查询操作 BeanHandler => WHERE EId = 8
    // 此处省略沉余的查询操作( 详见: 18.3 BeanHandler 的使用 )...
    
    // 查询操作 BeanListHandler => SearchAll
    // 此处省略沉余的查询操作( 详见: 18.4 BeanListHandler 的使用 )...

    // 查询操作 MapHandler => WHERE EName = "胡子轩"
    // 此处省略沉余的查询操作( 详见: 18.5 MapHandler 的使用 )...

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

```

---

## 19. 批量处理

- 使用前需要对 druid.properties 文件添加开启批处理操作

```properties
driverClassName=com.mysql.jdbc.Driver
# 开启批处理: rewriteBatchedStatements=true
url=jdbc:mysql://localhost:3306/oCompany?characterEncoding=UTF-8&rewriteBatchedStatements=true
username=root
password=123456
initialSize=5
maxActive=10
maxWait=3000
```

- 创建一个批量添加的测试表 ( 详见: ./Code/CreateBatch.sql )

```sql
-- 创建一个批量新建表单
CREATE TABLE oBatch (
    BId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    BName VARCHAR(20)
);
```

- 创建完成后开始书写 Java 程序

```java
package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLBatchAdd {

    // 目标: 向 SQL 中批量添加 100 条数据
    public static void main(String[] args) throws SQLException {

        // 获取连接
        Connection oCon = DruidWidgets.getConnection();

        // 创建预处理语句
        String oSQLDataAdd = "INSERT INTO oBatch(BName) VALUES(?)";
        PreparedStatement oPre = oCon.prepareStatement(oSQLDataAdd);

        // 批量添加数据
        for(int i = 0; i < 100; i++){
            oPre.setString(1, "Tom" + (i < 10 ? "0" + i : i));

            // 添加到批处理
            oPre.addBatch();
        }

        // 添加时间戳
        long oRunTime = System.currentTimeMillis();

        // 执行批处理
        oPre.executeBatch();

        // 添加时间戳
        long oEndTime = System.currentTimeMillis();

        // 打印时间
        System.out.println("批量添加 100 条数据, 耗时: " + (oEndTime - oRunTime) + " (ms)毫秒");

        // 释放资源
        DruidWidgets.oClose(oCon, oPre);

    }
}

```

---

## 20. 元数据

- 元数据是指那些除了表外的数据, 大致可以分为三类:
  - 查询的结果信息: DELETE ( 删除 ) 和 UPDATE ( 修改 ) 语句收到影响的记录数
  - 数据库信息和表的信息: 包含数据库以及表的结构
  - MySQL 服务器信息: 包含数据库服务器当前状态, 版本号等

- 常用命令:

```sql
-- 1. 查看服务器当前状态
SHOW STATUS;

-- 2. 查看 MySQL 的版本信息
SELECT VERSION();

-- 3. 查询表中的详细信息
SHOW COLUMNS FROM 表名称;

-- 4. 显示数据表的详细索引信息
SHOW INDEX FROM 表名称;

-- 5. 列出所有数据库
SHOW DATABASES;

-- 6. 显示当前数据库所有表
SHOW TABLES;

-- 7. 获取当前的数据库名称
SELECT DATABASE();

```

---

## 21. JDBC 获取元数据

- 使用 JDBC 获取元数据的类:
  - DatabaseMetaData: 描述数据库的元数据对象 ( Connection 获取 )
    - getURL(): 获取数据库的 URL
    - getUserName(): 获取当前数据库的用户名
    - getDatabaseProductName(): 获取数据库的产品名称
    - getDatabaseProductVersion(): 获取数据库的版本号
    - getDriverName(): 获取数据库驱动程序的名称
    - isReadOnly(): 判断数据库是否只允许只读, ( if return true{ "只读" } )
  - ResultSetMetaData: 描述结果集的元数据对象 ( PrepareStatement 获取 )
    - getColumnCount(): 当前结果集的列数
    - getColumnName( int i ): 获取指定列号的名字, 且参数从 1 开始 <b style='color: red'>[ ※ 注意: 参数 int 为整数 ]</b> 
    - getColumnTypeName( int i ): 获取指定列号的类型, 且参数从 1 开始 <b style='color: red'>[ ※ 注意: 参数 int 为整数 ]</b> 
- 获取元数据对象的方法:  getMetaData();

### 1. DatabaseMetaData

- 使用 Connection => .getMetaData() => .*  获取 MySQL 数据库的元数据信息 ( 星号 '*' 代表上方的各个方法 )

```java
package com.dbcp.DBUtilsDemo;
import com.dbcp.Widgets.DruidWidgets;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class getSQLByConnection {

    // 获取数据库元数据信息 通过 DatabaseMetaData
    @Test
    public void getSQLByConnection() throws Exception {

        // 获取数据库连接
        Connection oCon = DruidWidgets.getConnection();

        // 获取数据库元数据
        DatabaseMetaData oDBMD = oCon.getMetaData();

        // 获取数据库的地址
        String oUrl = oDBMD.getURL();
        System.out.println("数据库地址为: " + oUrl);

        // 获取用户信息
        String oUserName = oDBMD.getUserName();
        System.out.println("数据库用户名为: " + oUserName);

        // 获取产品名称
        String oProductName = oDBMD.getDatabaseProductName();
        System.out.println("数据库产品名称为: " + oProductName);

        // 获取数据库版本
        String oProductVersion = oDBMD.getDatabaseProductVersion();
        System.out.println("数据库版本为: " + oProductVersion);

        // 获取数据库驱动名称
        String oDriverName = oDBMD.getDriverName();
        System.out.println("数据库驱动名称为: " + oDriverName);

        // 获取数据库是否为只读 if true 只读 else 可写
        boolean oReadOnly = oDBMD.isReadOnly();
        System.out.println("数据库是否为只读: " + oReadOnly);

        // 4. 释放资源
        oCon.close();
    }
}

```

### 2. ResultSetMetaData

- 使用 Connection => .prepareStatement() => .executeQuery() =>  .getMetaData() => .* 获取 MySQL 数据库表的结果集元数据信息 ( 星号 '*' 代表上方的各个方法 )

```java
package com.dbcp.DBUtilsDemo;

import com.dbcp.Widgets.DruidWidgets;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class getSQLByPrepareStatement {

    // 获取表元信息 通过 ResultSetMetaData
    @Test
    public void getSQLByPrepareStatement() throws Exception {

        // 获取数据库连接
        Connection oCon = DruidWidgets.getConnection();

        // 获取预处理对象
        PreparedStatement oRre = oCon.prepareStatement("SELECT * FROM oEmployees");

        // 获取结果集
        ResultSet oRes = oRre.executeQuery();

        // 获取结果集元数据
        ResultSetMetaData oRSMD = oRes.getMetaData();

        // 分隔符
        System.out.println("=================== 列 数 =================");

        // 获取列数
        int oColumnCount = oRSMD.getColumnCount();
        System.out.println("列数为: " + oColumnCount);

        // 分隔符
        System.out.println("=================== 列 名 =================");

        // 获取列名
        for (int i = 1; i <= oColumnCount; i++) {
            String oColumnName = oRSMD.getColumnName(i);
            System.out.println("列名为: " + oColumnName);
        }

        // 分隔符
        System.out.println("=================== 类 型 =================");

        // 获取列类型
        for (int i = 1; i <= oColumnCount; i++) {
            String oColumnType = oRSMD.getColumnTypeName(i);
            System.out.println("列类型为: " + oColumnType);
        }

        // 释放资源
        DruidWidgets.oClose(oCon, oRre, oRes);

    }
}

```

---

# XML

## 1. 概述

- XML ( Extensible Markup Language ) 可扩展标记语言

---

## 2. 存储方式

### 1. properties

- 详见: ./Code/oData.properties

```properties
id = 1
name = 陈一凡
age = 18
sex = 男

id = 2
name = 刘世明
age = 20
sex = 男

id = 3
name = 胡雨欣
age = 19
sex = 女

```

### 2. XML

-详见: ./Code/oData.xml

```xml
<?xml verison="1.0" encoding="utf-8"?>
<user id="1">
    <name>陈一凡</name>
    <age>18></age>
    <sex>男</sex>
</user>
<user id="2">
    <name>刘世明</name>
    <age>20</age>
    <sex>男</sex>
</user>
<user id="3">
    <name>胡雨欣</name>
    <age>19</age>
    <sex>女</sex>
</user>
```

### 3. JSON

- 详见: ./Code/oData.json

```json
{
    "user": [
        {
            "id": 1,
            "name": "陈一凡",
            "age": 18,
            "sex": "男"
        },
        {
            "id": 2,
            "name": "刘世明",
            "age": 20,
            "sex": "男"
        },
        {
            "id": 3,
            "name": "胡雨欣",
            "age": 19,
            "sex": "女"
        }
    ]
}
```

### 4. YAML

- 详见: ./Code/oData.yaml

```YAML
user:
  -
  	 id: 1
     name: 陈一凡
     age: 18
     sex: 男
  -
  	id: 2
    name: 刘世明
    age: 20
    sex: 男
  -
  	id: 3
    name: 胡雨欣
    age: 19
    sex: 女
```

---

## 3. XML 约束

- XML 文档可以使用约束来规范标签, 约束分为两种:
  - DTD 约束
  - Schema 约束

### 1. DTD 约束

- 书写一个约束

```dtd
<!ELEMENT students (student+)>
    <!ELEMENT student ( name, age, sex )>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT age (#PCDATA)>
    <!ELEMENT sex (#PCDATA)>
    <!ATTLIST student id ID #REQUIRED>

```

#### 1) 说明文档 

- 预解析内容:
  - PCDATA ( Parsed Character Data ): 意思是被解析的字符数据, 且该数据是会被解析器解析的文本, 这些文本将被解析器检查实体以及标记, 文本中的标签会被当作标记处理, 而实体则会被展开, 需要注意的是: 被解析的数据中不应包含 < 左尖括号,  > 右尖括号, & 与符号, 但可以使用 <b style="color: red;text-decoration: underline;">& 与符号 => \&amp;</b> || <b style='color: red;text-decoration: underline;'>< 左尖括号 => \&lt;</b> || <b style="color: red;text-decoration: underline;">\> 右尖括号 => \&gt; 来代替</b> 
  - CDATA ( Character Data ): 意思是字符数据, 是不会被解析器解析的文本, 在这些文本中的标签会被当作标记来对待,其中的实体也不会被展开
- 声明元素

```dtd
<!-- 创建元素 -->

<!-- A. 使用 <!ELEMENT 元素名 类别> 创建元素 -->
<!--
    类别有:
        EMPTY: 空元素
        ANY: 任意元素
        #PCDATA: 文本元素
        (子元素1, 子元素2, 子元素3, ...): 由子元素组成的元素
-->
<!ELEMENT Students EMPTY>
<!ELEMENT Students ANY>
<!ELEMENT Students (#PCDATA)>
<!ELEMENT Student (name, age, ..., sex)>

<!-- B. 使用 <!ELEMENT 元素名 (子元素<?>)> 创建元素 -->
<!--
    子元素有:
        子元素名: 子元素
        子元素名?: 可选子元素, 0个或1个
        子元素名*: 0个或多个子元素, 可以没有
        子元素名+: 1个或多个子元素, 但至少有一个
-->

<!ELEMENT Students (Student)>

<!--
    <Students>
        <Student></Student> // 证明 Student 必须出现一次, 且要在 Students 中出现
    </Students>
-->

<!ELEMENT Students (Student?)>

<!--
    <Students>
        <Student></Student> // 要么出现一次, 要么不出现
    </Students>
-->

<!ELEMENT Students (Student*)>

<!--
    <Students>
        <Student></Student> // 并没有限制个数, 即使是该项也是可选项
        <Student></Student>
        <Student></Student>
    </Students>
-->


<!ELEMENT Students (Student+)>

<!--
    <Students>
        <Student></Student> // 这个是至少要有一个的, 下面的是可选项
        ...
        <Student></Student>
    </Students>
-->

<!-- C. 选择性创建元素 -->
<!--
    <!ELEMENT 元素名 (子元素1, 子元素2, (子元素3-1 | 子元素3-2))>
    表示: 子元素1 和 子元素2 必须出现, 子元素3-1 或 子元素3-2 必须出现其中一个
-->
<!ELEMENT Student (name, age, (Phone | Landline))>

<!--
    <Student>
        <name>张三</name>
        <age>18</age>
        <Phone>123456789</Phone> // 此项或 Landline 的其中一个必须出现
    </Student>

    或者:

    <Student>
        <name>张三</name>
        <age>18</age>
        <Landline>123456789</Landline> 此项或 Phone 的其中一个必须出现
    </Student>
-->
```

- 默认参数
  - #REQUIRED: 必须值
  - #IMPLIED: 非必须值
  - #FIXED value: 固定值, value 请自行替换
- 约束方法

```dtd
<!-- 规范元素 -->

<!-- 
    创建一个有 width 的元素:
    <!ELEMENT 元素名 类别> // 类别为: EMPTY( 空元素 ) | ANY( 任意元素 ) | #PCDATA( 文本元素 )
    <!ATTLIST 元素名 属性 CDATA "默认值"> // CDATA 为: 字符串
 -->
<!ELEMENT Students (Student+)>
<!ATTLIST Students width CDATA "0">

<!--
// 如果 Students 被定义为带有 CDATA 类型, 且 width 属性的空元素。如果宽度没有被设定，其默认值为0 。
<Students width="0">
    <student></student>
    ...
    <student></student>
</Students>

或者

<Students width>
    <student></student>
    ...
    <student></student>
</Students>
-->

<!--
    创建一个非强制属性的元素:
    <!ELEMENT 元素名 类别> // 类别为: EMPTY( 空元素 ) | ANY( 任意元素 ) | #PCDATA( 文本元素 )
    <!ATTLIST 元素名 属性 CDATA "默认值" #IMPLIED> // #IMPLIED 为: 非强制属性; CDATA 为: 字符串
-->

<!ELEMENT Students (Student+)>
<!ATTLIST Students width CDATA #IMPLIED>

<!--
    <Students>
        <student></student>
        ...
        <student></student>
    </Students>

    或 ( 此处的 width 属性为非强制属性 ):

    <Students width="0">
        <student></student>
        ...
        <student></student>
    </Students>

-->

<!--
    创建一个带有固定属性的元素 ( 但没有默认值 ):
    <!ELEMENT 元素名 类别> // 类别为: EMPTY( 空元素 ) | ANY( 任意元素 ) | #PCDATA( 文本元素 )
    <!ATTLIST 元素名 属性 CDATA #REQUIRED> // #REQUIRED 为: 固定属性; CDATA 为: 字符串
-->

<!ELEMENT Students (Student+)>
<!ATTLIST Students width CDATA #REQUIRED>

<!--
    <Students width="0"> // 此处必须为 width 属性赋值, 且该属性为固定属性 ( 属性值不能为空 ), 必须存在
        <student></student>
        ...
        <student></student>
    </Students>
-->

<!--
    创建一个带有固定属性, 属性值的元素:
    <!ELEMENT 元素名 类别> // 类别为: EMPTY( 空元素 ) | ANY( 任意元素 ) | #PCDATA( 文本元素 )
    <!ATTLIST 元素名 属性名 属性类型 #FIXED 固定值>
-->

<!ELEMENT Students (Student+)>
<!ATTLIST Students width CDATA #FIXED "50">

<!--
    <Students width="50"> // 此处的 width 属性为固定属性, 且属性值为 50, 且该属性值不能被修改
        <student></student>
        ...
        <student></student>
    </Students>
-->

<!--
    创建一个带有选择属性的元素:
    <!ELEMENT 元素名 类别> // 类别为: EMPTY( 空元素 ) | ANY( 任意元素 ) | #PCDATA( 文本元素 )
    <!ATTLIST 元素名 属性名 ( 属性值1 | 属性值2 | ... | 属性值n ) 默认值>
-->

<!ELEMENT Students (Student+)>
<!ATTLIST Students width ( 0 | 50 | 100 ) "100">

<!--
    <Students width> // 此处的 width 属性为选择属性, 且默认属性值为 100, 可以从 0, 50, 100 中再做选择
        <student></student>
        ...
        <student></student>
    </Students>

    或者

    <Students width="0"> 
        <student></student>
        ...
        <student></student>
    </Students>

    或者

    <Students width="50"> 
        <student></student>
        ...
        <student></student>
    </Students>

    或者

    <Students width="100"> 
        <student></student>
        ...
        <student></student>
    </Students>
-->
```

#### 2) 解析文档

- 根据以上说明, 解析刚刚的 dtd 文件:

```dtd
<!--
    @ELEMENT: 定义元素
    students: 元素名称
    student+: 元素内容为一或多个student元素

    <!ELEMENT students (student+) =>
    <students>
        <student></student>
        第 n 个 student 元素 ...
        <student></student>
    </students>
 -->
<!ELEMENT students (student+)>

<!--
    student (子元素名称1, ..., 子元素名称n)
    ※ 注意: 子元素名称之间用逗号分隔, 且严格区分大小写, 严格按顺序排列
-->
    <!ELEMENT student ( name, age, sex )>

<!--
    #PCDATA: 定义元素内容为文本
    name || age || sex: 元素名称
-->
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT age (#PCDATA)>
    <!ELEMENT sex (#PCDATA)>

<!--
    @ATTRIBUTE: 定义属性
    student: 元素名称
    id: 属性名称 ( 可以改变: number, uid, ...)
    ID: 唯一属性值
    #REQUIRED: 属性必须出现

    <!ATTLIST student id ID #REQUIRED> =>
    <student id="1"></student>

    If: number ID #REQUIRED
    <student number="1"></student>

    ※ 以此类推
-->
    <!ATTLIST student id ID #REQUIRED>
```

### 2. Schema 约束

- schema 是 XML 文档约束的一种, 但会比 dtd 的约束更强, 内置多种简单或复杂的类型数据, 支持命名空间, 在一个 xml 文档中可以引入多个 schema 约束, 因为其本身也属于 xml 文档, 但它的后缀名为: xsd 文件

```sxd
<!-- schema 说明文档 -->
<!-- schema 是 xsd 文档的根元素 -->
<!-- 使用時： -->
<?xml version="1.0" encoding="UTF-8"?>
<xsd:schema 
    xmlns="http://www.newWeb.com/xml"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    targetNamespace="http://www.newWeb.com/xml"
    elementFormDefault="qualified"
></xsd:schema>

<!--
    详解:
        xmlns="指出默认的命名空间"
        xmlns:xs="显示 schema 中需要用到的 元素 和 数据类型来自命名空间的 URI, 且同时规定了这些元素和数据类型的前缀 xs || xsd"
        targetNamespace="指出了 schema 中定义的元素和类型所属的命名空间"
        elementFormDefault="qualified" 指出了任何 xml 实例文档中所使用了 schema 中定义的 元素 的必须被其限定
            unqualified: 元素的命名方式为: 元素名
            qualified: 元素的命名方式为: 前缀:元素名
-->

```

#### 1) 说明文档

- 元素信息:

```xsd
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema 
    xmlns="http://www.w3.org/2001/XMLSchema"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    targetNamespace="http://www.newWeb.com/xml"
    elementFormDefault="qualified"    
>

<!-- 创建一个 根 元素 -->
<xs:element name="students" type="xs:string" />
</xs:schema>

<!--
    详解:
        @name: 元素名的名称, 如上: xml => <students></students>
        @type: 元素的类型, 如上: string => <students>string</students>
            A. xs:string: 字符串类型
            B. xs:decimal: 十进制类型
            C: xs:integer: 整数类型
            D: xs:boolean: 布尔类型
            E: xs:date: 日期类型
            F: xs:time: 时间类型
        ※ 注: 当然也可以使用包含的形式去定义最终的类型
        
        <xs:element name="元素名" type="包含的元素名" />
        <xs:complexType name="包含的元素名">
            <xs:sequence>
                <xs:element name="元素名" type="元素类型" />
            </xs:sequence>
        </xs:complexType>

        @complexType: 复杂类型
        @sequence: 顺序

        拓展:
            
            单选值 ( 必须按照规定值书写 ): {
                @xs:simpleType: 简单类型
                    name: 被规定的类型名
                    @xs:restriction: 限制
                        base: 基础
                        @xs:enumeration: 枚举
                            value: 值
            }

        例子:
            <xs:element name="sex" type="sexType" />
            <xs:simpleType name="sexType">
                <sx:restriction base="xs:string">
                    <sx:enumeration value="男" />
                    <sx:enumeration value="女" />
                </sx:restriction>
            </xs:simpleType>
-->
<xs:element name="Bank" type="BankType" />
<xs:complexType name="BankType">
    <xs:sequence>
        <xs:element name="UserName" type="xs:string" />
        <xs:element name="PassWord" type="xs:string" />
        <xs:element name="Balance" type="xs:string" />
    </xs:sequence>
</xs:complexType>

<!--
    拓展:

        限制值 ( 必须按照规定值书写 ): {
            @xs:simpleType: 简单类型
                name: 被规定的类型名
                @xs:restriction: 限制
                    base: 基础
                    @xs:minInclusive: 最小值
                    @xs:maxInclusive: 最大值
        }

    例子:
        <xs:element name="age" type="ageType" />
        <xs:simpleType name="ageType">
            <sx:restriction base="xs:integer">
                <sx:minInclusive value="18" />
                <sx:maxInclusive value="60" />
            </sx:restriction>
        </xs:simpleType>
-->

<xs:element name="age" type="ageType" />
<xs:simpleType name="ageType">
    <sx:restriction base="xs:integer">
        <sx:minInclusive value="18" />
        <sx:maxInclusive value="60" />
    </sx:restriction>
</xs:simpleType>

<!--
    拓展:
        内容限制 ( 必须按照规定值书写 ): {
            @xs:simpleType: 简单类型
                name: 被规定的类型名
                @xs:restriction: 限制
                    base: 基础
                    @xs:pattern: 模式
                        value: 值
        }

    例子:
        <xs:element name="phone" type="phoneType" />
        <xs:simpleType name="phoneType">
            <sx:restriction base="xs:string">
                <sx:pattern value="data-/d{1,4}" /> // 表示: data-1~4位数字
            </sx:restriction>
        </xs:simpleType>

-->

<xs:element name="phone" type="phoneType" />
<xs:simpleType name="phoneType">
    <sx:restriction base="xs:string">
        <sx:pattern value="data-/d{1,4}" />
    </sx:restriction>
</xs:simpleType>

<!-- 限制值 string - 示例 -->
<xs:element name="phone" type="phoneType" />
<xs:simpleType name="phoneType">
    <sx:restriction base="xs:string">
        {{ 限制值体 }}
    </sx:restriction>
</xs:simpleType>

<sx:pattern value="data | date" />
<!-- ! 此方法说明的是: 该值要么是 data 要么是 date -->

<sx:pattern value="[A-Z][A-Z]"/>
<!-- ! 此方法说明的是: 该元素只能接受 2个 A ~ Z 的大写字母 -->

<sx:pattern value="[a-zA-Z][a-zA-Z]"/>
<!-- ! 此方法说明的是: 该元素只能接受 2个 a ~ z || A ~ Z 的大 ( 小 ) 写字母 -->

<sx:pattern value="[abc]"/>
<!-- ! 此方法说明的是: 该元素只能接受 a, b, c 的其中一个值-->

<sx:pattern value="o[A-Z]+"/>
<!-- ? 参考示例: odata -->
<!-- ! OData ( X ) -->
<!-- ! Odata ( X ) -->
<!-- ! ODATA ( X ) -->
<!-- ! odata ( X ) -->
<!-- * oData ( O ) -->
<!-- ! 此方法说明的是: 该元素只能接受 o 开头后面接大写字母的 -->

<sx:pattern value="[a-zA-Z0-9]{6}"/>
<!-- ! 此方法说明的是: 该元素只能接受 6个 a ~ z || A ~ Z || 0 ~ 9 的大 ( 小 ) 写字母 || 数字 混合体 -->

<!-- 限制值 integer - 数字示例 -->
<xs:element name="phone" type="phoneType" />
<xs:simpleType name="phoneType">
    <sx:restriction base="xs:integer">
        {{ 限制值体 }}
    </sx:restriction>
</xs:simpleType>

<sx:pattern value="[0-9][0-9]"/>
<!-- ! 此方法说明的是: 该元素只能接受 2个 0 ~ 9 的数字 -->

<sx:pattern value="[0-9]{1,4}"/>
<!-- ! 此方法说明的是: 该元素只能接受 1 ~ 4 个 0 ~ 9 的数字 -->

```

- 属性信息:

```xsd
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema 
    xmlns="http://www.atteriBute.com/xml"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    targetNamespace="http://www.atteriBute.com/xml"
    elementFormDefault="qualified">
    
<!-- 此处举例 students => student(dataBase) -->
<!-- 此处定义一个 students 元素, 类型 students 类型 -->
<xs:element name="students" type="studentsType"/>

<!-- 定义 students 类型 -->
<xs:complexType name="studentsType">
    <!-- 定义包含元素 -->
    <xs:sequence>
        <!-- 定义一个 student 元素, 类型为 student 类型 -->
        <xs:element name="student" type="studentType" minOccurs="0" maxOccurs="unbounded"/>
    </xs:sequence>
</xs:complexType>

<!-- 此处定义的是 student 类型 -->
<xs:complexType name="studentType">
    <!-- 定义包含元素 -->
    <xs:sequence>
        <!-- 定义一个 name 元素, 类型 String -->
        <xs:element name="name" type="xs:string"/>
    </xs:sequence>

    <!-- 此处给 student 标签赋值: A. 类型: String; B: use: 必须值 -->
    <xs:attribute name="id" type="xs:string" use="required"/>
    <!-- 定义默认值 <student id></student> -->
    <!-- <xs:attribute name="id" type="xs:string" default="dataBox"/> -->
    <!-- 定义指定值 <student id="dataBox"></student> -->
    <!-- <xs:attribute name="SName" type="xs:string" fixed="dataBox"/> -->
</xs:complexType>

</xs:schema>

<!-- 解析后的
<?xml version="1.0" encoding="UTF-8"?>
<students>
    <student id="1">
        <name>张三</name>
    </student>
    <student id="2">
        <name>李四</name>
    </student>
</students>
-->
```

---

## 4. 引入 dtd 文件

- 引入 dtd 文件有两种方式:
  1. 内部引入: 将约束规则定在 XML 文档中
  2. 外部引入: 将约束规则定在 XML 外部的 dtd 文件中
     - 本地引入 ( 外部引入 ): [ 详见下方方法 01 ]
     - 网络引入 ( 外部引入 ): [ 详见下方方法 02 ]

```xml
<!-- 方法 01 本地引入 -->
<?xml version="1.0" encoding="UTF-8" ?>
<!-- <!DOCTYPE 根元素的名称 SYSTEM "地址"> -->
<!DOCTYPE Students SYSTEM "Student.dtd">
<Students>
    <student></student>
    ...
    <student></student>
</Students>

<!-- 方法 02 网络引入 -->
<?xml version="1.0" encoding="UTF-8" ?>
<!-- <!DOCTYPE 根元素的名称 PUBLIC "文件名" "网络地址"> -->
<!DOCTYPE Students PUBLIC "Students.dtd" "https://www.xxx.com/xxx/Students.dtd"
```

---

## 5. 引入 schema 文件

- 直接新建一个 xsd 文件

```
<?xml version="1.0" encoding="UTF-8" ?>
<xsd:schema xmlns="http://www.newStudents.com/xml"
            xmlns:xsd="http://www.w3.org/2001/XMLSchema"
            targetNamespace="http://www.newStudents.com/xml"
            elementFormDefault="qualified">
    <xsd:element name="students" type="studentsType"/>
    <xsd:complexType name="studentsType">
        <xsd:sequence>
            <xsd:element name="student" type="studentType" minOccurs="0" maxOccurs="unbounded"/>
        </xsd:sequence>
    </xsd:complexType>
    <xsd:complexType name="studentType">
        <xsd:sequence>
            <xsd:element name="name" type="xsd:string"/>
            <xsd:element name="age" type="ageType" />
            <xsd:element name="sex" type="sexType" />
        </xsd:sequence>
        <xsd:attribute name="id" type="idType" use="required"/>
    </xsd:complexType>
    <xsd:simpleType name="sexType">
        <xsd:restriction base="xsd:string">
            <xsd:enumeration value="男"/>
            <xsd:enumeration value="女"/>
        </xsd:restriction>
    </xsd:simpleType>
    <xsd:simpleType name="ageType">
        <xsd:restriction base="xsd:integer">
            <xsd:minInclusive value="0"/>
            <xsd:maxInclusive value="100"/>
        </xsd:restriction>
    </xsd:simpleType>
    <xsd:simpleType name="idType">
        <xsd:restriction base="xsd:string">
            <xsd:pattern value="data_\d{1,}"/>
        </xsd:restriction>
    </xsd:simpleType>
</xsd:schema>

```

- 将该文件进行引入, 使用以下方式:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<students
        xmlns="http://www.newStudents.com/xml"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.newStudents.com/xml newStudents.xsd">
    <student id="data_19">
        <name>张三</name>
        <age>10</age>
        <sex>男</sex>
    </student>
</students>

```

---

## 6. XML 解析方式

- 如果想要获取到存储在 XML 中的数据, 就必须对 XML 文档进行解析, 但由于后期的需求不同, 有的需要读写、而有的需要只读即可的, 且如果使用 Java 又过于繁琐, 所以为了针对以上的不同需求, 并简化书写量, 于是就诞生以下两种方式:
  - DOM 解析: 将 XML 文档放到解析器中, 解析后会装载到内存中, 且会将其解析成一个 DOM ( document ) 对象( 优点: 元素与元素之间保留原有的结构关系, 可以进行增删改查操作; 缺点: 因为要保留最大的权限, 所以解析出来的 DOM 对象过大, 可能会出现内存溢出的现象 )
  - SAX 解析: 是一种速度快, 更有效的解析方法, 它会逐行扫描, 边扫描边解析; 且会以事件驱动的方式进行具体解析, 每一行都将会触发对应的事件( 优点: 占用内存小, 处理速度快, 具备处理大文件的能力; 缺点: 使用 SAX 解析的方式创建出来的数据均为只读数据, 读取后会自动释放资源 )

---

## 7. XML 解析器

- XML 解析器:
  1. DOM4J: 是一款十分优秀的 Java 解析 XML 的 API 工具, 具有性能优异、功能强大和极其易使用的特点, 它的性能超过 sun 公司官方的dom技术, 同时它也是一个开放源代码的软件
  2. Pull: 是一款 Android 内置的 XML 解析方式
  3. Jsoup: 是一款 Java 的 HTML 解析器, 同时也可以解析 XML 文档

---

## 8. DOM4J 解析器

- 需要引入 dom4j-1.6.1.jar 包

### 1) 获取元素

- 使用 DOM4J 获取 XML 文档中的元素

```java
package com.bind.DOM4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class DOM4JGetEle {

    // 获取 XML 文档中的元素 ( ./Students.xml )
    @Test
    public void getElement() throws DocumentException {

        // 获取文档解析对象
        SAXReader reader = new SAXReader();

        // 解析 XML 文档
        Document oDoc = reader.read("./src/com/bind/DOM4J/Students.xml");

        // 获取根元素
        Element oBasicEle = oDoc.getRootElement();

        // 获取根元素名称
        String sBasicEleName = oBasicEle.getName();

        // 打印根元素名称
        System.out.println("---------- 根元素 ----------");
        System.out.println("根元素名称: " + sBasicEleName);

        // 获取根元素下的子元素
        List<Element> elements = oBasicEle.elements();
        System.out.println("---------- 子元素 ----------");
        for (Element element : elements){
            System.out.println("子元素： " + element.getName());

            List<Element> InElements = element.elements();

            System.out.println("---------- 子元素内部的元素 ----------");
            for (Element InElement : InElements){
                System.out.println("子元素的子元素： " + InElement.getName());
            }
        }

    }

}

```

### 2) 获取内容

- 使用 DOM4J 获取 XML 文档中元素的内容

```java
package com.bind.DOM4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class DOM4JGetContent {

        // 获取 XML 文档中的元素内容 ( ./Students.xml )
        @Test
        public void getContent() throws DocumentException {

            // 获取文档解析对象
            SAXReader reader = new SAXReader();

            // 解析 XML 文档
            Document oDoc = reader.read("./src/com/bind/DOM4J/Students.xml");

            // 获取根元素
            Element oBasicEle = oDoc.getRootElement();

            // 获取子节点
            List<Element> elements = oBasicEle.elements();

            // 获取子节点内容 - 01
            Element oEleOne = elements.get(0);

            // 获取节点 01 的内容
            String oName = oEleOne.elementText("SName");
            String oAge = oEleOne.elementText("SAge");
			
            // 获取节点内容的第二种方法
            String oSex = oEleOne.element("SSex").getText();
            String oGrade = oEleOne.element("SGrade").getText();

            // 打印节点 01 的内容
            System.out.println("---------- 子元素内容 ----------");
            System.out.println("姓名: " + oName);
            System.out.println("年龄: " + oAge);
            System.out.println("性别: " + oSex);
            System.out.println("年级: " + oGrade);

        }

}

```

### 3) 获取属性值

- 使用 DOM4J 获取 XML 文档中元素上的属性值

```java
package com.bind.DOM4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class DOM4JGetAttribute {

    // 获取 XML 文档中的元素属性 ( ./Students.xml )
    @Test
    public void getAttribute() throws DocumentException {

        // 获取文档解析对象
        SAXReader reader = new SAXReader();

        // 解析 XML 文档
        Document oDoc = reader.read("./src/com/bind/DOM4J/Students.xml");

        // 获取根元素
        Element oBasicEle = oDoc.getRootElement();

        // 获取子节点
        List<Element> elements = oBasicEle.elements();

        // 获取子节点内容 - 01
        Element oEleOne = elements.get(0); // Students => Student[0] || Student.length == 1

        // 获取节点 01 的属性 => students => student[id=?]
        String oID = oEleOne.attributeValue("id");

        // 打印节点 01 的属性
        System.out.println("---------- 子元素属性 ----------");
        System.out.println("子元素属性: " + oID);

    }

}

```

---

## 9. XPath 解析方法

- XPath 是一种可以在 XML 文档中查找指定数据的语言, 且使用方便
- 需要引入 jaxen-1.1-beta-6.jar 包
- <span style="font-weight:bolder;color:red">※ 注意: 在需要查询的 XML 文档中根元素一定不要加入其他的属性, 包括但不限于: <u>xmlns</u>、<u>xmlns:xsi</u>、<u>xsi:schemaLocation</u>; 否则会导致查询失败 ( 因为只能获取到根元素, 后面的所有元素均无法获取去, 返回值将会为: null )</span> 

```xml
<?xml>
<students>
	<ele>
        <name></name>
        <age></age>
	</ele>

	... 第 n - 1 个

	<ele>
        <name></name>
        <age></age>
	</ele>
</students>
```

### 1) 获取文档信息

- 使用 XPath 获取 XML 文档中元素的标签名称 和 它的内容

```java
package com.bind.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

public class XPathGetContent {

    @Test
    public void getContent() throws DocumentException {
        SAXReader oReader =new SAXReader();

        Document oDoc = oReader.read("src/com/bind/XPath/Students.xml");

        // 分割线*10 注释 分割线*10
        System.out.println("========== 获取元素 1 的 SName ==========");

        // 获取默认( 第一个元素 )的 SName
        Node node = oDoc.selectSingleNode("/students/student/SName");
        System.out.println(node.getName());
        System.out.println(node.getText());

        // 分割线*10 注释 分割线*10
        System.out.println("========== 获取元素 2 的 SName ==========");

        // 想获取第 2 个的话也可以使用
        Node nodeTwo = oDoc.selectSingleNode("/students/student[2]/SName");
        System.out.println(nodeTwo.getName());
        System.out.println(nodeTwo.getText());

    }
}
```

### 2) 获取属性信息

- 使用 XPath 获取 XML 文档中元素的属性信息

```java
package com.bind.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

public class XPathGetAttribute {

    @Test
    public void getAttribute() throws DocumentException {
        SAXReader oReader = new SAXReader();
        Document oDoc = oReader.read("src/com/bind/XPath/Students.xml");
        Node oNode = oDoc.selectSingleNode("/students/student/attribute::id");
        System.out.println(oNode.getText());

        // 查询最后一个student节点的id属性
        Node oNodeLast = oDoc.selectSingleNode("/students/student[last()]/attribute::id");
        System.out.println("最后一个 Student 的 ID 属性为: " + oNodeLast.getText());

        // 查询 id == 2 的 student 节点的 SName 属性
        Node oNodeSNameTwo = oDoc.selectSingleNode("/students/student[@id='oData2']");
        String oNameTwo = oNodeSNameTwo.selectSingleNode("SName").getText();
        String oNameTwoOf = oNodeSNameTwo.valueOf("SName");
        System.out.println("========== selectSingleNode().getText() 方法 ==========");
        System.out.println("ID 为 2 的 Student 的姓名为: " + oNameTwo);
        System.out.println("========== valueOf() 方法 ==========");
        System.out.println("ID 为 2 的 Student 的姓名为: " + oNameTwoOf);
    }
}

```

### 3) 获取多个数据

- 使用 XPath 获取多个数据信息

```java
package com.bind.XPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.util.List;

public class XPathGetsEle {

    public Document setXml() throws DocumentException {
        SAXReader oReader = new SAXReader();
        Document document = oReader.read("src/com/bind/XPath/Students.xml");
        return document;
    }

    // 获取所有节点
    @Test
    public void getAllEle() throws DocumentException {

        Document oDoc = setXml();

        // 获取所有节点
        List<Node> oEleList = oDoc.selectNodes("//*");

        // 获取所有节点的个数
        System.out.println("所有节点的个数：" + oEleList.size());

        // 输出所有节点的名称
        for (Node oNode : oEleList) {
            System.out.println(oNode.getName());
        }
    }

    @Test
    public void getStudentsSName() throws DocumentException {

        Document oDocument = setXml();

        // 获取所有学生的名字
        List<Node> oNameList = oDocument.selectNodes("//SName");

        // 打印结果
        for (Node oNode : oNameList) {
            System.out.println("姓名: " + oNode.getText());
        }
    }

    @Test
    public void getOneStudentsData() throws DocumentException {

        // 输出 01 学生的所有信息
        Document oDocument = setXml();

        List oStudentOne = oDocument.selectNodes("/students/student//*");

        for (Object oNode : oStudentOne) {
            System.out.println(((Node) oNode).getName() + ": " + ((Node) oNode).getText());
        }

    }

}

```

---

## 10. JDBC 对 XML

### 1) 配置工具类

- 创建一个工具类的 基本数据

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<jdbc>
    <property name="driverClass">com.mysql.jdbc.Driver</property>
    <property name="url">jdbc:mysql://localhost:3306/test</property>
    <property name="user">root</property>
    <property name="password">123456</property>
</jdbc>

```

- 创建一个 JDBC 对 XML 的工具类

```java
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

```

### 2) 使用工具类查询

- 使用创建的工具类对数据库进行连接并查询数据库的内容

```java
package com.bind.JDBCAndXML.JDBCFile;

import com.bind.JDBCAndXML.Widgets.JDBCWidgets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCGetStudents {

    public static void main(String[] args) throws SQLException {
        Connection oCon = JDBCWidgets.getConnection();

        Statement oSta = oCon.createStatement();

        String sSql = "select * from oStudent";

        ResultSet oRes = oSta.executeQuery(sSql);

        // 处理结果集对象
        while (oRes.next()) {
            System.out.println(oRes.getString("sName"));
        }

        // 释放资源
        oRes.close();
        oSta.close();
    }

}

```



