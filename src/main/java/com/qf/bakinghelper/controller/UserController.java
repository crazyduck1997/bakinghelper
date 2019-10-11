package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.*;
import com.qf.bakinghelper.service.BakeCircleService;
import com.qf.bakinghelper.service.CommentService;
import com.qf.bakinghelper.service.UserService;
import com.qf.bakinghelper.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Api(value = "用户", tags = "用户相关")
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    VideoService videoService;

    @Autowired
    BakeCircleService bakeCircleService;

    @Autowired
    CommentService commentService;

    @PostMapping("/add.do")
    @ApiOperation("添加评论(把content,bakeCircleId和token传来即可)")
    public JsonBean add(@RequestBody Map<String,Object> map) {
        commentService.insert(map);
        return new JsonBean(1, "评论成功");
    }


    @ApiOperation(value = "校验手机号并获取验证码", notes = "发送验证码")
    @PostMapping("/getCode.do")
    public JsonBean<String> getCode(String phone) {
        String code = userService.getCode(phone);
        return new JsonBean(1, code);
    }

    @ApiOperation(value = "校验验证码,完成注册")
    @PostMapping("/verifyCode.do")
    public JsonBean verifyCode(String code, String password) {
        String token = userService.regist(code, password);
        return new JsonBean(1, token);
    }


    @ApiOperation(value = "手机号密码登录和免登录",notes = "根据传过来的token有无来判断")
    @PostMapping("/login.do")
    public JsonBean login(String phone, String password,String token) {
        String newToken = userService.login(phone, password,token);
        return new JsonBean(1, newToken);
    }


    @ApiOperation(value = "用户注销")
    @PostMapping("/loginOut.do")
    public JsonBean loginOut(String token) {
        String loginOut = userService.loginOut(token);
        return new JsonBean(1, loginOut);
    }

    @ApiOperation(value = "个人信息展示以及账户信息展示")
    @PostMapping("/userInfo.do")
    public JsonBean userInfo(String token) {
        User user = userService.userInfo(token);
        return new JsonBean(1, user);
    }

    @ApiOperation(value = "修改个人设置，除头像,地址",notes = "用户设置具体传要传什么看蓝湖")
    @PostMapping("/updateUser.do")
    public JsonBean updateUser(@ApiParam(value = "昵称，性别，简介，邮箱，其他不传")User user, String token) {
        Integer integer = userService.update(user, token);
        return new JsonBean(integer, "修改成功");
    }

    @ApiOperation(value = "修改密码，手机验证")
    @PostMapping("/updatePwdVerifyPhone.do")
    public JsonBean updatePwdVerifyPhone(String phone, String token) {
        String code = userService.updatePwdGetCode(phone, token);
        return new JsonBean(1, code);
    }

    @ApiOperation(value = "修改密码,验证验证码")
    @PostMapping("/updatePwd.do")
    public JsonBean updatePwd(String code, String password, String token) {
        Integer i = userService.updatePwd(code, password, token);
        return new JsonBean(i, "重置成功");
    }

    @ApiOperation(value = "修改头像")
    @PostMapping("/updateHeadImg.do")
    public JsonBean updateHeadImg(MultipartFile file, String token) {
        Integer i = userService.updateHeadImg(file, token);
        return new JsonBean(i, "上传成功");
    }

    @ApiOperation(value = "查看我收藏的食单")
    @PostMapping("/findMyFoodOrder.do")
    public JsonBean findMyFoodOrder(String token) {
        List<CollectFoodOrder> list = userService.findMyFoodOrder(token);
        return new JsonBean(1, list);
    }

    @ApiOperation(value = "查看收藏的食单中的食谱")
    @PostMapping("/findRecipeByCid.do")
    public JsonBean findRecipeByCid(@ApiParam(value = "当前食单的id") Integer cid) {
        List<Recipe> list = userService.findRecipesByCid(cid);
        return new JsonBean(1, list);
    }

    @ApiOperation(value = "新建食单")
    @PostMapping("/addFoodOrder.do")
    public JsonBean addFoodOrder(CollectFoodOrder collectFoodOrder, String token) {
        userService.addFoodOrder(collectFoodOrder, token);
        return new JsonBean(1, "success");
    }

    @ApiOperation(value = "查看我收藏的所有课程")
    @PostMapping("/findAllCollectVideos.do")
    public JsonBean findAllCollectVideos(String token) {
        List<Video> list = userService.findCollectVideos(token);
        return new JsonBean(1, list);
    }

    @ApiOperation(value = "查看单个收藏课程的详细信息")
    @PostMapping("/findOneCollectVideo.do")
    public JsonBean findOneCollectVideo(Integer videoId) {
        Video video = videoService.findOneVideoMessageByVideoId(videoId);
        return new JsonBean(1, video);
    }

    @ApiOperation(value = "查看我的勋章")
    @PostMapping("/findMyMedals.do")
    public JsonBean<List<Medal>> findMyMedals(String token) {
        System.out.println(token);
        List<Medal> list = userService.findMyMedals(token);
        return new JsonBean<>(1, list);
    }

    @ApiOperation(value = "给动态点赞")
    @PostMapping("/getParise.do")
    public JsonBean getParise(@ApiParam(value = "动态的id") Integer bakeCircleId) {
        Integer integer = userService.getParise(bakeCircleId);
        return new JsonBean(integer, "点赞成功");
    }

    @ApiOperation(value = "动态取消赞")
    @PostMapping("/pariseRollBack.do")
    public JsonBean pariseRollBack(@ApiParam(value = "动态的id") Integer bakeCircleId) {
        Integer integer = userService.pariseRollBack(bakeCircleId);
        return new JsonBean(integer, "取消成功");
    }

    @ApiOperation(value = "发表烘焙圈信息", notes = "发表烘焙圈信息")
    @PostMapping("/addBakeCircle.do")
    public JsonBean addBakeCircle(@ApiParam(value = "烘焙圈动态的文字")String description, Integer topicId, MultipartFile file, String token) {
        if (file.isEmpty()) {
            return new JsonBean(0, "请选择文件");
        }
        String originalFilename = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString().replace("-", "");
        String filePath = "/usr/local/tomcat/webapps/bakecircle/";
        File dest = new File(filePath + fileName + originalFilename);
        try {
            file.transferTo(dest);
            BakeCircle bakeCircle = new BakeCircle();
            bakeCircle.setDescription(description);
            bakeCircle.setTopicId(topicId);
            bakeCircle.setCommentNum(0);
            bakeCircle.setResources("http://47.240.68.134:8889/bakecircle/" + fileName + originalFilename);
            bakeCircleService.insert(bakeCircle, token);
            return new JsonBean(1, "上传成功");
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new JsonBean(0, "上传失败");
    }

    @ApiOperation(value = "查看我的问答")
    @PostMapping("/findMyQuestions.do")
    public JsonBean<Question> findMyQuestions(String token) {
        List<Question> list = userService.findMyQuestions(token);
        return new JsonBean(1, list);
    }

    @ApiOperation(value = "给当前回答点赞")
    @PostMapping("/answerGetPraise.do")
    public JsonBean answerGetPraise(@ApiParam(value = "这条回答的id") Integer aId) {
        Integer integer = userService.addAnswerPraiseNum(aId);
        return new JsonBean(integer, "点赞成功");
    }


    @ApiOperation(value = "当前回答取消赞")
    @PostMapping("/answerLosePraise.do")
    public JsonBean answerLosePraise(@ApiParam(value = "这条回答的id") Integer aId) {
        Integer integer = userService.answerPraiseNumRollBack(aId);
        return new JsonBean(integer, "取消成功");
    }

    @ApiOperation(value = "提出问题",notes = "qContent(问题内容)和token要传，rId(食谱的id)和图片可以不传")
    @PostMapping("/addQuestion.do")
    public JsonBean addQuestion(Question question, @RequestParam(required = false) MultipartFile file, String token){
        Integer integer = userService.addQuestion(question, file, token);
        return new JsonBean(integer,"成功");
    }

    @ApiOperation(value = "回答问题")
    @PostMapping("/addAnswer.do")
    public JsonBean addAnswer(String token,@ApiParam(value = "回答的内容")String aContent,@ApiParam(value = "回答问题的id") Integer qId){
        Integer integer = userService.addAnswer(token, aContent, qId);
        return new JsonBean(integer,"回答成功");
    }

    @ApiOperation(value = "删除我的问题(会一并删除该问题的所有回答)")
    @PostMapping("/deleteQuestion.do")
    public JsonBean deleteQuestion(String token,Integer qId){
        userService.deleteQuestion(token,qId);
        return new JsonBean(1,"删除成功");
    }

    @ApiOperation(value = "删除我收藏的课程",notes = "json格式传token,键名token,和要删除的视频id的集合，键名videosId")
    @PostMapping("/deleteCollectVideos.do")
    public JsonBean deleteCollectVideos(@RequestBody Map<String, Object> map){
        String token = (String) map.get("token");
        List<Integer> videosId = (List) map.get("videosId");
        userService.deleteCollectVideos(token,videosId);
        return new JsonBean(1,"删除成功");
    }

    @ApiOperation(value = "收藏视频")
    @PostMapping("/addCollectVideo.do")
    public JsonBean addCollectVideo(String token,Integer videoId){
        userService.addCollectVideos(token,videoId);
        return new JsonBean(1,"收藏成功");
    }


    @ApiOperation(value = "收藏食谱")
    @PostMapping("/addCollectRecipe.do")
    public JsonBean addCollectRecipe(String token,Integer collectId,Integer recipeId){
        userService.addCollectRecipe(token, collectId, recipeId);
        return new JsonBean(1,"收藏成功");
    }

    @ApiOperation(value = "删除我收藏的食谱",notes = "map中需要token,collectId食单id,recipeIds食谱id的list集合")
    @PostMapping("/deleteCollectRecipes.do")
    public JsonBean deleteCollectRecipes(@RequestBody Map<String,Object> map){
        userService.deleteCollectRecipes(map);
        return new JsonBean(1,"删除成功");
    }


    @ApiOperation(value = "添加或修改我的地址",notes = "添加无需传uid")
    @PostMapping("/addOrUpdateAddress.do")
    public JsonBean addOrUpdateAddress(String token,Address address){
        String info = userService.addOrUpdateAddress(token, address);
        return new JsonBean(1,info);
    }



}
