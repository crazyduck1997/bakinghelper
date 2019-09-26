package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public JsonBean Login(String phone) {
        User user = userDao.findByPhone(phone);

        return null;
    }
}
