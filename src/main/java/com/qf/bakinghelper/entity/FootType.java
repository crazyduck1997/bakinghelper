package com.qf.bakinghelper.entity;


import lombok.Data;

@Data
public class FootType {

    private Integer foodId;
    private String typeName;
    private Integer dId;

    public FootType() {
    }

    public FootType(Integer foodId, String typeName, Integer dId) {
        this.foodId = foodId;
        this.typeName = typeName;
        this.dId = dId;
    }
}