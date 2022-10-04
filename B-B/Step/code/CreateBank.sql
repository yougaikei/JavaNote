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
    -- 设置 Double 类型的精度
    BBalance DOUBLE(10,2) NOT NULL DEFAULT 0.00
    BPhone VARCHAR(20) NOT NULL,
    -- 设置 BType 只能是 0 或 1 [ 0: 借记卡, 1: 信用卡 ]
    BType TINYINT(1) NOT NULL CHECK(BType IN (0, 1)),
    -- 设置 BState 只能是 0 或 1 [ 0: 正常, 1: 锁定 ]
    BState TINYINT(1) NOT NULL CHECK(BState IN (0, 1))
);

-- 3. 创建 10 个虚拟用户
INSERT INTO Users(BName, BAge, BGender, BBirthday, BPassword, BBalance, BPhone, BType, BState) VALUES("刘思轩", 16, '女', '2004-01-01', '123456', 1000.00, '12822222901', 0, 0);
INSERT INTO Users(BName, BAge, BGender, BBirthday, BPassword, BBalance, BPhone, BType, BState) VALUES("李佳怡", 16, '女', '2008-02-22', '123456', 1000.00, '13141831301', 0, 0);
INSERT INTO Users(BName, BAge, BGender, BBirthday, BPassword, BBalance, BPhone, BType, BState) VALUES("林耀东", 22, '男', '2008-02-22', '123456', 99999.00, '1763625901', 0, 0);
