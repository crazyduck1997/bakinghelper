package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.User;

public interface UserDao {

    public User findByPhone(String phone);

}
