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

-- Min SQL In Java.JDBC
CREATE TABLE oClassScheduleCard ( CSCId INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, CSCName INT NOT NULL, CSCStudent INT NOT NULL, CSCTeacher INT NOT NULL, CSCRemark varchar(50), CONSTRAINT IsClass FOREIGN KEY (CSCName) REFERENCES oCourse (CId), CONSTRAINT IsStudent FOREIGN KEY (CSCStudent) REFERENCES oStudent (SId), CONSTRAINT IsTeacher FOREIGN KEY (CSCTeacher) REFERENCES oTeacher (TId) );