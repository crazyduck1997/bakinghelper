package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.BakeCircle;

import java.util.List;

public interface BakeCircleDao {
    int deleteByPrimaryKey(Integer circleId);

    int insert(BakeCircle record);

    BakeCircle selectByPrimaryKey(Integer circleId);

    List<BakeCircle> selectAll();

    int updateByPrimaryKey(BakeCircle record);
}