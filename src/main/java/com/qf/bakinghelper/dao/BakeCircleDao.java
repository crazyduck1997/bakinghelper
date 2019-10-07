package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.BakeCircle;

import java.util.List;

public interface BakeCircleDao {
    int deleteByPrimaryKey(Integer circleId);

    int insert(BakeCircle record);

    BakeCircle selectByPrimaryKey(Integer circleId);

    List<BakeCircle> selectByTopicId(Integer topicId);

    List<BakeCircle> selectAll();

    int updateCommentNumByPrimaryKey(BakeCircle record);

    int updatePraiseByPrimaryKey(BakeCircle record);
}