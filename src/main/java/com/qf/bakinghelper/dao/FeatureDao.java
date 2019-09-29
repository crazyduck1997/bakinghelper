package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Feature;
import java.util.List;

public interface FeatureDao {
    int deleteByPrimaryKey(Integer featureId);

    int insert(Feature record);

    Feature selectByPrimaryKey(Integer featureId);

    List<Feature> selectAll();

    int updateByPrimaryKey(Feature record);
}