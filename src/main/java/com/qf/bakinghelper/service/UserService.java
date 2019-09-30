package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.User;

public interface UserService {


    public String getCode(String phone);

    public String regist(String code,String password);

    public String login(String phone,String password);

    public String loginOut(String token);

    public User userInfo(String token);

    public String updatePwdGetCode(String phone,String token);

}
