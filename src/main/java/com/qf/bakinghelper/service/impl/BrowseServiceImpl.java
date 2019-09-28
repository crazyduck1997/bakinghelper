package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AuthorDao;
import com.qf.bakinghelper.dao.BrowseDao;
import com.qf.bakinghelper.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseServiceImpl implements BrowseService {

    @Autowired
    BrowseDao browseDao;
}
