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

import java.text.SimpleDateFormat;
import java.util.Date;
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
     *
     * @param phone
     * @return
     */
    @Override
    public String getCode(String phone) {
        User user = userDao.findByPhone(phone);
        if (user != null) {
            throw new RuntimeException("手机号已注册");
        }
        PhoneCode.setNewcode();
        String code = String.valueOf(PhoneCode.getNewcode());
        try {
            PhoneCode.sendSms(phone, code);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        String token = MD5Utils.md5(code + "abc");
        stringRedisTemplate.opsForValue().set(token, phone);
        stringRedisTemplate.expire(token, 5, TimeUnit.MINUTES);

        return token;
    }

    /**
     * 校验验证码
     *
     * @param code
     * @param password
     * @return
     */
    @Override
    public String regist(String code, String token, String password) {
        String phone = stringRedisTemplate.opsForValue().get(token);
        if (phone == null || phone.equals("")) {
            throw new RuntimeException("验证码过期，请重新获取");
        }
        String token2 = MD5Utils.md5(code + "abc");
        if (!token.equals(token2)) {
            throw new RuntimeException("验证码错误");
        }
        User user = new User();
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        user.setPhone(phone);
        user.setAccountId(uuid);
        user.setPassword(password);
        user.setNickname("烘焙新手" + uuid.substring(0, 4));
        userDao.insert(user);
        stringRedisTemplate.delete(token);
        token= MD5Utils.getToken();
        stringRedisTemplate.opsForValue().set(token,user.getAccountId());
        return token;
    }


    /**
     * 手机号密码登录
     *
     * @param phone
     * @return
     */
    @Override
    public String login(String phone, String password) {
        User user = userDao.findByPhone(phone);
        if (user == null) {
            throw new RuntimeException("手机号错误");
        }
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }
        String token = MD5Utils.getToken();
        stringRedisTemplate.opsForValue().set(token,user.getAccountId());
        return token;
    }


    /**
     * 用户注销
     *
     * @param token
     * @return
     */
    @Override
    public String loginOut(String token) {
        stringRedisTemplate.delete(token);
        return "注销成功";
    }


    /**
     * 个人信息展示
     *
     * @param token
     * @return
     */
    @Override
    public User userInfo(String token) {
        String accountId = stringRedisTemplate.opsForValue().get(token);
        if (accountId == null || accountId.equals("")) {
            throw new RuntimeException("请重新登录");
        }
        User user = userDao.findByAccountId(accountId);
        if (user == null) {
            throw new RuntimeException("请联系管理员");
        }
        return user;
    }

    /**
     * 修改密码验证手机
     *
     * @param phone
     * @param token
     * @return
     */
    @Override
    public String updatePwdGetCode(String phone, String token) {
        String account_id = stringRedisTemplate.opsForValue().get(token);
        User user = userDao.findByAccountId(account_id);
        if (!phone.equals(user.getPhone())) {
            throw new RuntimeException("手机号输入有误");
        }
        PhoneCode.setNewcode();
        String code = String.valueOf(PhoneCode.getNewcode());
        try {
            PhoneCode.sendSms(phone, code);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        token = MD5Utils.md5(code + "abc");
        stringRedisTemplate.opsForValue().set(token, phone);
        stringRedisTemplate.expire(token, 5, TimeUnit.MINUTES);
        return token;
    }


}
