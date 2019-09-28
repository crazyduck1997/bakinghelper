package com.qf.bakinghelper.Controller;

import com.qf.bakinghelper.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;
}
