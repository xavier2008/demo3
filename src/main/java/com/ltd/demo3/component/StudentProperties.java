/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: StudentProperties
 * Author:   Xavier
 * Date:     2018/8/1 13:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号          描述
 */
package com.ltd.demo3.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Student
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
        private String name;
        private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}