-- 创建一个 UTF8MB4 的数据库
CREATE DATABASE IF NOT EXISTS oCompany DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

/* 创建一个员工表: oEmployees[
    EId: INT && IS KEY && NOT NULL && AUTO_INCREMENT, // 员工 ID
    EName: VARCHAR(10), // 员工姓名
    EGender: VARCHAR(10), // 员工性别
    EAge: INT, EPhone: INT, // 员工年龄
    EPhone: VARCHAR(20), // 员工电话
    EAddress: VARCHAR(30), // 员工地址
    EEmail: VARCHAR(30),    // 员工邮箱
    EPassword: VARCHAR(20) && NOT NULL, // 密码
    EType: VARCHAR(20), // 员工类型
    EStatus: TINYINT(1) && NOT NULL && CHECK(EStatus IN (0, 1)), // 员工状态
    ESakary: DOUBLE(10,2) && NOT NULL, // 员工薪资
    ECreateTime: DATA && NOT NULL, // 员工创建时间
    EUpdateTime: DATA && NOT NULL // 员工更新时间
    ]
*/
CREATE TABLE oEmployees (
    -- 员工 ID (IS KEY)
    EId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -- 员工姓名
    EName VARCHAR(10) NOT NULL,
    -- 员工性别
    EGender VARCHAR(10) NOT NULL,
    -- 员工年龄
    EAge INT NOT NULL,
    -- 员工电话
    EPhone VARCHAR(20) NOT NULL,
    -- 员工地址
    EAddress VARCHAR(30) NOT NULL,
    -- 员工邮箱
    EEmail VARCHAR(30) NOT NULL,
    -- 员工密码
    EPassword VARCHAR(20) NOT NULL,
    -- 员工类型
    EType VARCHAR(20) NOT NULL,
    -- 员工状态 [ 1:在职, 0:离职 ]
    EStatus TINYINT(1) NOT NULL CHECK(EStatus IN (0, 1)),
    -- 员工薪资
    ESalary DOUBLE(10,2) NOT NULL,
    -- 员工创建时间
    ECreateTime DATE NOT NULL,
    -- 员工更新时间
    EUpdateTime DATE NOT NULL
);

-- 创建虚拟员工
INSERT INTO
oEmployees(EName, EGender, EAge, EPhone, EAddress, EEmail, EPassword, EType, EStatus, ESalary, ECreateTime, EUpdateTime)
VALUES("刘思轩", "女", 18, 13822222901, "北京市海淀区", '19916611276@qq.com', '000000', '副经理', 1, 9800.00, '2020-01-01', '2022-01-01');
INSERT INTO
oEmployees(EName, EGender, EAge, EPhone, EAddress, EEmail, EPassword, EType, EStatus, ESalary, ECreateTime, EUpdateTime)
VALUES("王子怡", "女", 18, 17624322981, "北京市海淀区", '18813212176@qq.com', '000000', '工程师', 1, 10800.00, '2020-01-01', '2022-06-01');