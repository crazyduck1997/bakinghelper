package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "账户管理api")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;


    @ApiOperation(value = "用户注册",notes = "发送验证码")
    @RequestMapping("/regist")
    public JsonBean<String> regist(Integer phone){
        String result = accountService.findByPhone(phone);
        return new JsonBean(1,result);
    }

}
