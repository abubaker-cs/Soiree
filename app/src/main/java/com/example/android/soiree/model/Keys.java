package com.example.android.soiree.model;

import com.example.android.soiree.BuildConfig;

public class Keys {

    public static final String BASE_URL = "http://food2fork.com/api/search?key=";
    public static final String API_KEY = BuildConfig.API_KEY;
    public static final String QUERY = "query";
    public static final String SEARCH_QUERY = "&q=";

    public static final String RECIPES = "recipes";
    public static final String RECIPE_URL = "http://food2fork.com/api/get?key=";
    public static final String SEARCH_RECIPE_ID = "&rId=";
    public static final String RECIPE_ID = "recipe_id";

    public static final String RECIPE_IMAGE = "image_url";
    public static final String METHOD_URL = "source_url";
    public static final String RECIPE_NAME = "title";
    public static final String RECIPE_RANK = "social_rank";

}
