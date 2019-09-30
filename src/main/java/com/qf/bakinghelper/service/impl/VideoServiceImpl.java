package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AuthorDao;
import com.qf.bakinghelper.dao.FeatureDao;
import com.qf.bakinghelper.dao.VideoDao;
import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    private VideoDao videoDao;
    @Autowired
    private FeatureDao featureDao;

    @Override
    public List<Video> findAllHotVideo() {
        //查询推荐视频
        List<Video> videoList = videoDao.findAllHotVideo();
        return videoList;
    }

    @Override
    public List<Feature> findAllFeature() {
        //查询所有的专栏种类
        List<Feature> featureList = featureDao.findAllFeature();
        return featureList;
    }

}
