package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AuthorDao;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
}
