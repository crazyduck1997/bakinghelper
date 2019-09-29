package com.qf.bakinghelper.service.impl;

import com.qf.bakinghelper.Utils.MD5Utils;
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
        String token = MD5Utils.md5(code + "abc");
        stringRedisTemplate.opsForValue().set(token,phone);
        stringRedisTemplate.expire(token,60*5, TimeUnit.SECONDS);

        return token;
    }

    /**
     * 校验验证码
     * @param code
     * @return
     */
    @Override
    public String verifyCode(String code,String token) {
        String phone = stringRedisTemplate.opsForValue().get(token);
        if(phone==null || phone.equals("")){
            throw new RuntimeException("验证码过期，请重新获取");
        }
        String token2 = MD5Utils.md5(code + "abc");
        if(!token.equals(token2)){
            throw new RuntimeException("验证码错误");
        }
        return token;
    }

    /**
     * 完成注册
     * @param password
     * @param token
     * @return
     */
    @Override
    public User regist(String password,String token) {
        System.out.println(password+"---"+token);
        String phone = stringRedisTemplate.opsForValue().get(token);
        if(phone==null || phone.equals("")){
            throw new RuntimeException("操作超时，请重新注册");
        }
        User user = new User();
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0,8);
        user.setPhone(phone);
        user.setAccountId(uuid);
        user.setPassword(password);
        user.setSex("保密");
        user.setNickname("烘焙新手"+uuid.substring(0,4));
        userDao.insert(user);
        return user;
    }



}
