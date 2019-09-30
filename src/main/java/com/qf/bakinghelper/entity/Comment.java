package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@ApiModel(value = "评论")
@Data
public class Comment {
    private Integer commentId;

    private Integer userId;

    private Date commentTime;

    private User user;
}