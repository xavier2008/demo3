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

import com.ltd.demo3.bean.Student;
import com.ltd.demo3.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 */
@Controller
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/listStudent")
    public String listStudent(Model model){
        List<Student> students = studentMapper.findAll();

        Student student = new Student();
        student.setName("Jim");
        student.setId(1);
        student.setStudent_id(10);
        students.add(student);
        model.addAttribute("students",students);
        return "listStudent";
    }
}