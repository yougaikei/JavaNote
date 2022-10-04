-- 创建一个 学校 数据库 utf8mb4
CREATE DATABASE oSchoolData CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 创建一个 学生 表
CREATE TABLE oStudent(
	-- id ( IsKey )
	SId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	-- 姓名
	SName VARCHAR(20),
	-- 年龄
	SAge INT,
	-- 性别
	SSex VARCHAR(20),
	-- 年级
	SGrade INT,
	-- 系别
	SDepartment VARCHAR(20),
	-- 学费
	STuition INT,
	-- 备注
	SRemarks VARCHAR(20)
);

-- 创建学生
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('刘一依', 12, '男', 1, '文学系', 1);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('陈晨', 15, '男', 3, '理综系', 0);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('张永昌', 13, '男', 2, '理综系', 1);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('李焕英', 16, '男', 3, '理综系', 1);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('王德发', 13, '女', 3, '理综系', 1);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('赵利', 15, '男', 2, '文学系', 0);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('孙钱旺', 14, '女', 1, '文学系', 1);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('周威', 13, '女', 2, '文学系', 0);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('吴勇', 15, '男', 3, '理综系', 1);
 INSERT INTO oStudent (SName, SAge, SSex, SGrade, SDepartment, STuition) VALUES('郑石', 12, '男', 1, '文学系', 0);
 
-- 创建一个 老师 表
CREATE TABLE oTeacher(
	-- id ( IsKey )
	TId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	-- 教师名称
	TName VARCHAR(20),
	-- 教师年龄
	TAge INT,
	-- 教师性别
	TSex VARCHAR(20),
	-- 教师系别
	TDepartment VARCHAR(20),
	-- 教师工龄
	TWorkingYears INT,
	-- 教师备注
	TRemarks VARCHAR(20)
);

-- 创建教师
INSERT INTO oTeacher (TName, TAge, TSex, TDepartment, TWorkingYears) VALUES('陈英', 36, '女', '语文老师', 12);
INSERT INTO oTeacher (TName, TAge, TSex, TDepartment, TWorkingYears) VALUES('李莲纺', 33, '女', '数学老师', 9);
INSERT INTO oTeacher (TName, TAge, TSex, TDepartment, TWorkingYears) VALUES('金有为', 56, '女', '数学老师', 12);
INSERT INTO oTeacher (TName, TAge, TSex, TDepartment, TWorkingYears) VALUES('黄跃', 46, '女', '语文老师', 24);
INSERT INTO oTeacher (TName, TAge, TSex, TDepartment, TWorkingYears) VALUES('郎建军', 32, '男', '体育老师', 8);
INSERT INTO oTeacher (TName, TAge, TSex, TDepartment, TWorkingYears) VALUES('魏秀霞', 28, '女', '数学老师', 5);
INSERT INTO oTeacher (TName, TAge, TSex, TDepartment, TWorkingYears) VALUES('陈英', 36, '女', '语文老师', 12);


-- 创建课程表
CREATE TABLE oCourse(
    -- id ( IsKey )
    CId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    -- 课程名称
    CName VARCHAR(20),
    -- 课程学分
    Credit INT,
    -- 课程备注
    CRemarks VARCHAR(50)
);

-- 创建课程
INSERT INTO oCourse (CName, Credit) VALUES('语文(一年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('语文(一年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('语文(二年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('语文(二年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('语文(三年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('语文(三年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('数学(一年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('数学(一年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('数学(二年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('数学(二年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('数学(三年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('数学(三年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('英语(一年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('英语(一年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('英语(二年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('英语(二年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('英语(三年级上册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('英语(三年级下册)', 120);
INSERT INTO oCourse (CName, Credit) VALUES('物理(一年级上册)', 100);
INSERT INTO oCourse (CName, Credit) VALUES('物理(一年级下册)', 100);
INSERT INTO oCourse (CName, Credit) VALUES('物理(二年级上册)', 100);
INSERT INTO oCourse (CName, Credit) VALUES('物理(二年级下册)', 100);
INSERT INTO oCourse (CName, Credit) VALUES('物理(三年级上册)', 100);
INSERT INTO oCourse (CName, Credit) VALUES('物理(三年级下册)', 100);
INSERT INTO oCourse (CName, Credit) VALUES('化学(一年级上册)', 80);
INSERT INTO oCourse (CName, Credit) VALUES('化学(一年级下册)', 80);
INSERT INTO oCourse (CName, Credit) VALUES('化学(二年级上册)', 80);
INSERT INTO oCourse (CName, Credit) VALUES('化学(二年级下册)', 80);
INSERT INTO oCourse (CName, Credit) VALUES('化学(三年级上册)', 80);
INSERT INTO oCourse (CName, Credit) VALUES('化学(三年级下册)', 80);
INSERT INTO oCourse (CName, Credit) VALUES('体育(一年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('体育(一年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('体育(二年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('体育(二年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('体育(三年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('体育(三年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('美术(一年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('美术(一年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('美术(二年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('美术(二年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('美术(三年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('美术(三年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('音乐(一年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('音乐(一年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('音乐(二年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('音乐(二年级下册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('音乐(三年级上册)', 60);
INSERT INTO oCourse (CName, Credit) VALUES('音乐(三年级下册)', 60);