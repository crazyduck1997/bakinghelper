package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Topic;

import java.util.List;

public interface TopicDao {
    int deleteByPrimaryKey(Integer topicId);

    int insert(Topic record);

    Topic selectByPrimaryKey(Integer topicId);

    List<Topic> selectAll();

    int updateByPrimaryKey(Topic record);
}