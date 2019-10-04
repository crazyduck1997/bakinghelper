package com.qf.bakinghelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectFoodOrder {

    private Integer cId;
    private String cName;
    private String cIntroduce;
    private Integer uId;



}
