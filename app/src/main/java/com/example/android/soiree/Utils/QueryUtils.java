package com.example.android.soiree.Utils;

import android.text.TextUtils;

import com.example.android.soiree.model.Ingredient;
import com.example.android.soiree.model.RecipeDetail;
import com.example.android.soiree.model.Keys;
import com.example.android.soiree.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.android.soiree.model.Keys.METHOD_URL;
import static com.example.android.soiree.model.Keys.RECIPE_ID;
import static com.example.android.soiree.model.Keys.RECIPE_IMAGE;
import static com.example.android.soiree.model.Keys.RECIPE_NAME;
import static com.example.android.soiree.model.Keys.RECIPE_RANK;
import static com.example.android.soiree.model.Keys.SOURCE_URL;

public class QueryUtils {

    public static ArrayList<Recipe> getRecipeListFromJson(String recipesJson) {

        if (TextUtils.isEmpty(recipesJson)) {
            return null;
        }

        ArrayList<Recipe> recipesList = new ArrayList<>();

        try {

            JSONObject recipeObject = new JSONObject(recipesJson);

            JSONArray recipesArray = recipeObject.getJSONArray(Keys.RECIPES);

            for (int i = 0; i < recipesArray.length(); i++) {
                JSONObject currentRecipe = recipesArray.getJSONObject(i);

                String recipeTitle = currentRecipe.getString(RECIPE_NAME);
                String methodUrl = currentRecipe.getString(METHOD_URL);
                String recipeId = currentRecipe.getString(RECIPE_ID);
                String recipeImage = currentRecipe.getString(RECIPE_IMAGE);
                String recipeRank = currentRecipe.getString(RECIPE_RANK);

                Recipe recipe = new Recipe(recipeTitle, methodUrl, recipeId, recipeImage, recipeRank);
                recipesList.add(recipe);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipesList;
    }

    public static ArrayList<RecipeDetail> getRecipeDetailFromJson(String recipesJson) {

        if (TextUtils.isEmpty(recipesJson)) {
            return null;
        }

        ArrayList<RecipeDetail> recipeDetailList = new ArrayList<>();

        try {

            JSONObject resultsObject = new JSONObject(recipesJson);

            JSONObject recipeObject = resultsObject.getJSONObject(Keys.RECIPE);

            String recipeUrl = recipeObject.getString(SOURCE_URL);

            JSONArray ingredientsArray = recipeObject.getJSONArray(Keys.RECIPE_INGREDIENTS);

            ArrayList<Ingredient> ingredientsArrayList = new ArrayList<>();

            for (int i = 0; i < ingredientsArray.length(); i++) {

                String ingredientItem = ingredientsArray.getString(i);

                Ingredient ingredient = new Ingredient(ingredientItem);
                ingredientsArrayList.add(ingredient);

            }

            RecipeDetail recipeDetail = new RecipeDetail(ingredientsArrayList, recipeUrl);
            recipeDetailList.add(recipeDetail);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return recipeDetailList;
    }

}
