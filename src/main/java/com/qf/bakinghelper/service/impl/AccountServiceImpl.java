package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.dao.AccountDao;
import com.qf.bakinghelper.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;


}
