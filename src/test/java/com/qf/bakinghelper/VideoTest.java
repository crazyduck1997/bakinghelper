package com.qf.bakinghelper;

import com.qf.bakinghelper.dao.VideoDao;
import com.qf.bakinghelper.entity.Video;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoTest {

    @Resource
    VideoDao videoDao;

    @Test
    public void videoTest(){
        List<Video> all = videoDao.selectAll();
        for(Video u : all){
            System.out.println(u);
        }
    }
}
