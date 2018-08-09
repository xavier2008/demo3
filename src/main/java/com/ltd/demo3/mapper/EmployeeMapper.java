/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: EmployeeMapper
 * Author:   Xavier
 * Date:     2018/8/1 18:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ltd.demo3.mapper;


import com.ltd.demo3.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 *
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 **/
@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM Employee WHERE id=#{id} ")
    public Employee getEmpById(Integer id);

    @Select("SELECT * FROM Employee WHERE name=#{name} ")
    public Employee getEmpByName(String name);

    @Update("UPDATE Employee SET name=#{name}, age=#{age}, gender=#{gender} WHERE id=#{id}   ")
    public void updateEmp(Employee employee);

    @Delete("DELETE Employee WHERE id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT Empolyee(name,age,gender) values(#{name},#{age},#{gender})")
    public void insertEmp(Employee employee);
}