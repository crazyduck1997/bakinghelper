package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.User;

public interface UserService {


    public String getCode(String phone);

    public String verifyCode(String code,String token);

    public User regist(String password, String token);

    public User login(String phone,String password);


}
