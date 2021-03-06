package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "食品类型(蛋糕,甜品点心,面包,中式甜点,面包)")
@Data
public class Type {
    @ApiModelProperty(value = "食品类型id")
    private Integer typeId;
    @ApiModelProperty(value = "食品类型")
    private String typeName;
    @ApiModelProperty(value = "每种食品对应的视频")
    private List<Video> video;

    public Type() {
    }

    public Type(Integer typeId, String typeName, List<Video> video) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.video = video;
    }
}