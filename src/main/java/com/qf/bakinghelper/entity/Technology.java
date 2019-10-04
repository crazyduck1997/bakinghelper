package com.qf.bakinghelper.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "技巧百科(基础技巧,工具材料,进阶干货,精选专题)")
@Data
public class Technology {

    @ApiModelProperty("技巧百科id")
    private Integer bakeId;
    @ApiModelProperty(value = "技巧百科属性名称")
    private String bakeName;


    public Technology() {
    }

    public Technology(Integer bakeId, String bakeName) {
        this.bakeId = bakeId;
        this.bakeName = bakeName;
    }
}
