package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


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

    public List<CollectFoodOrder> findMyFoodOrder(String token);

    public List<Recipe> findRecipesByCid(Integer cid);

    public void addFoodOrder(CollectFoodOrder collectFoodOrder,String token);

    public List<Video> findCollectVideos(String token);

    public List<Medal> findMyMedals(String token);


}
