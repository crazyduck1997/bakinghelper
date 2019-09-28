package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.User;

public interface UserService {


    public User Login(String phone,String password);

    public void addUser();
}
