package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.BrowseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseServiceImpl {

    @Autowired
    BrowseDao browseDao;
}
