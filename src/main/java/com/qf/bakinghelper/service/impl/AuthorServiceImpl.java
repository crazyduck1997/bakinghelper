package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AuthorDao;
import com.qf.bakinghelper.entity.Author;
import com.qf.bakinghelper.service.AuthorService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Resource
    AuthorDao authorDao;

    @Override
    public Author findAuthorById(Integer autherId) {

        Author author = authorDao.findAuthorById(autherId);

        return author;
    }
}
