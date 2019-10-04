package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.CollectFoodOrder;

import java.util.List;

public interface CollectFoodOrderDao {

    public List<CollectFoodOrder> findCollectByUid(Integer userId);

    public void addFoodOrder(CollectFoodOrder collectFoodOrder);


}
