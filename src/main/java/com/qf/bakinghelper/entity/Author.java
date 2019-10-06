package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

@ApiModel(value = "作者")
@Data
public class Author {
    @ApiModelProperty(value = "作者id")
    private Integer authorId;
    @ApiModelProperty(value = "作者名字")
    private String authorName;
    @ApiModelProperty(value = "作者描述")
    private String authorDescription;
    @ApiModelProperty(value = "作者头像")
    private String authorImg;

    @ApiModelProperty(value = "对应导师的所有视频")
    private List<Video> videos;

    public Author() {
    }

    public Author(Integer authorId, String authorName, String authorDescription, String authorImg, List<Video> videos) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorDescription = authorDescription;
        this.authorImg = authorImg;
        this.videos = videos;
    }
}