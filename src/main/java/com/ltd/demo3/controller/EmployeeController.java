/**
 * FileName: StudentController
 * Author:   Xavier
 * Date:     2018/8/1 15:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号          描述
 */
package com.ltd.demo3.controller;

import com.ltd.demo3.bean.Employee;
import com.ltd.demo3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/delEmp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }
}