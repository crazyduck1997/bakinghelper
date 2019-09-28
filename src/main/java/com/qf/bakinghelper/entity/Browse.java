package com.qf.bakinghelper.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
@ApiModel(value = "中间表，关联uid和gid")
@Data
public class Browse {


    private Integer browseId;

    private Integer uId;

    private Integer gId;

}