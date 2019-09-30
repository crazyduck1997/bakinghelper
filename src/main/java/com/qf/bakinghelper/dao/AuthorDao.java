package com.qf.bakinghelper.dao;


import com.qf.bakinghelper.entity.Author;

import java.util.List;

public interface AuthorDao {
    int deleteByPrimaryKey(Integer authorId);

    int insert(Author record);

    Author selectByPrimaryKey(Integer authorId);

    List<Author> selectAll();

    int updateByPrimaryKey(Author record);

    //查询导师的信息及其他课程
    Author findAuthorById(Integer autherId);


}