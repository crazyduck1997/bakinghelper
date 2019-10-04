package com.qf.bakinghelper;

import com.qf.bakinghelper.dao.TechnologyDao;
import com.qf.bakinghelper.entity.TechTitle;
import com.qf.bakinghelper.entity.Technology;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechnologyTest {

    @Resource
    TechnologyDao technologyDao;

    @Test
    public void findAllTechTest(){
        List<Technology> allTech = technologyDao.findAllTech();
        System.out.println(allTech);
    }

    @Test
    public void findSkillById(){
        List<TechTitle> skills = technologyDao.findSkillById(1);
        for(TechTitle techTitle : skills){
            System.out.println(techTitle);
        }
        System.out.println(skills);
    }

    @Test
    public void findOne(){
        TechTitle techList = technologyDao.findOneById(18);
            System.out.println(techList);
    }
}
