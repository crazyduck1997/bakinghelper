package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.TypeDao;
import com.qf.bakinghelper.entity.Type;
import com.qf.bakinghelper.entity.Video;
import com.qf.bakinghelper.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;
    @Override
    public List<Type> selectAll() {
        List<Type> types = typeDao.selectAll();
        return types;
    }

    @Override
    public List<Video> findOneTypeVideosByTypeId(Integer typeId) {
        List<Video> oneTypeVideos = typeDao.findOneTypeVideosByTypeId(typeId);
        return oneTypeVideos;
    }
}
