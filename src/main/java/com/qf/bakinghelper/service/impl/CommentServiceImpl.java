package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.CommentDao;
import com.qf.bakinghelper.entity.Comment;
import com.qf.bakinghelper.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    CommentDao commentDao;

    @Override
    public int deleteByPrimaryKey(Integer commentId) {
        return 0;
    }

    @Override
    public int insert(Comment record) {
        return commentDao.insert(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer commentId) {
        return null;
    }

    @Override
    public List<Comment> selectAll() {
        return commentDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return 0;
    }
}
