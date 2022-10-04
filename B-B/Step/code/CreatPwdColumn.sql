-- 添加列
ALTER TABLE oStudent ADD SPassword INT NOT NULL;

-- 修改整列的 SPassword
UPDATE oStudent SET SPassword = 123456;