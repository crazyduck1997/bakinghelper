package com.qf.bakinghelper;

import com.qf.bakinghelper.dao.*;
import com.qf.bakinghelper.entity.*;
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
    AuthorDao authorDao;

    @Resource
    BakeCircleDao bakeCircleDao;

    @Resource
    BrowseDao browseDao;

    @Resource
    UserDao userDao;

    @Resource
    VideoDao videoDao;

    /**
     * 键和值都是String类型
     */
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * redisTemplate可以存对象，但是要序列化
     */
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        String phone = (String)stringRedisTemplate.opsForHash().get("user", "phone");
        if(phone==null){
            phone = "123";
            stringRedisTemplate.opsForHash().put("user","phone",phone);
            System.out.println("加入缓存"+phone);
        }
        System.out.println("缓存中"+phone);
    }

    @Test
    public void redisTest(){
        stringRedisTemplate.opsForHash().delete("user","phone");
    }





    @Test
    public void authorTest(){
        Author author = new Author();
        author.setAuthorName("lisi");
        author.setAuthorId(1);
        int i = authorDao.updateByPrimaryKey(author);
        System.out.println(i);
    }



    @Test
    public void videoTest(){
        List<Video> all = videoDao.selectAll();
        for(Video u : all){
            System.out.println(u);
        }
    }



    @Test
    public void bakeCircleTest(){
        List<BakeCircle> all = bakeCircleDao.selectAll();
        for(BakeCircle u : all){
            System.out.println(u);
        }
    }

    @Test
    public void browseTest(){
        List<Browse> all = browseDao.selectAll();
        for(Browse u : all){
            System.out.println(u);
        }
    }






}
