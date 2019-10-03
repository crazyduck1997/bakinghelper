package com.qf.bakinghelper;

import com.qf.bakinghelper.controller.UserController;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Resource
    UserDao userDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        Boolean phone = stringRedisTemplate.hasKey("phone");
        System.out.println(phone);
    }

    @Test
    public void userTest(){
        User user = userDao.findByAccountId("31649c9d");
        System.out.println(user);
    }

    @Test
    public void upodateTest(){
        User user = new User();
        user.setQq("129837129");
        Integer asd = userService.update(user, "31048c3bff1290453a6465cec7deb5e7");
        System.out.println(asd);
    }

}
