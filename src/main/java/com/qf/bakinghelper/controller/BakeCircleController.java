package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.*;
import com.qf.bakinghelper.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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


@Api(value = "烘焙圈")
@CrossOrigin
@RestController
@RequestMapping("/bakecircle")
public class BakeCircleController {

    @Autowired
    BakeCircleService bakeCircleService;

    @Autowired(required = false)
    TopicService topicService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;


    @ApiOperation(value = "",notes = "列出烘焙圈动态信息")
    @PostMapping("/list.do")
    public JsonBean list(){
        List<BakeCircle> bakeCircles = bakeCircleService.selectAll();
        return new JsonBean(1,bakeCircles);
    }

    @ApiOperation("列出所有话题")
    @PostMapping("/listTopic.do")
    public JsonBean listTopic(){
        List<Topic> topics = topicService.selectAll();
        return new JsonBean(1,topics);
    }




    @ApiOperation(value = "查看单个烘焙圈动态(不包括评论)",notes = "查看单个烘焙圈动态")
    @PostMapping("/findOneCircle.do")
    public JsonBean findOneCircle(Integer circleId){
        BakeCircle bakeCircle = bakeCircleService.selectByPrimaryKey(circleId);
        return new JsonBean(1,bakeCircle);
    }
    @ApiOperation(value = "查看当前烘焙圈的所有评论",notes = "页面加载完成后执行")
    @PostMapping("/findCommentByCircleId.do")
    public JsonBean findCommentByCircleId(Integer circleId){
        List<Comment> list = commentService.selectAllByCircleId(circleId);
        return new JsonBean(1,list);
    }

    @ApiOperation(value = "通过uid查看用户信息")
    @PostMapping("/findByUserId.do")
    public JsonBean findByUserId(Integer uid){
        User user = userService.selectByPrimaryKey(uid);
        return new JsonBean(1,user);
    }




}
