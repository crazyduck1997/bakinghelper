package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Type;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface TypeService {

    //查询所有的视频对应的食品类型
    List<Type> selectAll();

}
