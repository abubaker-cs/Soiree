package com.example.android.soiree.AsyncTasks;

import android.os.AsyncTask;

import com.example.android.soiree.Utils.NetworkUtils;
import com.example.android.soiree.Utils.QueryUtils;
import com.example.android.soiree.model.Ingredient;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GetIngredientsData extends AsyncTask<URL, Void, ArrayList<Ingredient>> {

    private ArrayList<Ingredient> ingredientsList;
    private IngredientsAsyncTaskListener delegate = null;

    public GetIngredientsData(IngredientsAsyncTaskListener asyncTaskListener) {
        delegate = asyncTaskListener;
    }

    @Override
    protected ArrayList<Ingredient> doInBackground(URL... urls) {

        try {

            if (urls != null) {

                URL url = urls[0];
                String query = NetworkUtils.getResponseFromHttpUrl(url);
                if (query != null) {

                    ingredientsList = QueryUtils.getRecipeDetailFromJson(query);
                    return ingredientsList;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientsList;
    }

    @Override
    protected void onPostExecute(ArrayList<Ingredient> ingredients) {
        ingredientsList = ingredients;

        if (ingredientsList != null) {
            delegate.onTaskComplete(ingredientsList);
        }
    }
}