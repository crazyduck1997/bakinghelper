package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface VideoService {

    //查询推荐视频
    List<Video> findAllHotVideo();

    //单个视频信息的查询
    Video findOneVideoMessageByVideoId(Integer videoId);

    //通过typeId查询单个食品类型对应的所有视频
    List<Video> findOneTypeVideosByTypeId(Integer typeId);
}
