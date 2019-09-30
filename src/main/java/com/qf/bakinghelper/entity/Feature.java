package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "视频专栏(私房网红,应季必做,元气早餐,烘焙经典,技法专栏)")
@Data
public class Feature {

    @ApiModelProperty("视频类型id")
    private Integer featureId;
    @ApiModelProperty(value = "视频类型")
    private String featureName;
    @ApiModelProperty(value = "每种专栏对应的视频")
    private List<Video> videos;

    public Feature() {
    }

    public Feature(Integer featureId, String featureName, List<Video> videos) {
        this.featureId = featureId;
        this.featureName = featureName;
        this.videos = videos;
    }
}