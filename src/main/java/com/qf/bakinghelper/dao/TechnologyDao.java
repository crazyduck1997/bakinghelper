package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.TechTitle;
import com.qf.bakinghelper.entity.Technology;

import java.util.List;

public interface TechnologyDao {

    //遍历技巧百科
    public List<Technology> findAllTech();

    //查询所有基础技巧、工具材料、进阶干货、精选专题信息
    public List<TechTitle> findSkillById(Integer bakeId);

    //根据Id查询对应的话题内容
    public TechTitle findOneById(Integer techId);

}
