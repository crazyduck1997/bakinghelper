package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.User;

import java.util.List;

public interface UserDao {

    public User findByPhone(String phone);

    public List<User> findAllUser();

    public void addUser(User user);

}
