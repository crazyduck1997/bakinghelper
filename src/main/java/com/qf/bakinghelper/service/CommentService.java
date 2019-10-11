package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Map<String,Object> map);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAllByCircleId(Integer circle);

    int updateByPrimaryKey(Comment record);
}
