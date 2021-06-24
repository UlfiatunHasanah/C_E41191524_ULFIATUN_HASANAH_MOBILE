package com.example.jsonmoviedb;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Movie;
import android.preference.PreferenceActivity;
import android.util.Log;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyAsyncTaskLoader extends AsyncTaskLoader<ArrayList<Movie>> {
    private ArrayList<Movie> arrayListMovie;
    private boolean hasResult = false;
    private String judulMovie;

    public MyAsyncTaskLoader(final Context context, String judulMovie) {
        super(context);
        onContentChanged();
        this.judulMovie = judulMovie;
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (hasResult){
            onReleaseResources(arrayListMovie);
            arrayListMovie = null;
            hasResult = false;
        }
    }

    protected void onReleaseResources(ArrayList<Movie> data){
        //nothing to do
    }

    @Override
    public void deliverResult(final ArrayList<Movie> data) {
        arrayListMovie = data;
        hasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
        else if (hasResult)
            deliverResult(arrayListMovie);
    }

    private static final String API_KEY = "0ebc67d9aa839883736d606e4c673213";
    @Nullable
    @Override
    public ArrayList<Movie> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();
        final ArrayList<Movie> moviesItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/search/movie?api_key="+API_KEY+"&language=en-US&query="+judulMovie;
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                setUseSynchronousMode(true);
            }

            @Override
            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonMovie = jsonArray.getJSONObject(i);
                        Movie movie = new Movie(jsonMovie);
                        moviesItems.add(movie);
                        Log.d("TESTMOVIE", "json masuk");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, PreferenceActivity.Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        return moviesItems;
    }
}
