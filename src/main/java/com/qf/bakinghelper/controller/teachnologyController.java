package com.qf.bakinghelper.controller;


import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.TechTitle;
import com.qf.bakinghelper.entity.Technology;
import com.qf.bakinghelper.service.TechnologyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "技巧百科")
@CrossOrigin
@RestController
public class teachnologyController {
    @Autowired(required = false)
    private TechnologyService technologyService;


    @ApiOperation(value = "获取技巧百科中所有分类(基础技巧，进阶干货等)")
    @PostMapping("/findAllBackName.do")
    public JsonBean findAllBackName(){
        List<Technology> allTechList = technologyService.findAllTech();
        return new JsonBean(1,allTechList);
    }

    @ApiOperation(value = "获取技巧百科中每一个分类对应的内容")
    @PostMapping("/skillList.do")
    public JsonBean skillList(Integer bakeId){
        List<TechTitle> skillList = technologyService.findSkillById(bakeId);
        return new JsonBean(1,skillList);
    }

    @ApiOperation(value = "根据Id查询对应的话题内容")
    @PostMapping("/findOne.do")
    public JsonBean findOne(Integer techId){
        TechTitle techList = technologyService.findOneById(techId);
        return new JsonBean(1,techList);
    }
}
