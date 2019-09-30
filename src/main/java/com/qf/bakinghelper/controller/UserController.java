package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Api(value = "用户")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "校验手机号并获取验证码",notes = "发送验证码")
    @PostMapping("/getCode.do")
    public JsonBean<String> getCode(String phone){
        String token = userService.getCode(phone);
        return new JsonBean(1,token);
    }

    @ApiOperation(value = "校验验证码")
    @PostMapping("/verifyCode.do")
    public JsonBean verifyCode(String code,String token){
        userService.verifyCode(code, token);
        System.out.println(token);
        return new JsonBean(1,token);
    }

    @ApiOperation(value = "获取密码完成注册")
    @PostMapping("/regist.do")
    public JsonBean regist(String password, String token){
        User user = userService.regist(password, token);
        return new JsonBean(1,"成功");
    }

    @ApiOperation(value = "手机号密码登录")
    @PostMapping("/login.do")
    public JsonBean login(String phone,String password){
        User user = userService.login(phone,password);
        return new JsonBean(1,user);
    }

}
