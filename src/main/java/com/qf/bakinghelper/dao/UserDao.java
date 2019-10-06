package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Medal;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.entity.Video;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer uid);

    List<User> selectAll();

    int updateByAccountId(User record);

    public User findByAccountId(String accountId);


    //查看收藏的视频
    public List<Video> findCollectVideos(Integer userId);

    //查看我的勋章
    public List<Medal> findMyMedals(Integer userId);

    //通过电话查询
    User findByPhone(String phone);
}