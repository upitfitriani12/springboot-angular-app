package com.upit.service;

import com.upit.model.Recipe;
import com.upit.model.User;

import java.util.List;

public interface RecipeService {

    public Recipe createRecipe(Recipe recipe, User user);
    public Recipe findRecipeById(long id) throws Exception;
    public void deleteRecipe(long id) throws Exception;
    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception;
    public List<Recipe> findAllRecipes();
    public Recipe likeRecipe(long recipeId, User user) throws Exception;

}
