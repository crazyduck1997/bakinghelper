package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.BakeCircle;

import java.util.List;

public interface BakeCircleService {
    int deleteByPrimaryKey(Integer circleId);

    int insert(BakeCircle record,String token);

    BakeCircle selectByPrimaryKey(Integer circleId);

    List<BakeCircle> selectAll();

    int updateByPrimaryKey(BakeCircle record);
}
