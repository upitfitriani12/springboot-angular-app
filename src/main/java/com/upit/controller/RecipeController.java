package com.upit.controller;

import com.upit.model.Recipe;
import com.upit.model.User;
import com.upit.service.RecipeService;
import com.upit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final UserService userService;

    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe,
                               @RequestHeader ("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);
        Recipe createdRecipe = recipeService.createRecipe(recipe, user);
        return createdRecipe;
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe,
                               @PathVariable Long id) throws Exception {
        Recipe updatedRecipe = recipeService.updateRecipe(recipe, id);
        return updatedRecipe;
    }

    @GetMapping()
    public List<Recipe> getAllRecipe() throws Exception {
        List<Recipe> recipes = recipeService.findAllRecipes();
        return recipes;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {
        recipeService.deleteRecipe(recipeId);
        return "recipe deleted successfully";
    }

    @PutMapping("/{id}/like")
    public Recipe likeRecipe(@RequestHeader ("Authorization") String jwt,
                             @PathVariable Long id) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Recipe updatedRecipe = recipeService.likeRecipe(id, user);
        return updatedRecipe;
    }
}
