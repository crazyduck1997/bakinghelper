package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.Comment;
import com.qf.bakinghelper.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/comment")
@Api("评论")
@CrossOrigin
@RestController
public class CommentController {


    @Autowired
    CommentService commentService;

    @PostMapping("/add")
    @ApiOperation("添加评论(把content,bakeCircleId和token传来即可)")
    public JsonBean add(Comment comment,String token){
        commentService.insert(comment,token);
        return new JsonBean(1,"评论成功");
    }
}
