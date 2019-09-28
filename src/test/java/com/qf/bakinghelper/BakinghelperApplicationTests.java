package com.qf.bakinghelper;

import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BakinghelperApplicationTests {

    @Resource
    UserDao userDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        String phone = (String)stringRedisTemplate.opsForHash().get("user", "phone");
        if(phone==null){
            User user = userDao.findByPhone("123");
            stringRedisTemplate.opsForHash().put("user","phone",user.getPhone());
            System.out.println("加入缓存"+user.getPhone());
        }
        System.out.println("缓存中"+phone);
    }

    @Test
    public void redisTest(){
        stringRedisTemplate.opsForHash().delete("user","phone");
    }

}
