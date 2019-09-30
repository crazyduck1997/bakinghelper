package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.FeatureDao;
import com.qf.bakinghelper.entity.Feature;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FiltureServiceImpl implements FeatureService {
    @Resource
    FeatureDao featureDao;
    @Override
    public List<Feature> findAllFeature() {
        List<Feature> featureList = featureDao.findAllFeature();
        return featureList;
    }

    @Override
    public List<Video> findOneFeatureAllVideoByFeatureId(Integer featureId) {
        List<Video> oneFeatureVideosList = featureDao.findOneFeatureAllVideoByFeatureId(featureId);
        return oneFeatureVideosList;
    }
}
