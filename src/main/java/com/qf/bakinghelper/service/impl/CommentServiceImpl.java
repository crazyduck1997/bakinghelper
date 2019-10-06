package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.CommentDao;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.Comment;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    CommentDao commentDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    UserDao userDao;

    @Override
    public int deleteByPrimaryKey(Integer commentId) {
        return 0;
    }

    @Override
    public int insert(Comment record,String token) {
        record.setCommentTime(new Date());
        String accountId = stringRedisTemplate.opsForValue().get(token);
        User user = userDao.findByAccountId(accountId);
        record.setUId(user.getUserId());
        return commentDao.insert(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer commentId) {
        return null;
    }

    @Override
    public List<Comment> selectAllByCircleId(Integer circleId) {
        return commentDao.selectAllByCircleId(circleId);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return 0;
    }
}
