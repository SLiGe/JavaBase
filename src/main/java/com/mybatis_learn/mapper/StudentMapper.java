package com.mybatis_learn.mapper;

import com.mybatis_learn.pojo.Student;
import com.mybatis_learn.pojo.StudentWithEnum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Gary
 * @since 2019/11/28 10:59
 */
public interface StudentMapper {

    Student selectStudent(@Param("id")String id);

    @Select("select * from student")
    List<Student> selectAllStudents();

    StudentWithEnum selectForEnum();
}
