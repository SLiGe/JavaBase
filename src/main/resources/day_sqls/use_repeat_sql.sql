-- 1.查找全部重复记录
Select * From 表 Where 重复字段 In (Select 重复字段 From 表 Group By 重复字段 Having Count(*)>1)

-- 2、过滤重复记录(只显示一条)
Select * From HZT Where ID In (Select Max(ID) From HZT Group By Title)

-- 3.删除全部重复记录
Delete 表 Where 重复字段 In (Select 重复字段 From 表 Group By 重复字段 Having Count(*)>1)

-- 4.删除重复记录(保留一条)
Delete HZT Where ID Not In (Select Max(ID) From HZT Group By Title)

-- 5.对于字段内容全部相同的记录
select distinct * from  tableName

-- 实例删除重复数据
create table #tmp select distinct *  from  tableName --创建临时表
TRUNCATE tableName -- 删除原表数据
INSERT INto tableName SELECT * FROM #tmp
drop table #tmp