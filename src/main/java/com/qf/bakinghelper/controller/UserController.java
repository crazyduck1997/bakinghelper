package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.*;
import com.qf.bakinghelper.service.BakeCircleService;
import com.qf.bakinghelper.service.CommentService;
import com.qf.bakinghelper.service.UserService;
import com.qf.bakinghelper.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Api(value = "用户")
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
    public JsonBean add(Comment comment,String token){
        commentService.insert(comment,token);
        return new JsonBean(1,"评论成功");
    }


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

    @ApiOperation(value = "修改密码,验证验证码")
    @PostMapping("/updatePwd.do")
    public JsonBean updatePwd(String code,String password,String token){
        Integer i = userService.updatePwd(code, password, token);
        return new JsonBean(i,"重置成功");
    }

    @ApiOperation(value = "修改头像")
    @PostMapping("/updateHeadImg.do")
    public JsonBean updateHeadImg(MultipartFile file, String token){
        Integer i = userService.updateHeadImg(file, token);
        return new JsonBean(i,"上传成功");
    }

    @ApiOperation(value = "查看我收藏的食单")
    @PostMapping("/findMyFoodOrder.do")
    public JsonBean findMyFoodOrder(String token){
        List<CollectFoodOrder> list = userService.findMyFoodOrder(token);
        return new JsonBean(1,list);
    }

    @ApiOperation(value = "查看收藏的食单中的食谱")
    @PostMapping("/findRecipeByCid.do")
    public JsonBean findRecipeByCid(@ApiParam(value = "当前食单的id") Integer cid){
        List<Recipe> list = userService.findRecipesByCid(cid);
        return new JsonBean(1,list);
    }

    @ApiOperation(value = "新建食单")
    @PostMapping("/addFoodOrder.do")
    public JsonBean addFoodOrder(CollectFoodOrder collectFoodOrder,String token){
        userService.addFoodOrder(collectFoodOrder,token);
        return new JsonBean(1,"success");
    }

    @ApiOperation(value = "查看我收藏的所有课程")
    @PostMapping("/findAllCollectVideos.do")
    public JsonBean findAllCollectVideos(String token){
        List<Video> list = userService.findCollectVideos(token);
        return new JsonBean(1,list);
    }

    @ApiOperation(value = "查看单个收藏课程的详细信息")
    @PostMapping("/findOneCollectVideo.do")
    public JsonBean findOneCollectVideo(Integer videoId){
        Video video = videoService.findOneVideoMessageByVideoId(videoId);
        return new JsonBean(1,video);
    }

    @ApiOperation(value = "查看我的勋章")
    @PostMapping("/findMyMedals.do")
    public JsonBean<List<Medal>> findMyMedals(String token){
        System.out.println(token);
        List<Medal> list = userService.findMyMedals(token);
        return new JsonBean<>(1,list);
    }

    @ApiOperation(value = "给动态点赞")
    @PostMapping("/getParise.do")
    public JsonBean getParise(@ApiParam(value = "动态的id") Integer bakeCircleId){
        Integer integer = userService.getParise(bakeCircleId);
        return new JsonBean(integer,"点赞成功");
    }

    @ApiOperation(value = "动态取消赞")
    @PostMapping("/pariseRollBack.do")
    public JsonBean pariseRollBack(@ApiParam(value = "动态的id") Integer bakeCircleId){
        Integer integer = userService.pariseRollBack(bakeCircleId);
        return new JsonBean(integer,"取消成功");
    }

    @ApiOperation(value = "发表烘焙圈信息",notes = "发表烘焙圈信息")
    @PostMapping("/addBakeCircle.do")
    public JsonBean add(String description,Integer topicId,MultipartFile file,String token){
        if (file.isEmpty()) {
            return new JsonBean(0,"请选择文件");
        }
        String originalFilename = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String fileName = uuid.toString().replace("-","");
        String filePath = "D:\\Drivers/";
        File dest = new File(filePath + fileName + originalFilename);
        try {
            file.transferTo(dest);
            BakeCircle bakeCircle = new BakeCircle();
            bakeCircle.setDescription(description);
            bakeCircle.setTopicId(topicId);
            bakeCircle.setResources("http://47.240.68.134:8889/bakecircle/"+fileName + originalFilename);
            bakeCircleService.insert(bakeCircle,token);
            return new JsonBean(1,"上传成功");
        } catch (IOException e) {
            e.getStackTrace();
        }
        return new JsonBean(0,"上传失败");
    }



}
