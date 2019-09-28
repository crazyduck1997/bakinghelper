package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.Utils.PhoneCode;
import com.qf.bakinghelper.dao.UserDao;
import com.qf.bakinghelper.entity.User;
import com.qf.bakinghelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    /**
     * 手机号注册获取验证码
     * @param phone
     * @return
     */
    @Override
    public String findByPhone(String phone) {
        User user = userDao.findByPhone(phone);
        if(user!=null){
            throw new RuntimeException("手机号已注册");
        }
        PhoneCode.setNewcode();
        String code = String.valueOf(PhoneCode.getNewcode());
        try {
            PhoneCode.sendSms(String.valueOf(phone),code);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        stringRedisTemplate.opsForSet().add(phone+code,phone);
        stringRedisTemplate.opsForSet().add(phone,code);
        stringRedisTemplate.expire(phone+code,60*15, TimeUnit.SECONDS);
        stringRedisTemplate.expire(phone,60*5, TimeUnit.SECONDS);

        return "success";
    }

    /**
     * 校验验证码
     * @param code
     * @return
     */
    @Override
    public String verifyCode(String code) {
        Boolean key = stringRedisTemplate.hasKey(code);
        if(key==null){
            throw new RuntimeException("验证码过期，请重新获取");
        }
        return code;
    }

    @Override
    public User regist(String password,String code) {
        String phone = stringRedisTemplate.opsForSet().pop(code);
        User user = new User();
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0,8);
        user.setPhone(phone);
        user.setAccountId(uuid);
        user.setPassword(password);


        return null;
    }



}
