package com.qf.bakinghelper.controller;

import com.qf.bakinghelper.common.JsonBean;
import com.qf.bakinghelper.entity.Comment;
import com.qf.bakinghelper.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/comment")
@Api("评论")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/list")
    @ApiOperation("列出评论信息")
    public JsonBean list(String token){
        List<Comment> comments = commentService.selectAll();
        return new JsonBean(1,comments);
    }
    @PostMapping("/add")
    @ApiOperation("添加评论")
    public JsonBean add(Comment comment){
        commentService.insert(comment);
        return new JsonBean(1,"评论成功");
    }
}
