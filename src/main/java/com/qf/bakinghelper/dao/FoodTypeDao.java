package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Detail;
import com.qf.bakinghelper.entity.FoodType;
import com.qf.bakinghelper.entity.Type;

import java.util.List;

public interface FoodTypeDao {


    //    根据具体的食品类型查询所有的食品
    public List<Detail> foodTypeList(Integer typeId);
    //查询推荐中的所有食品
    public List<FoodType> foodList();

}
