package com.mybatis.pojo;

import com.mybatis.enums.SexEnum;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

/**
 * @author Gary
 * @since 2019/11/28 14:59
 */
@ToString
@Data
@Alias("studentWithEnum")
public class StudentWithEnum {
    private String sId;

    private String sName;

    private String sBirth;

    private SexEnum sSex;
}
