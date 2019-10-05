package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Video;
import java.util.List;

public interface VideoDao {
    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    Video selectByPrimaryKey(Integer videoId);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
    //查询推荐视频
    List<Video> findAllHotVideo();
    //单个视频信息的查询
    Video findOneVideoMessageByVideoId(Integer videoId);

    //    根据具体的食品查询视频
    public List<Video> findByFoodType(String typeName);
}