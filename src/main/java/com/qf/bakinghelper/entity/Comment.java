package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "评论")
@Data
public class Comment {
    private Integer commentId;

    private Integer userId;

    private Integer bakeCircleId;

    private Date commentTime;

    private String content;

    private User user;
}