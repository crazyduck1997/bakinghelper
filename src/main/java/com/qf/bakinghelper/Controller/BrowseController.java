package com.qf.bakinghelper.Controller;

import com.qf.bakinghelper.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BrowseController {

    @Autowired
    BrowseService browseService;
}
