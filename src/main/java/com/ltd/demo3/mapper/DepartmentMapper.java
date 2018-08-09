/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DepartmentMapper
 * Author:   Xavier
 * Date:     2018/8/1 18:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ltd.demo3.mapper;


import com.ltd.demo3.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 **/
@Mapper
public interface DepartmentMapper {
    @Select("SELECT * FROM Department WHERE id=#{id}")
    Department getDeptById(Integer id);
}