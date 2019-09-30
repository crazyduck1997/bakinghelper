package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface VideoService {

    //查询推荐视频
    public List<Video> findAllHotVideo();
    //查询专栏的种类
    public List<Feature> findAllFeature();

}
