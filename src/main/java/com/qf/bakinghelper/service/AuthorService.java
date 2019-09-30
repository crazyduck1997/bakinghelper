package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Author;

public interface AuthorService {
    //查询导师的信息及其他课程
    Author findAuthorById(Integer autherId);
}
