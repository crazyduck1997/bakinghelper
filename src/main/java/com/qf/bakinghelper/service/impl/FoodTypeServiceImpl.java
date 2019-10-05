package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.FoodTypeDao;
import com.qf.bakinghelper.dao.VideoDao;
import com.qf.bakinghelper.entity.FoodType;
import com.qf.bakinghelper.entity.Type;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {


    @Autowired(required = false)
    FoodTypeDao foodTypeDao;

    @Autowired(required = false)
    VideoDao videoDao;

    @Override
    //    根据具体的食品类型查询所有的食品
    public Type foodTypeList(Integer typeId) {
        Type list = foodTypeDao.foodTypeList(typeId);
        return list;
    }

    @Override
    //    根据具体的食品查询视频
    public List<Video> findFoodType(String typeName) {
        return videoDao.findByFoodType(typeName);
    }

    @Override
    //食谱分类推荐中的所有的食品
    public List<FoodType> foodList() {
        return foodTypeDao.foodList();
    }
}
