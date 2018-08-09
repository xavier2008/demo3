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

/**
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 */
public class Department {
    private Integer id;
    private String name;
    private Integer teamNum;
    private String type;

    public Integer getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(Integer teamNum) {
        this.teamNum = teamNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

}