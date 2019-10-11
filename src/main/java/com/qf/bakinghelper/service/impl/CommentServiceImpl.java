package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.BakeCircleDao;
import com.qf.bakinghelper.dao.CommentDao;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.BakeCircle;
import com.qf.bakinghelper.entity.Comment;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    CommentDao commentDao;

    @Autowired(required = false)
    BakeCircleDao bakeCircleDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    UserDao userDao;

    @Override
    public int deleteByPrimaryKey(Integer commentId) {
        return 0;
    }

    @Override
    public int insert(Map<String,Object> map) {
        String bakeCircleId = (String)map.get("bakeCircleId");
        String token = (String)map.get("token");
        String content = (String)map.get("content");
        Comment comment = new Comment();
        comment.setBakeCircleId(Integer.parseInt(bakeCircleId));
        comment.setContent(content);
        comment.setCommentTime(new Date());
        String accountId = stringRedisTemplate.opsForValue().get(token);
        User user = userDao.findByAccountId(accountId);
        comment.setUId(user.getUserId());
        int insert = commentDao.insert(comment);
        Integer circleId = comment.getBakeCircleId();
        BakeCircle bakeCircle = bakeCircleDao.selectByPrimaryKey(circleId);
        bakeCircle.setCommentNum(bakeCircle.getCommentNum()+1);
        bakeCircleDao.updateCommentNumByPrimaryKey(bakeCircle);
        return insert;
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
