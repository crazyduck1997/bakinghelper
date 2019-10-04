package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.TechnologyDao;
import com.qf.bakinghelper.entity.TechTitle;
import com.qf.bakinghelper.entity.Technology;
import com.qf.bakinghelper.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired(required = false)
    TechnologyDao technologyDao;

    @Override
    public List<Technology> findAllTech() {
        List<Technology> allTech = technologyDao.findAllTech();
        return allTech;
    }

    @Override
    public List<TechTitle> findSkillById(Integer bakeId) {
        List<TechTitle> skills = technologyDao.findSkillById(bakeId);
        return skills;
    }

    @Override
    public TechTitle findOneById(Integer techId) {
        TechTitle techList = technologyDao.findOneById(techId);
        return techList;
    }

}
