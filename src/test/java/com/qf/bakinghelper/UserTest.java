package com.qf.bakinghelper;

import com.qf.bakinghelper.controller.UserController;
import com.qf.bakinghelper.dao.CollectFoodOrderDao;
import com.qf.bakinghelper.dao.RecipeDao;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.CollectFoodOrder;
import com.qf.bakinghelper.entity.Recipe;
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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Resource
    UserDao userDao;

    @Resource
    RecipeDao recipeDao;

    @Resource
    CollectFoodOrderDao collectFoodOrderDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;



    @Test
    public void userTest(){
        User user = userDao.findByAccountId("31649c9d");
        System.out.println(user);
    }

    @Test
    public void recipeTest(){
        List<Recipe> list = recipeDao.findAllRecipe();
        Recipe recipe = list.get(0);
        System.out.println(recipe);
    }

    @Test
    public void test(){
        List<CollectFoodOrder> list = collectFoodOrderDao.findCollectByUid(1);
        for(CollectFoodOrder c : list ){
            System.out.println(c);
        }
    }

    @Test
    public void testFindBycId(){
        List<Recipe> list = recipeDao.findRecipesByCollectId(1);
        for(Recipe c : list ){
            System.out.println(c);
        }
    }

}
