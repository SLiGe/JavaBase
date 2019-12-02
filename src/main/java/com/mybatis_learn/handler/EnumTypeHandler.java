package com.mybatis_learn.handler;

import com.mybatis_learn.enums.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * includeNullJdbcType:如果希望在 ResultMap 中使用类型处理器，那么设置 @MappedJdbcTypes 注解的 includeNullJdbcType=true 即可
 *
 * @author Gary
 * @since 2019/12/02 10:39
 */
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
public class EnumTypeHandler extends BaseTypeHandler<SexEnum> {

    private Class<SexEnum> type;

    public EnumTypeHandler(Class<SexEnum> type) {
        if (type == null) {
            throw new IllegalArgumentException(" Type argument cannot be null!");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, sexEnum.getValue());
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return convert(resultSet.getString(s));
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println(resultSet.getString(i));
        return convert(resultSet.getString(i));
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return convert(callableStatement.getString(i));
    }

    private SexEnum convert(String sex) {
        SexEnum[] enumConstants = type.getEnumConstants();
        for (SexEnum enumConstant : enumConstants) {
            if (enumConstant.getCode().equals(sex)) {
                return enumConstant;
            }
        }
        return null;
    }
}
