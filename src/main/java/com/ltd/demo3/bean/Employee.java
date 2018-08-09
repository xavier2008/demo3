/**
 * FileName: Student
 * Author:   Xavier
 * Date:     2018/8/1 14:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号          描述
 */
package com.ltd.demo3.bean;

import java.io.Serializable;

/**
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 */
public class Employee implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer did;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}