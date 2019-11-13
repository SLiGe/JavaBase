-- 1.复制表结构及数据到新表
CREATE TABLE 新表 SELECT * FROM 旧表

-- 2.只复制表结构到新表
CREATE TABLE 新表 SELECT * FROM 旧表 WHERE 1=2 -- (即:让WHERE条件不成立.)

-- 方法二:(由tianshibao提供)
CREATE TABLE 新表 LIKE 旧表

-- 3.复制旧表的数据到新表(假设两个表结构一样)
INSERT INTO 新表 SELECT * FROM 旧表

-- 4.复制旧表的数据到新表(假设两个表结构不一样)
INSERT INTO 新表(字段1,字段2,.......) SELECT 字段1,字段2,...... FROM 旧表

-- 5.重置表自增值
ALTER TABLE table_name AUTO_INCREMENT = 1;