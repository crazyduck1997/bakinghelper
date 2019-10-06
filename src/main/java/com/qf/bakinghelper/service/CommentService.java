package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Comment;

import java.util.List;

public interface CommentService {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record,String token);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAllByCircleId(Integer circle);

    int updateByPrimaryKey(Comment record);
}
