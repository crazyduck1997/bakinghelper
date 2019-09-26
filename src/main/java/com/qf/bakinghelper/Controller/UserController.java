package com.qf.bakinghelper.Controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/Login")
    public JsonBean Login(String phone){
        JsonBean bean = userService.Login(phone);
        return bean;
    }


}
