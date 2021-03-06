package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface FeatureDao {
    int deleteByPrimaryKey(Integer featureId);

    int insert(Feature record);

    Feature selectByPrimaryKey(Integer featureId);

    int updateByPrimaryKey(Feature record);

    //查询所有的专栏对应的视频
    List<Feature> findAllFeature();
    //查询单个专栏对应的视频
    List<Video> findOneFeatureAllVideoByFeatureId(Integer featureId);
}