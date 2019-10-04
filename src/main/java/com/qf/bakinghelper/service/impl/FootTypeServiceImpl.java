package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.FootTypeDao;
import com.qf.bakinghelper.entity.FootType;
import com.qf.bakinghelper.service.FootTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootTypeServiceImpl implements FootTypeService {


    @Autowired
    FootTypeDao footTypeDao;
    @Override
    //    根据具体的食品类型查询所有的食品
    public List<FootType> footTypeList() {
        return footTypeDao.footTypeList();
    }
}
