package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "技巧内容(基础技巧,工具材料,进阶干货,精选专题)")
@Data
public class TechTitle {

    @ApiModelProperty("基础技巧,工具材料,进阶干货,精选专题id")
    private Integer techId;
    @ApiModelProperty(value = "基础技巧,工具材料,进阶干货,精选专题属性名称")
    private String techName;
    @ApiModelProperty(value = "基础技巧,工具材料,进阶干货,精选专题简介标题")
    private String content;
    @ApiModelProperty(value = "基础技巧,工具材料,进阶干货,精选专题简介内容")
    private String introduce;
    @ApiModelProperty(value = "基础技巧,工具材料,进阶干货,精选专题视频链接")
    private String videoHref;
    @ApiModelProperty(value = "基础技巧,工具材料,进阶干货,精选专题图片链接")
    private String imgHref;


    public TechTitle() {
    }

    public TechTitle(Integer techId, String techName, String content, String introduce, String videoHref, String imgHref) {
        this.techId = techId;
        this.techName = techName;
        this.content = content;
        this.introduce = introduce;
        this.videoHref = videoHref;
        this.imgHref = imgHref;
    }
}
