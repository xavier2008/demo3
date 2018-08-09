package com.ltd.demo3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/****
 * 一、搭建环境
 * 1.导入数据库
 * 2.创建JavaBean封装数据
 * 3.整合Mybatis操作数据库
 *      3.1.配置数据源信息
 *      3.2.使用注解版的MyBatis
 * 二、配置缓存
 * 1.开启基于注解的缓存
 * 2.标注缓存即可
 *   @Cacheable
 *   @CacheEvict
 *   @CachePut
 * 3.默认使用ConcurrenctMapCacheManager==ConcurentMapCache
 *
 * 三、整合Redis缓存
 * 1.安装Redis，使用docker;
 * 2.引入redis starter
 * 3.配置redis，在yml文件中开启
 * 4.测试缓存
 *    1) 引入redis的starter，容器中保存的是RedisCacheManager
 *    2) RedisCacheManager帮我们创建RedisCache作为缓存组建，RedisCache通过Redis缓存数据的
 *    3) 默认保存数据K-V都是Object，利用序列化保存。 如何保存为Json格式????
 *       - 引入Redis-Starter，CacheManager变成RedisCacheManager
 *       - 默认创建的RedisCacheManager操作Redis的时候使用的是RedisTemplate<Object,Object>
 *       - RedisCacheTemplate<Object,Object>默认使用JDK的序列化
 *    4) 自定义CacheManager
 */
@MapperScan("com.ltd.demo3.mapper")//指定需要扫描的Mapper接口所在的包
@EnableCaching
@SpringBootApplication
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);

    }
}
