package com.ltd.demo3.mapper;

import com.ltd.demo3.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 **/


@Repository
@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();
}