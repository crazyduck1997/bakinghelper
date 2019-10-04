package com.qf.bakinghelper.dao;

import com.qf.bakinghelper.entity.Recipe;

import java.util.List;

public interface RecipeDao {

    public List<Recipe> findAllRecipe();

}
