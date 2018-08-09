/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: EmployeeService
 * Author:   Xavier
 * Date:     2018/8/1 18:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ltd.demo3.service;


import com.ltd.demo3.bean.Department;
import com.ltd.demo3.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 **/
@CacheConfig(cacheNames = "dept")/*CacheConfig用于抽出缓存的公共配置, 类指定cache value，方法上面可以省略*/
@Service
public class DeptService {

    @Autowired
    DepartmentMapper deptMapper;

    @Cacheable
    public Department getDeptById(Integer id){
        return deptMapper.getDeptById(id);
    }


    /**代码获取缓存
       1.定义缓存Manager
        2.获取
     ***/
    @Autowired
    RedisCacheManager dptCacheManager;

    public void operateDept(Integer id){

        Department dept = deptMapper.getDeptById(id);
        //获取某个缓存
        Cache dptCache = dptCacheManager.getCache("dept");

        //放入缓存
        dptCache.put("dept::1",dept);
    }
}