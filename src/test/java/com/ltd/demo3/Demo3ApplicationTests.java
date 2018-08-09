package com.ltd.demo3;

import com.ltd.demo3.bean.Employee;
import com.ltd.demo3.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo3ApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串

    @Autowired
    RedisTemplate redisTemplate;//操作K，V对象

    @Autowired
    RedisTemplate<Object,Employee> empRedisTemplate;

    /**
     * Redis常用5大操作类型
     * String(字符串)、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     * stringRedisTemplate.opsForValue();字符串
     * stringRedisTemplate.opsForHash();
     */
    @Test
    public void test1(){
        System.out.println("test redis......");
        //stringRedisTemplate.opsForValue().append("msg","hello");
        ValueOperations<String, String> vo = stringRedisTemplate.opsForValue();
        System.out.println(vo.get("msg"));
        /*stringRedisTemplate.opsForList().leftPush("myList","1");
        stringRedisTemplate.opsForList().leftPush("myList","2");*/
        System.out.println(stringRedisTemplate.opsForList().leftPop("myList"));
    }

    @Test
    public void test2(){
       Employee emp = employeeMapper.getEmpById(1);
       empRedisTemplate.opsForValue().set("emp-01",emp);
    }


    @Test
    public void contextLoads() {
        Employee employee = employeeMapper.getEmpById(1);
        System.out.println("Host:"+employee.getName()+" aged "+employee.getAge()+" of gender "+employee.getGender());

    }

}
