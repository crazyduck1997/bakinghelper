package com.qf.bakinghelper.service.impl;

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
    public User Login(String phone,String password){
        User user = userDao.findByPhone(phone);
        if(user == null){
            throw new RuntimeException("手机号错误");
        }
        return user;
    }

    @Override
    public void addUser() {

    }

}
