package com.qf.bakinghelper.service;

import com.qf.bakinghelper.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TopicService {
    List<Topic> selectAll();
}
