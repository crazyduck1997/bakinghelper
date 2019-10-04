package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Detail;

import java.util.List;

public interface DetailService {

    //在食谱分类中根据食品的类型查询具体的分类
    public List<Detail> detailList();
}
