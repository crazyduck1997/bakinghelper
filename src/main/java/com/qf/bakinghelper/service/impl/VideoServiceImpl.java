package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AuthorDao;
import com.qf.bakinghelper.dao.FeatureDao;
import com.qf.bakinghelper.dao.VideoDao;
import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {


    @Resource
    private VideoDao videoDao;


    @Override
    public List<Video> findAllHotVideo() {
        //查询推荐视频
        List<Video> videoList = videoDao.findAllHotVideo();
        return videoList;
    }

    @Override
    public Video findOneVideoMessageByVideoId(Integer videoId) {
        //查询单个视频信息
        Video oneVideo = videoDao.findOneVideoMessageByVideoId(videoId);
        return oneVideo;
    }

}
