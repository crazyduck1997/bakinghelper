package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.FootType;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface FootTypeService {

    //    根据具体的食品类型查询所有的食品
    public List<FootType> footTypeList();

    //  根据具体的食品查询视频
    public List<Video> findFootType(String typeName);

    //查询推荐中的所有食品
    public List<FootType> footList();
}
