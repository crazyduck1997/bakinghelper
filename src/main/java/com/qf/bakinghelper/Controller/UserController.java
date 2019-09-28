package com.qf.bakinghelper.Controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register.do")
    public JsonBean Login(String phone,String password, HttpSession session){
        User user = userService.Login(phone,password);
        session.setAttribute("user",user);
        return new JsonBean(1,user);
    }


}
