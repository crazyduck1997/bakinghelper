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
    FeatureDao featureDao;

    @Resource
    TypeDao typeDao;

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
        boolean phone = stringRedisTemplate.hasKey("phone");
        String num = "123";
        if(!phone){
            stringRedisTemplate.opsForValue().set("phone",num);
            System.out.println("加入缓存"+num);
        }
        System.out.println("缓存中"+num);
    }

    @Test
    public void redisTest(){
        stringRedisTemplate.delete("phone");
    }





    @Test
    public void authorTest(){

        List<Author> list = authorDao.selectAll();
        for(Author i : list){
            System.out.println(i);
        }
    }

    @Test
    public void featureTest(){
        List<Feature> list = featureDao.selectAll();
        for(Feature i : list){
            System.out.println(i);
        }
    }

    @Test
    public void typeTest(){
        List<Type> list = typeDao.selectAll();
        for(Type i : list){
            System.out.println(i);
        }
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
