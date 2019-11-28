package com.mybatis_learn.pojo;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;


/**
 * @author Gary
 * @since 2019/11/28 11:01
 */
@ToString
@Data
@Alias("student")
public class Student {

    private String sId;

    private String sName;

    private String sBirth;

    private String sSex;
}
