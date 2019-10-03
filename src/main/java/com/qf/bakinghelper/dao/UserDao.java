package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.User;
import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    public User findByAccountId(String accountId);


    //通过电话查询
    User findByPhone(String phone);
}