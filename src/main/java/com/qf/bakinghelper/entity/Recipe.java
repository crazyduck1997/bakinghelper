package com.qf.bakinghelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private Integer rId;
    private String rName;
    private String titleImg;
    private Integer uId;
    private String note;
    private String introduce;

    private List<RecipeImgs> recipeImgsList;

    private List<RecipeStep> recipeStepList;


}
