package com.qf.bakinghelper.Controller;

import com.qf.bakinghelper.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorServicea;

}
