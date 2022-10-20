-- 判断是否存在 ShoppingMall 数据库, 不存在则创建
CREATE DATABASE IF NOT EXISTS `ShoppingMall` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 创建一个 User 表 用户表
CREATE TABLE IF NOT EXISTS `User` (
    UId VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '用户 ID',
    UName VARCHAR(20) NOT NULL COMMENT '用户名',
    USex VARCHAR(10) NOT NULL COMMENT '用户性别',
    UBirthday DATE NOT NULL COMMENT '用户生日',
    UPassword VARCHAR(20) NOT NULL COMMENT '用户密码',
    UPhone VARCHAR(20) NOT NULL COMMENT '用户手机号',
    UEmail VARCHAR(50) NOT NULL COMMENT '用户邮箱',
    UIDCard VARCHAR(20) COMMENT '用户身份证号',
    UCreateTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间'  
);

-- 插入数据
INSERT INTO `User` VALUES
('CD-User-20210101-01', '胡丽英', '女', '1998-12-22', '123456', '12345678901', '1122334455@qq.com', '111222199812223239', NULL),
('CD-User-20210101-02', '白素贞', '女', '1999-03-25', '123456', '12345678901', '1122334455@qq.com', NULL, NULL),
('CD-User-20210101-03', '岑碧青', '女', '2002-08-13', '123456', '12345678901', '1122334455@qq.com', '223112200208131232', NULL),
('CD-User-20210101-04', '孙悟空', '男', '2021-10-19', '123456', '12345678901', '1122334455@qq.com', '667997202110191024', NULL),
('CD-User-20210101-05', '胡小唯', '女', '1914-02-28', '123456', '12345678901', '1122334455@qq.com', NULL, NULL),
('CD-User-20210101-06', '猪八戒', '男', '2019-02-01', '123456', '12345678901', '1122334455@qq.com', NULL, NULL),
('CD-User-20221102-01', '黄贵蓉', '女', '1999-01-21', '123456', '12345678901', '1122334455@qq.com', NULL, NULL);

-- 创建 Order 表 订单表
CREATE TABLE IF NOT EXISTS `Order` (
    OId VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '订单 ID',
    OCreateTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    OMoney DOUBLE(10,2) NOT NULL COMMENT '订单金额',
    OName VARCHAR(20) NOT NULL COMMENT '收货人姓名',
    OPhone VARCHAR(20) NOT NULL COMMENT '收货人手机号',
    OAddress VARCHAR(100) NOT NULL COMMENT '收货人地址',
    OStatus INT(2) NOT NULL COMMENT '订单状态 0 未支付 1 已支付',
    UId VARCHAR(50) NOT NULL COMMENT '用户 ID',
    CONSTRAINT LinkUId FOREIGN KEY (UId) REFERENCES USER (UId) ON DELETE CASCADE
);

-- 插入数据 By: 购买者 AA: 序号 [A-Z][A-Z]
INSERT INTO `Order` VALUES
("By-AA-20221012-01", NULL, 1780.10, '岑碧青', '11223344556', '福建省厦门市', 1, 'CD-User-20210101-03');

-- 创建 CommodityType 表 商品分类别表
CREATE TABLE IF NOT EXISTS `CommodityType` (
    CTId VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '商品分类 ID',
    CTName VARCHAR(20) NOT NULL DEFAULT '未分类' COMMENT '商品分类名称',
    CTCreateTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品分类创建时间'
);

-- 插入数据 CD: CreateData 创建数据, CT: CommodityType 商品分类
INSERT INTO `CommodityType` VALUES
("CD-CT-Food", "食品类", '2010-07-01 11:55:11'),
-- Mobile Devices 移动设备
("CD-CT-MD", "移动设备", '2010-10-12 14:12:03'),
-- Household Electric Appliances 家用电器
("CD-CT-HEA", "家用电器", '2011-11-02 14:12:03'),
-- Clothes And Accessories 服装类
("CD-CT-CA", "服装类", '2012-02-28 12:17:34'),
-- Kitchen Supplies 厨房用品
("CD-CT-KP", "厨房用品", '2017-11-02 23:02:21'),
-- Books 图书类
("CD-CT-Books", "图书类", '2019-10-12 21:11:32');

-- 创建 Commodity 表 商品表
CREATE TABLE IF NOT EXISTS `Commodity` (
    CId VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '商品 ID',
    CName VARCHAR(20) NOT NULL COMMENT '商品名称',
    CPrice DOUBLE(10,2) NOT NULL COMMENT '商品价格',
    CStock INT(10) NOT NULL COMMENT '商品库存',
    CDescription VARCHAR(100) NOT NULL COMMENT '商品描述',
    CCreateTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品创建时间',
    CStatus INT(1) DEFAULT 0 COMMENT "商品状态 0 下架 1 上架",
    CTId VARCHAR(50) NOT NULL COMMENT '商品分类 ID',
    CONSTRAINT LinkCTId FOREIGN KEY (CTId) REFERENCES CommodityType (CTId) ON DELETE CASCADE
);

-- 插入数据 CD: CreateData 创建数据, C: Commodity 商品 + [A-Z][A-Z]
INSERT INTO `Commodity` VALUES
('CD-C-AA', '鸡蛋', 29.80, 3000, '盒装鸡蛋 x6/个 + 送 2/个, 特惠装', '2010-01-22 08:12:32', 1, 'CD-CT-Food'),
('CD-C-AB', '七匹狼 - 女士卫衣', 288.00, 23, '七匹狼女士卫衣, 让冬天不在寒冷', '2010-01-25 12:09:01', 1, 'CD-CT-CA'),
('CD-C-AC', '七匹狼 - 男士保暖裤', 198.00, 9, '七匹狼保暖裤, 告别老寒腿, 过一个温暖又舒适的冬天', '2010-01-25 12:09:33', 1, 'CD-CT-CA'),
('CD-C-AD', '华维 Copilot 99 Pro', 8999.00, 100, '华为限量 Mate 99 Pro 魔法少女樱联动, 新款顶配火热销售中', '2010-07-01 07:02,58', 1, 'CD-CT-MD'),
('CD-C-AE', '《可爱过敏原》-- 稚楚', 59.80, 289, '乐知时是和一场暴风雨一起毫无征兆的来到宋煜身边的', '2011-01-01 08:12:33', 1, 'CD-CT-Books');


-- 创建 BuyCommodity 表 购买商品表
CREATE TABLE IF NOT EXISTS `BuyCommodity` (
    BCId VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '购买商品 ID',
    CId VARCHAR(50) NOT NULL COMMENT '商品 ID ( 外键 )',
    OId VARCHAR(50) NOT NULL COMMENT '订单 ID ( 外键 )',
    BCNum INT(10) NOT NULL DEFAULT 1 COMMENT '购买商品数量',
    CONSTRAINT LinkCId FOREIGN KEY (CId) REFERENCES `Commodity` (CId) ON DELETE CASCADE,
    CONSTRAINT LinkOId FOREIGN KEY (OId) REFERENCES `Order` (OId) ON DELETE CASCADE
);