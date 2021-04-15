package com.example.intentku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class PindahActivity extends AppCompatActivity {

    Button buttonPindahActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pindah);

        buttonPindahActivity = findViewById(R.id.buttonPindahActivity);

        }
    }