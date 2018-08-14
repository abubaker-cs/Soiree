package uk.co.beevorwhite.soiree.Utils;

import android.net.Uri;

import uk.co.beevorwhite.soiree.model.Keys;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static uk.co.beevorwhite.soiree.model.Keys.API_KEY;
import static uk.co.beevorwhite.soiree.model.Keys.SEARCH_QUERY;
import static uk.co.beevorwhite.soiree.model.Keys.SEARCH_RECIPE_ID;

public class NetworkUtils {

    public static URL queryUrl(String query) {

        String combinedUri = Keys.BASE_URL + API_KEY + SEARCH_QUERY + query;
        Uri builtUri = Uri.parse(combinedUri).buildUpon().build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static URL resultUrl(String recipeId) {

        String combinedUri = Keys.RECIPE_URL + API_KEY + SEARCH_RECIPE_ID + recipeId;
        Uri builtUri = Uri.parse(combinedUri).buildUpon().build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {

            InputStream inputStream = urlConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}