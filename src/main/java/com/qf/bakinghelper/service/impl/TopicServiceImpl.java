package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.TopicDao;
import com.qf.bakinghelper.entity.Topic;
import com.qf.bakinghelper.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired(required = false)
    TopicDao topicDao;

    @Override
    public List<Topic> selectAll() {
        return topicDao.selectAll();
    }
}
