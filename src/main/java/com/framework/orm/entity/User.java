package com.framework.orm.entity;

import com.github.orm.annotation.Column;
import com.github.orm.annotation.Id;
import com.github.orm.annotation.Table;
import lombok.Data;

/**
 * @author zJiaLi
 * @since 2020-07-14 23:17
 */
@Table(name = "user")
@Data
public class User {

    @Id(name = "id")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "money")
    private Integer money;
}
