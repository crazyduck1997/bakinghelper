package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Browse;

import java.util.List;

/**
 * 中间表关联uid和gid
 */
public interface BrowseDao {
    //通过主键删除
    int deleteByPrimaryKey(Integer browseId);

    int insert(Browse record);
    //查询所有
    Browse selectByPrimaryKey(Integer browseId);

    List<Browse> selectAll();

    int updateByPrimaryKey(Browse record);
}