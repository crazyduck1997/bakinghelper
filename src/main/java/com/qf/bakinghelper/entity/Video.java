package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

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
    @ApiModelProperty(value = "专栏id")
    private Integer featureId;
    @ApiModelProperty(value = "对应的技巧百科类型id")
    private Integer tyId;

    //向阳
    @ApiModelProperty(value = "视频作者")
    public Author author;

    public Video() {
    }

    public Video(Integer videoId, String videoName, Integer authorId, Integer collectNum, Integer cookNum, Integer typeId, String content, String introduce, String learn, String videoHref, String imgHref, Integer featureId, Integer tyId) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.authorId = authorId;
        this.collectNum = collectNum;
        this.cookNum = cookNum;
        this.typeId = typeId;
        this.content = content;
        this.introduce = introduce;
        this.learn = learn;
        this.videoHref = videoHref;
        this.imgHref = imgHref;
        this.featureId = featureId;
        this.tyId = tyId;
    }
}