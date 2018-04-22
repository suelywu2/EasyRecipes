package com.example.aluno.easyrecipe.Model;


import java.util.ArrayList;
import java.util.List;

public class RecipeBuilder {

    private String title;
    private String yield;
    private String time;
    private ArrayList<String> ingredients;
    private ArrayList<String> steps;

    public RecipeBuilder() {
        this.steps = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }


    public void title(String title) {
        this.title = title;
    }

    public void yield(String yield) {
        this.yield = yield;
    }

    public void time(String time) {
        this.time = time;
    }

    public void ingredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public void step(String aStep) {
        steps.add(aStep);
    }

    public Recipe build() {
        Recipe recipe = new Recipe(title);
        recipe.setIngredients(ingredients);
        recipe.setYield(yield);
        recipe.setTime(time);
        recipe.setSteps(steps);
        return recipe;
    }

}
