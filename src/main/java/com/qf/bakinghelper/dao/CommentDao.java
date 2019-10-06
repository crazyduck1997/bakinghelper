package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Comment;

import java.util.List;

public interface CommentDao {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAllByCircleId(Integer circleId);

    int updateByPrimaryKey(Comment record);
}