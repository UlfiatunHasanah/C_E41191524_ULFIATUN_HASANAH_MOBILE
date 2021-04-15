package com.example.intentku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ForResultActivity extends AppCompatActivity {

    TextView tvIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);

        tvIntent = findViewById(R.id.tvIntent);

        String nama = getIntent().getStringExtra("extra_name");
        int umur = getIntent().getIntExtra("extra_umur", 0);

        String text = "Nama Kampus: " +nama+ "Umurnya" +umur+ "tahun";
        tvIntent.setText(text);
    }
}