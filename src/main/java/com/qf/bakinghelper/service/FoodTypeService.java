package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.FoodType;
import com.qf.bakinghelper.entity.Type;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface FoodTypeService {

    //食谱分类中通过食品来查收具体的食品类型和具体的食品
    public Type foodTypeList(Integer typeId);

    //  根据具体的食品查询视频
    public List<Video> findFoodType(String typeName);

    //查询推荐中的所有食品
    public List<FoodType> foodList();
}
