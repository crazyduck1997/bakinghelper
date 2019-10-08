package com.qf.bakinghelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectRecipe {

    private Integer id;
    private Integer collectId;
    private Integer recipeId;


}
