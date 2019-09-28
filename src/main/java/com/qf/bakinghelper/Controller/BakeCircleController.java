package com.qf.bakinghelper.Controller;

import com.qf.bakinghelper.service.BakeCircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BakeCircleController {

    @Autowired
    BakeCircleService bakeCircleService;

}
