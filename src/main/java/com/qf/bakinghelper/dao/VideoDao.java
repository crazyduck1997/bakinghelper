package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Video;
import java.util.List;

public interface VideoDao {
    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    Video selectByPrimaryKey(Integer videoId);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}