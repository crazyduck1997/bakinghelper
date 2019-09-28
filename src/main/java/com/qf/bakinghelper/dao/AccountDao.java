package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Account;

import java.util.List;

public interface AccountDao {

    //通过电话查询
    Account findByPhone(Integer phone);

    //通过主键删除
    int deleteByPrimaryKey(Integer accountId);

    //添加账户
    int insert(Account record);

    //通过主键查询
    Account selectByPrimaryKey(Integer accountId);

    //查询所有账户
    List<Account> selectAll();

    //通过主键修改
    int updateByPrimaryKey(Account record);
}
