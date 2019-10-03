package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Comment;

import java.util.List;

public interface CommentService {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}
