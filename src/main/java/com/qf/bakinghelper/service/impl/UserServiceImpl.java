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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        String mdCode = MD5Utils.md5(code + "abc");
        stringRedisTemplate.opsForValue().set(mdCode, phone);
        stringRedisTemplate.expire(mdCode, 5, TimeUnit.MINUTES);
        return mdCode;
    }

    /**
     * 校验验证码
     *
     * @param code
     * @param password
     * @return
     */
    @Override
    public String regist(String code, String password) {
        String mdCode = MD5Utils.md5(code + "abc");
        String phone = stringRedisTemplate.opsForValue().get(mdCode);
        if (phone == null || phone.equals("")) {
            throw new RuntimeException("验证码错误，请重新获取");
        }
        User user = new User();
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        user.setPhone(phone);
        user.setAccountId(uuid);
        user.setPassword(password);
        user.setNickname("烘焙新手" + uuid.substring(0, 4));
        user.setSex("保密");
        user.setBanggong(20);
        user.setFansNum(0);
        user.setWatchNum(0);
        user.setGrade("1");
        user.setMedal(0);
        userDao.insert(user);
        String token = MD5Utils.getToken();
        stringRedisTemplate.opsForValue().set(token, user.getAccountId());
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
        stringRedisTemplate.opsForValue().set(token, user.getAccountId());
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
        if (account_id == null || account_id.equals("")) {
            throw new RuntimeException("请重新登录");
        }
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
        String mdCode = MD5Utils.md5(code + "abc");
        stringRedisTemplate.opsForValue().set(mdCode, phone);
        stringRedisTemplate.expire(mdCode, 5, TimeUnit.MINUTES);
        return mdCode;
    }


    /**
     * 修改除头像的个人信息
     *
     * @param user
     * @param token
     * @return
     */
    @Override
    public Integer update(User user, String token) {
        String accountId = stringRedisTemplate.opsForValue().get(token);
        if (accountId == null || accountId.equals("")) {
            throw new RuntimeException("请重新登录");
        }
        User user1 = userDao.findByAccountId(accountId);
        user.setAccountId(user1.getAccountId());
        int i = userDao.updateByAccountId(user);
        return i;
    }

    @Override
    public Integer updatePwd(String code, String password, String token) {
        String mdCode = MD5Utils.md5(code + "abc");
        String phone = stringRedisTemplate.opsForValue().get(mdCode);
        if (phone == null || phone.equals("")) {
            throw new RuntimeException("验证码失效，请重新获取");
        }
        String accountId = stringRedisTemplate.opsForValue().get(token);
        if (accountId == null || accountId.equals("")) {
            throw new RuntimeException("请重新登录");
        }
        User user = userDao.findByAccountId(accountId);
        user.setPassword(password);
        int i = userDao.updateByAccountId(user);
        return i;
    }

    @Override
    public Integer updateHeadImg(MultipartFile file, String token) {
        if(file.isEmpty()){
            throw new RuntimeException("请选择文件");
        }
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString().replace("-","");
        String filePath = "/usr/local/tomcat/webapps/headImgs/";
        File dest = new File(filePath + fileName + ".jpg");
        try {
            file.transferTo(dest);
            String accountId = stringRedisTemplate.opsForValue().get(token);
            User user = userDao.findByAccountId(accountId);
            user.setHeadImg("http://47.240.68.134:8889/headImgs/"+fileName + ".jpg");
            int i = userDao.updateByAccountId(user);
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("上传失败");
    }
}
