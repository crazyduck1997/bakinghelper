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

    public User selectByPrimaryKey(Integer userId);

    public Integer getParise(Integer bakeCricleId);

    public Integer pariseRollBack(Integer bakeCircleId);

    public List<Question> findMyQuestions(String token);

    public Integer addAnswerPraiseNum(Integer aId);

    public Integer answerPraiseNumRollBack(Integer aId);

    public Integer addQuestion(Question question,MultipartFile file, String token);

    public Integer addAnswer(String token,String aContent,Integer qId);

    public Integer deleteQuestion(Integer qId);

    public String checkLogin(String token);

}
