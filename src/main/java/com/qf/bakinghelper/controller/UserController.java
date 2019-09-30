package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "用户")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "校验手机号并获取验证码",notes = "发送验证码")
    @PostMapping("/getCode.do")
    public JsonBean<String> getCode(String phone){
        String mdCode = userService.getCode(phone);
        return new JsonBean(1,mdCode);
    }

    @ApiOperation(value = "校验验证码,完成注册")
    @PostMapping("/verifyCode.do")
    public JsonBean verifyCode(String code,String password){
        String token = userService.regist(code,password);
        return new JsonBean(1,token);
    }


    @ApiOperation(value = "手机号密码登录")
    @PostMapping("/login.do")
    public JsonBean login(String phone,String password){
        String token = userService.login(phone, password);
        return new JsonBean(1,token);
    }


    @ApiOperation(value = "用户注销")
    @PostMapping("/loginOut.do")
    public JsonBean loginOut(String token){
        String loginOut = userService.loginOut(token);
        return new JsonBean(1,loginOut);
    }

    @ApiOperation(value = "个人信息展示以及账户信息展示")
    @PostMapping("/userInfo.do")
    public JsonBean userInfo(String token){
        User user = userService.userInfo(token);
        return new JsonBean(1,user);
    }





}
