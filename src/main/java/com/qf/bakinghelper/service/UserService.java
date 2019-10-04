package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.User;
import org.springframework.web.multipart.MultipartFile;


public interface UserService {


    public String getCode(String phone);

    public String regist(String code,String password);

    public String login(String phone,String password);

    public String loginOut(String token);

    public User userInfo(String token);

    public String updatePwdGetCode(String phone,String token);

    public Integer update(User user ,String token);

    public Integer updatePwd(String code,String password,String token);

    public Integer updateHeadImg(MultipartFile file, String token);


}
