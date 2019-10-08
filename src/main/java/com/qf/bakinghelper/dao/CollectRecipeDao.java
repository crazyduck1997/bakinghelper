package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.CollectRecipe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectRecipeDao {


    public void insertCollectRecipe(CollectRecipe collectRecipe);


    public void deleteCollectRecipes(@Param(value = "collectId") Integer collectId, @Param(value = "list") List<Integer> recipeIds);


}
