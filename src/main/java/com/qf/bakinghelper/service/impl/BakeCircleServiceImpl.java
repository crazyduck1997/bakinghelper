package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.BakeCircleDao;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.BakeCircle;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.BakeCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BakeCircleServiceImpl implements BakeCircleService {

    @Autowired(required = false)
    BakeCircleDao bakeCircleDao;


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    UserDao userDao;

    @Override
    public int deleteByPrimaryKey(Integer circleId) {
        return 0;
    }

    @Override
    public int insert(BakeCircle record,String token) {
        String acountId = stringRedisTemplate.opsForValue().get(token);
        User user = userDao.findByAccountId(acountId);
        record.setUserId(user.getUserId());
        record.setTime(new Date());
        record.setPraise("0");
        return bakeCircleDao.insert(record);
    }

    @Override
    public BakeCircle selectByPrimaryKey(Integer circleId) {
        BakeCircle bakeCircle = bakeCircleDao.selectByPrimaryKey(circleId);
        return bakeCircle;
    }

    @Override
    public List<BakeCircle> selectByTopicId(Integer topicId) {
        return bakeCircleDao.selectByTopicId(topicId);
    }

    @Override
    public List<BakeCircle> selectAll() {
        return bakeCircleDao.selectAll();
    }

    @Override
    public int updateByPrimaryKey(BakeCircle record) {
        return 0;
    }
}
