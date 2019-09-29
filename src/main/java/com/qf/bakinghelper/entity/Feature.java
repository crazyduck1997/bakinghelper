package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "视频专栏")
@Data
public class Feature {

    private Integer featureId;

    private String featureName;

}