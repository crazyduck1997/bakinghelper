package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel(value = "作者")
@Data
public class Author {
    @ApiModelProperty(value = "作者id")
    private Integer authorId;
    @ApiModelProperty(value = "作者名字")
    private String authorName;


}