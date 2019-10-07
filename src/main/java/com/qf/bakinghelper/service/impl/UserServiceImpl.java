package com.qf.bakinghelper.service.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.qf.bakinghelper.Utils.MD5Utils;
import com.qf.bakinghelper.Utils.PhoneCode;
import com.qf.bakinghelper.dao.*;
import com.qf.bakinghelper.entity.*;
import com.qf.bakinghelper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    CollectFoodOrderDao collectFoodOrderDao;

    @Autowired
    RecipeDao recipeDao;

    @Autowired
    BakeCircleDao bakeCircleDao;

    @Autowired
    QuestionDao questionDao;

    @Autowired
    AnswerDao answerDao;

    @Autowired
    CollectVideosDao collectVideosDao;

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
        String message = "短信发送失败，但是，没关系，验证码是:";
        if (user != null) {
            throw new RuntimeException("手机号已注册");
        }
        PhoneCode.setNewcode();
        String code = String.valueOf(PhoneCode.getNewcode());
        try {
            SendSmsResponse sendSmsResponse = PhoneCode.sendSms(phone, code);
            if(sendSmsResponse.getCode()!= null && sendSmsResponse.getCode().equals("OK")){
                message = "短信发送成功:";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        String mdCode = MD5Utils.md5(code + "abc");
        stringRedisTemplate.opsForValue().set(mdCode, phone);
        stringRedisTemplate.expire(mdCode, 5, TimeUnit.MINUTES);
        return message+code;
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
        stringRedisTemplate.delete(mdCode);
        if (phone == null || phone.equals("")) {
            throw new RuntimeException("验证码错误，请重新获取");
        }
        User byPhone = userDao.findByPhone(phone);
        if(byPhone!=null){
            throw new RuntimeException("手机号已注册");
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
        user.setHeadImg("http://47.240.68.134:8889/headImgs/03.jpg");
        user.setMedal(0);
        userDao.insert(user);
        String token = MD5Utils.getToken();
        String mdAccountId = MD5Utils.md5(uuid + "abc");
        stringRedisTemplate.opsForValue().set(mdAccountId,token);
        stringRedisTemplate.expire(mdAccountId,14,TimeUnit.DAYS);
        stringRedisTemplate.opsForValue().set(token, user.getAccountId());
        stringRedisTemplate.expire(token,14,TimeUnit.DAYS);
        return token;
    }


    /**
     * 手机号密码登录和免登录
     *
     * @param phone
     * @return
     */
    @Override
    public String login(String phone, String password,String token) {
        if(token == null || token.equals("")){
            User user = userDao.findByPhone(phone);
            if (user == null) {
                throw new RuntimeException("手机号错误");
            }
            if (!user.getPassword().equals(password)) {
                throw new RuntimeException("密码错误");
            }
            String newToken = MD5Utils.getToken();
            String mdAccountId = MD5Utils.md5(user.getAccountId() + "abc");
            String oldToken = stringRedisTemplate.opsForValue().get(mdAccountId);
            stringRedisTemplate.delete(oldToken);
            stringRedisTemplate.opsForValue().set(mdAccountId,newToken);
            stringRedisTemplate.opsForValue().set(newToken, user.getAccountId());
            stringRedisTemplate.expire(newToken,14,TimeUnit.DAYS);
            stringRedisTemplate.expire(mdAccountId,14,TimeUnit.DAYS);
            return newToken;
        }
        String newToken = MD5Utils.getToken();
        String accountId = stringRedisTemplate.opsForValue().get(token);
        String mdAccountId = MD5Utils.md5(accountId + "abc");
        stringRedisTemplate.delete(token);
        stringRedisTemplate.opsForValue().set(mdAccountId,newToken);
        stringRedisTemplate.opsForValue().set(newToken,accountId);
        stringRedisTemplate.expire(newToken,14,TimeUnit.DAYS);
        stringRedisTemplate.expire(mdAccountId,14,TimeUnit.DAYS);
        return newToken;
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
        User user = tokenToUser(token);
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
        return code;
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


    /**
     * 修改密码
     * @param code
     * @param password
     * @param token
     * @return
     */
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


    /**
     * 修改头像
     * @param file
     * @param token
     * @return
     */
    @Override
    public Integer updateHeadImg(MultipartFile file, String token) {
        if(file.isEmpty()){
            throw new RuntimeException("请选择文件");
        }
        UUID uuid = UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        String fileName = uuid.toString().replace("-","");
        String filePath = "/usr/local/tomcat/webapps/headImgs/";
        File dest = new File(filePath + fileName + originalFilename);
        try {
            file.transferTo(dest);
            String accountId = stringRedisTemplate.opsForValue().get(token);
            User user = userDao.findByAccountId(accountId);
            user.setHeadImg("http://47.240.68.134:8889/headImgs/"+fileName + originalFilename);
            int i = userDao.updateByAccountId(user);
            return i;
        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("上传失败");
    }


    /**
     * 查看我收藏的食单
     * @param token
     * @return
     */
    @Override
    public List<CollectFoodOrder> findMyFoodOrder(String token) {
        User user = tokenToUser(token);
        List<CollectFoodOrder> list = collectFoodOrderDao.findCollectByUid(user.getUserId());
        return list;
    }


    /**
     * 通过收藏的食单id查询里面的食谱
     * @param cid
     * @return
     */
    @Override
    public List<Recipe> findRecipesByCid(Integer cid) {
        List<Recipe> list = recipeDao.findRecipesByCollectId(cid);
        return list;
    }

    /**
     * 查看我收藏的食单
     * @param collectFoodOrder
     * @param token
     */
    @Override
    public void addFoodOrder(CollectFoodOrder collectFoodOrder,String token) {
        User user = tokenToUser(token);
        collectFoodOrder.setUId(user.getUserId());
        collectFoodOrderDao.addFoodOrder(collectFoodOrder);
    }

    /**
     * 查看我收藏的视频
     * @param token
     * @return
     */
    @Override
    public List<Video> findCollectVideos(String token) {
        User user = tokenToUser(token);
        List<Video> list = userDao.findCollectVideos(user.getUserId());
        return list;
    }

    /**
     * 查看拥有的勋章
     * @param token
     * @return
     */
    @Override
    public List<Medal> findMyMedals(String token) {
        User user = tokenToUser(token);
        List<Medal> list = userDao.findMyMedals(user.getUserId());
        return list;
    }

    /**
     * 通过id查看用户信息
     * @param uid
     * @return
     */
    @Override
    public User selectByPrimaryKey(Integer uid) {
        User user = userDao.selectByPrimaryKey(uid);
        return user;
    }

    /**
     * 动态点赞
     * @param bakeCircleId
     * @return
     */
    @Override
    public Integer getParise(Integer bakeCircleId) {
        BakeCircle circle = bakeCircleDao.selectByPrimaryKey(bakeCircleId);
        circle.setPraise(String.valueOf(Integer.parseInt(circle.getPraise())+1));
        int i = bakeCircleDao.updatePraiseByPrimaryKey(circle);
        return i;
    }

    /**
     * 动态取消赞
     * @param bakeCircleId
     * @return
     */
    @Override
    public Integer pariseRollBack(Integer bakeCircleId) {
        BakeCircle bakeCircle = bakeCircleDao.selectByPrimaryKey(bakeCircleId);
        bakeCircle.setPraise(String.valueOf(Integer.parseInt(bakeCircle.getPraise())-1));
        int i = bakeCircleDao.updatePraiseByPrimaryKey(bakeCircle);
        return i;
    }

    /**
     * 查看我的问答
     * @param token
     * @return
     */
    @Override
    public List<Question> findMyQuestions(String token) {
        User user = tokenToUser(token);
        List<Question> list = questionDao.findMyQuestions(user.getUserId());
        return list;
    }

    /**
     * 给当前回答点赞
     * @param aId
     * @return
     */
    @Override
    public Integer addAnswerPraiseNum(Integer aId) {
        Answer answer = answerDao.findAnswerByByPrimaryKey(aId);
        answer.setAPraise(answer.getAPraise()+1);
        Integer integer = answerDao.updatePraiseNum(answer);
        return integer;
    }

    /**
     * 当前回答取消赞
     * @param aId
     * @return
     */
    @Override
    public Integer answerPraiseNumRollBack(Integer aId) {
        Answer answer = answerDao.findAnswerByByPrimaryKey(aId);
        answer.setAPraise(answer.getAPraise()-1);
        Integer integer = answerDao.updatePraiseNum(answer);
        return integer;
    }

    /**
     * 提出问题
     * @param question
     * @param file
     * @param token
     * @return
     */
    @Override
    public Integer addQuestion(Question question,MultipartFile file, String token) {
        User user = tokenToUser(token);
        question.setUId(user.getUserId());
        question.setAnswerNum(0);
        question.setQTime(new Date());
        if(file!=null){
            UUID uuid = UUID.randomUUID();
            String originalFilename = file.getOriginalFilename();
            String fileName = uuid.toString().replace("-","");
            String filePath = "/usr/local/tomcat/webapps/images/questionImgs/";
            File dest = new File(filePath + fileName + originalFilename);
            try {
                file.transferTo(dest);
                question.setQImg("http://47.240.68.134:8889/images/questionImgs/"+fileName + originalFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Integer integer = questionDao.addQuestion(question);
        return integer;
    }

    /**
     * 添加回答
     * @param token
     * @param aContent
     * @param qId
     * @return
     */
    @Override
    public Integer addAnswer(String token,String aContent, Integer qId) {
        User user = tokenToUser(token);
        Answer answer = new Answer();
        answer.setAContent(aContent);
        answer.setUId(user.getUserId());
        answer.setQId(qId);
        answer.setAPraise(0);
        answer.setADate(new Date());
        Integer integer = answerDao.addAnswer(answer);
        Question question = questionDao.findQuestionByprimaryKey(qId);
        System.out.println(question);
        question.setAnswerNum(question.getAnswerNum()+1);
        questionDao.updateAnswerNums(question);
        return integer;
    }


    /**
     * 删除我的问题
     * @param token
     * @param qId
     * @return
     */
    @Override
    public Integer deleteQuestion(String token,Integer qId) {
        User user = tokenToUser(token);
        Integer integer = questionDao.deleteQuestion(qId);
        return integer;
    }


    /**
     * 添加到收藏视频
     * @param token
     * @param videoId
     */
    @Override
    public void addCollectVideos(String token, Integer videoId) {
        User user = tokenToUser(token);
        CollectVideos collectVideos = new CollectVideos();
        collectVideos.setUId(user.getUserId());
        collectVideos.setVId(videoId);
        collectVideosDao.insertCollectVideo(collectVideos);
    }

    /**
     * 删除我收藏的视频
     * @param token
     * @param vIds
     */
    @Override
    public void deleteCollectVideos(String token, List<Integer> vIds) {
        User user = tokenToUser(token);
        collectVideosDao.deleteCollectVideo(user.getUserId(),vIds);
    }


    public User tokenToUser(String token){
        String accountId = stringRedisTemplate.opsForValue().get(token);
        if(accountId==null || accountId.equals("")){
            throw new RuntimeException("请重新登录");
        }
        User user = userDao.findByAccountId(accountId);
        if(user==null){
            throw new RuntimeException("请联系管理员");
        }
        return user;
    }




}
