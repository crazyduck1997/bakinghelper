package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Type;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface TypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    Type selectByPrimaryKey(Integer typeId);
    //查询所有的视频对应的食品类型
    List<Type> selectAll();

    int updateByPrimaryKey(Type record);

    //通过typeId查询单个食品类型对应的所有视频
    public List<Video> findOneTypeVideosByTypeId(Integer typeId);
}