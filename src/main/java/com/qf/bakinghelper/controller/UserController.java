package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;


@Api(value = "用户")
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "校验手机号并获取验证码",notes = "发送验证码")
    @PostMapping("/getCode.do")
    public JsonBean<String> getCode(String phone){
        userService.getCode(phone);
        return new JsonBean(1,"验证码已发送");
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

    @ApiOperation(value = "修改个人设置，除头像")
    @PostMapping("/updateUser.do")
    public JsonBean updateUser(User user , String token){
        Integer integer = userService.update(user, token);
        return new JsonBean(integer,"修改成功");
    }

    @ApiOperation(value = "修改密码，手机验证")
    @PostMapping("/updatePwdVerifyPhone.do")
    public JsonBean updatePwdVerifyPhone(String phone,String token){
        userService.updatePwdGetCode(phone, token);
        return new JsonBean(1,"验证码已发送");
    }

    @ApiOperation(value = "验证")
    @PostMapping("/updatePwd.do")
    public JsonBean updatePwd(String code,String password,String token){
        Integer i = userService.updatePwd(code, password, token);
        return new JsonBean(i,"重置成功");
    }

}
