package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.User;

public interface UserService {


    public String findByPhone(String phone);

    public String verifyCode(String code);

    public User regist(String password, String code);


}
