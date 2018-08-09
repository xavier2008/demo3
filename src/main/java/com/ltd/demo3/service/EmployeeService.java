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


import com.ltd.demo3.bean.Employee;
import com.ltd.demo3.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author Xavier
 * @create 2018/8/1
 * @since 1.0.0
 **/
@CacheConfig(cacheNames = "emp")/*CacheConfig用于抽出缓存的公共配置, 类指定cache value，方法上面可以省略*/
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /****
     *
     * 原理：
     *   1、自动配置类：CacheAutoConfiguration
     *   2、缓存的配置类：
     *      org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.EhCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *      org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     *   3、哪个配置类默认生效：SimpleCacheConfiguration
     *   4、给容器中注册一个CacheManager：ConcurrentMapCacheManager
     *   5、可以获取和创建ConcurrentMapCache类型的缓存组件；将数据保存在ConcurrentMap中；
     *
     *   运行流程：
     *   @Cacheable：
     *   1、方法运行之前，先去查Cache（缓存组件），按照CacheNames指定名字获取；
     *      （CacheManger先获取相应的缓存),第一次获取缓存如果没有Cache组件会自动创建
     *   2、去Cache中查找缓存的内容，使用一个Key，默认就是方法参数；
     *      （Key是按照某种策略生成；默认使用KeyGenerator生成，使用SimpleKeyGenerator生成Key；)
     *        SimpleKeyGenerator生成Key的默认策略：
     *             1.如果没有参数：key=new SimpleKey()
     *             2.如果有一个参数：key=参数的值
     *             3.如果有多个参数：key=new SimpleKey(params)
     *   3、没有查到缓存就调用目标方法；
     *   4、将目标方法返回的结果放入缓存
     *   @Cacheable标注的方法执行之前先检查缓存是否有该数据，默认按参数的值作为key查询缓存，如没有就运行方法并将结果放入缓存；下次调用直接使用缓存数据
     *   核心：
     *      1、使用CacheManager的【ConcurrentMapCacheManager】按照名字获得Cache【ConcurrentMapCache】组件
     *      2、使用KeyGenerator生成Key，默认使用【SimpleKeyGenerator】
     *   属性：
     *      cacheNames/value:指定缓存组件的名字；
     *      key：缓存数据使用key；如果不指定则使用参数的值
     *      keyGenerator：key的生成器；可以自己指定key的生成器组件ID，key/keyGenerator二选一
     *      condition：指定符合条件才使用缓存；例：condition="#id>0"
     *      unless:否定缓存，unless指定的条件为true，方法的返回值就不会被缓存；可以对结果进行判断
     *              例：unless="#result==null" 结果为null时不缓存
     *                  unless="#a0==2" 第一个参数值为2的时候不缓存
     *      sync:是否使用异步模式
     */
    @Cacheable(/*cacheNames ={"emp"} ,keyGenerator = "myKeyGenerator" ,condition = "#id>1" ,unless = "#a0==2"*/)//key ="#root.methodName+'['+#id+']'"
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    /***
     *  @CachePut:既调用方法，又更新换成数据，同步更新缓存
     *  修改了数据的某个数据，同时更新；
     *  运行时机：
     *    1、先调用目标方法
     *    2、将目标方法的结果缓存
     */
    @CachePut(/*value = "emp",*/key = "#employee.id" /*key = "#result.id"*/)
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict: 清除缓存
     *  key: 指定要清除的数据
     *  allEntries=true：指定清除这个缓存中的所有数据
     *  beforeInvocation：缓存的清楚是否在方法之前删除，默认为之后（最好设置为true，这样即使方法出错也会清空缓存）
     */
    @CacheEvict(/*value = "emp",*/ key = "#id" /*,allEntries = true //删除该缓存中所有的数据,默认为false*/)
    public void deleteEmp(Integer id){
        System.out.println("delete employee:"+id);
        employeeMapper.deleteEmpById(id);
    }

    /**
     * @Caching
     */
    @Caching(
            cacheable = {
                    @Cacheable(/*value="emp",*/key="#name")
            },
            put = {
                    @CachePut(/*value="emp",*/key="#result.id"),
                    @CachePut(/*value="emp",*/key="#result.did")
            }
    )
    public Employee getEmpByName(String name){
        return employeeMapper.getEmpByName(name);
    }
}