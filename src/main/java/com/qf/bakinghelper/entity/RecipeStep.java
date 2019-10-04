package com.qf.bakinghelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeStep {

    private Integer stepId;
    private String step;
    private Integer rId;

}
