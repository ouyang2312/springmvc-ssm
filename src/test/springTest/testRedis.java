package springTest;

import com.google.gson.Gson;
import com.ssm.bean.Employee;
import com.ssm.service.EmployeeService;
import com.ssm.util.CacheUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-content.xml")
public class testRedis {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void test4(){
        CacheUtils cacheUtils = new CacheUtils(redisTemplate,stringRedisTemplate);
        List<Employee> allEmployee = employeeService.getAllEmployee();
        Employee employee = allEmployee.get(0);
        Gson gson = new Gson();
        //加入
        String s = gson.toJson(employee, Employee.class);
        cacheUtils.set("jsonString",s);
    }

    @Test
    public void test5(){
        CacheUtils cacheUtils = new CacheUtils(redisTemplate,stringRedisTemplate);
        Gson gson = new Gson();
        String jsonString = cacheUtils.getString("jsonString");
        //Employee employee = gson.fromJson(jsonString, Employee.class);
        System.out.println(jsonString);
    }

    /**
     * 测试spring-redis.xml配置
     */
    @Test
    public void test1(){
        Jedis jedis = new Jedis("192.168.134.130",6379);
        List<String> list = jedis.lrange("list", 0, -1);
        System.out.println(list);
    }

    /**
     *  测试redis连通性
     */
    @Test
    public void test2(){
        System.out.println(redisTemplate.getConnectionFactory().getConnection());
    }

    /**
     *  测试spring容器
     */
    @Test
    public void test3(){
        List<Employee> allEmployee = employeeService.getAllEmployee();
        System.out.println(allEmployee);
    }

}
