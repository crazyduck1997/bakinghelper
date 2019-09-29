package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value = "视频")
@Data
public class Video {
    @ApiModelProperty(value = "视频id")
    private Integer videoId;
    @ApiModelProperty(value = "视频名称")
    private String videoName;
    @ApiModelProperty(value = "作者id")
    private Integer authorId;
    @ApiModelProperty(value = "收藏人数")
    private Integer collectNum;
    @ApiModelProperty(value = "学习人数")
    private Integer cookNum;
    @ApiModelProperty(value = "类型id")
    private Integer typeId;
    @ApiModelProperty(value = "学会内容")
    private String content;
    @ApiModelProperty(value = "课程介绍")
    private String introduce;
    @ApiModelProperty(value = "如何学习")
    private String learn;
    @ApiModelProperty(value = "视频链接")
    private String videoHref;
    @ApiModelProperty(value = "图片链接")
    private String imgHref;

    }