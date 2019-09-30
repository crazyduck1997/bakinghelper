package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Feature;
import java.util.List;

public interface FeatureDao {
    int deleteByPrimaryKey(Integer featureId);

    int insert(Feature record);

    Feature selectByPrimaryKey(Integer featureId);

    //查询专栏的种类
    public List<Feature> findAllFeature();

    int updateByPrimaryKey(Feature record);
}