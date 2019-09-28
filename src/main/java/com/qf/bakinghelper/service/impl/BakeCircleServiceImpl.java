package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AuthorDao;
import com.qf.bakinghelper.dao.BakeCircleDao;
import com.qf.bakinghelper.service.BakeCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BakeCircleServiceImpl implements BakeCircleService {

    @Autowired
    BakeCircleDao bakeCircleDao;

}
