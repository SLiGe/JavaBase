-- 修改字段
alter table_name MODIFY column column_name datatype() CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置值' AFTER `CONFIG_NAME`;

-- 修改表名
alter TABLE qr_signIn_level RENAME to qr_sign_in_level;
