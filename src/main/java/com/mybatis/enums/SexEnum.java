package com.mybatis.enums;

import lombok.Getter;

/**
 * 自动映射器（auto-mapper）会自动地选用 EnumOrdinalTypeHandler 来处理，
 * 所以如果我们想用普通的 EnumTypeHandler，就必须要显式地为那些 SQL 语句设置要使用的类型处理器。
 * <result column="roundingMode" property="roundingMode" typeHandler="org.apache.ibatis.type.EnumTypeHandler"/>
 *
 * @author Gary
 * @since 2019/11/28 14:57
 */
@Getter
public enum SexEnum {
    MAN("男", "man"),

    WOMAN("女", "woman"),
    ;

    private String code;

    private String value;


    SexEnum(String sex, String flag) {
        this.code = sex;
        this.value = flag;
    }

    public static String getValue(String sex) {
        SexEnum[] values = values();
        for (SexEnum value : values) {
            if (value.getCode().equals(sex)) {
                return value.getValue();
            }
        }
        return null;
    }
}
