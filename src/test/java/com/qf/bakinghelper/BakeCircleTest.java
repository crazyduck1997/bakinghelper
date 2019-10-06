package com.qf.bakinghelper;

import com.qf.bakinghelper.dao.BakeCircleDao;
import com.qf.bakinghelper.entity.BakeCircle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BakeCircleTest {

    @Autowired(required = false)
    BakeCircleDao bakeCircleDao;

    @Test
    public void testList(){
        List<BakeCircle> all = bakeCircleDao.selectAll();
        for(BakeCircle b :all){
            System.out.println(b);
        }

    }
    @Test
    public void testFindById(){
        BakeCircle select = bakeCircleDao.selectByPrimaryKey(1);
        System.out.println(select);
    }
}
