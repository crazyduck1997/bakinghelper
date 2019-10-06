package com.qf.bakinghelper;

import com.qf.bakinghelper.dao.VideoDao;
import com.qf.bakinghelper.entity.*;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoTest {

    @Resource
    VideoDao videoDao;

    @Autowired
    VideoService videoService;
    @Autowired
    FeatureService featureService;
    @Autowired
    TypeService typeService;
    @Autowired
    AuthorService authorService;

    @Autowired
    FoodTypeService foodTypeService;

    @Test
    public void videoTest() {
        List<Video> all = videoDao.selectAll();
        for (Video u : all) {
            System.out.println(u);
        }
    }

        @Test
        //推荐视频测试
        public void test() {
            List<Video> hotVideoList = videoService.findAllHotVideo();
            System.out.println(hotVideoList);
        }
        @Test
        public void test1() {
        //所有专栏对应视频查询遍历
            List<Feature> feature = featureService.findAllFeature();
            System.out.println(feature);
        }
        @Test
        public void test2(){
        //单个专栏对应视频查询
            List<Video> oneFeatureList = featureService.findOneFeatureAllVideoByFeatureId(1);
            System.out.println(oneFeatureList);
        }
        @Test
        public void test3(){
        //查询视频对应食品的种类
            List<Type> typeList = typeService.selectAll();
            System.out.println(typeList);
        }
        @Test
        public void test4(){
        //查询单个type种类对应的所有视频
            List<Video> typeVideosByTypeId = videoService.findOneTypeVideosByTypeId(1);
            System.out.println(typeVideosByTypeId);
        }

        @Test
        public void test5(){
        //查询单个视频信息
            Video onevideomesage = videoService.findOneVideoMessageByVideoId(1);
            System.out.println(onevideomesage);
        }
        @Test
        public void test6(){
            //导师相关视频
            Author author = authorService.findAuthorById(1);
            System.out.println(author);
        }


        @Test
        public void testFood(){
            List<Detail> list = foodTypeService.foodTypeList(1);
            System.out.println(list);
        }

    @Test
    public void testFind(){
        List<Video> list = foodTypeService.findFoodType("蛋糕");
        System.out.println(list);
    }


    }
