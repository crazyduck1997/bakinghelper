package com.qf.bakinghelper.entity;


import lombok.Data;

@Data
public class FoodType {

    private Integer foodId;
    private String typeName;
    private Integer dId;
    private String foodImg;

    public FoodType() {
    }

    public FoodType(Integer foodId, String typeName, Integer dId) {
        this.foodId = foodId;
        this.typeName = typeName;
        this.dId = dId;
        this.foodImg= foodImg;
    }
}
