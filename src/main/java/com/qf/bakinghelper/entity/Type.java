package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@ApiModel(value = "视频类型")
@Data
public class Type {
    private Integer typeId;

    private String typeName;

}