package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class BakeCircle {
    @ApiModelProperty(value = "动态id")
    private Integer circleId;
    @ApiModelProperty(value = "发布时间")
    private Date time;
    @ApiModelProperty(value = "动态内容")
    private String description;
    @ApiModelProperty(value = "动态资源")
    private String resources;
    @ApiModelProperty(value = "点赞")
    private String praise;
    @ApiModelProperty(value = "评论")
    private String comments;

    }