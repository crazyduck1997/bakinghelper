package com.qf.bakinghelper;

import com.qf.bakinghelper.dao.VideoDao;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.VideoService;
import io.swagger.annotations.ApiModel;
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
            List<Feature> feature = videoService.findAllFeature();
            System.out.println(feature);
        }
    }
