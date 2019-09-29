package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@ApiModel(value = "用户浏览记录中间表")
@Data
public class Browse {


    private Integer browseId;

    private Integer userId;

    private Integer videoId;

}