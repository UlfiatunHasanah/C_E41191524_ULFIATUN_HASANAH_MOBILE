package com.example.jsonmoviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Movie;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetailMovie extends AppCompatActivity {

    ImageView imageViewBackdrop;
    TextView textViewJdl, textViewRate, textViewTglRilis, textViewOverview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imageViewBackdrop = findViewById(R.id.imageViewBackdrop);
        textViewJdl = findViewById(R.id.textViewJdlDetail);
        textViewOverview = findViewById(R.id.textViewOverviewDetail);
        textViewRate = findViewById(R.id.textViewRateDetail);
        textViewTglRilis = findViewById(R.id.textViewTglRilisDetail);

        Movie movie = getIntent().getParcelableExtra(MainActivity.EXTRA_DETAIL_MOVIE);
        textViewJdl.setText(movie.getTitle());
        Glide.with(this)
                .load(movie.getBackdrop())
                .into(imageViewBackdrop);
        textViewTglRilis.setText(movie.getTgl_rilis());
        textViewRate.setText(movie.getRate());
        textViewOverview.setText(movie.getOverview());
    }
}