package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.DetailDao;
import com.qf.bakinghelper.entity.Detail;
import com.qf.bakinghelper.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {


    @Autowired
    DetailDao detailDao;


    @Override
    //在食谱分类中根据食品的类型查询具体的分类
    public List<Detail> detailList() {
        return detailDao.detailList();
    }
}
