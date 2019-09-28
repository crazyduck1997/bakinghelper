package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "获取验证码",notes = "发送验证码")
    @PostMapping("/getCode.do")
    public JsonBean<String> getCode(String phone){
        System.out.println(phone);
        String result = userService.findByPhone(phone);
        return new JsonBean(1,phone);
    }

    @RequestMapping("/verifyCode.do")
    public JsonBean verifyCode(String code){
        userService.verifyCode(code);
        return new JsonBean(1,code);
    }

    @RequestMapping("/regit.do")
    public JsonBean regist(String password){
        return null;
    }



}
