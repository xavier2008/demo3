/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: HelloController
 * Author:   Xavier
 * Date:     2018/8/1 12:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号          描述
 */
package com.ltd.demo3.controller;

import com.ltd.demo3.component.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * 测试控制器
 *
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 */
//@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
//@RestController
@Controller
public class HelloController {
    @Autowired
    private StudentProperties student;
    /*
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!"+" host:"+student.getName()+", age:"+student.getAge();
    }*/

    @RequestMapping("/hello")
    public String hello(Model m) {
        String hostInfo="Host:"+student.getName()+" aged "+student.getAge();
        m.addAttribute("now",DateFormat.getDateTimeInstance().format(new Date()) +";<br/>  " + hostInfo);
        return "hello";
    }
}