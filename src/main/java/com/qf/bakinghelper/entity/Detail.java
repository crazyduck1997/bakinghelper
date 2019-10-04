package com.qf.bakinghelper.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class Detail {
    private Integer dId;
    private String detailName;
    private Integer tId;

    @ApiModelProperty(value = "根据具体的食品类型查询所有的食品")
    public List<FootType> footTypes;


    public Detail() {
    }

    public Detail(Integer dId, String detailName, Integer tId) {
        this.dId = dId;
        this.detailName = detailName;
        this.tId = tId;
    }
}
