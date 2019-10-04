package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.FootType;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface FootTypeDao {


//    根据具体的食品类型查询所有的食品
    public List<FootType> footTypeList();
    //查询推荐中的所有食品
    public List<FootType> footList();

}
