package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonImplicit (View view){
        Intent intent = new Intent(MainActivity.this, ImpIntentApp.class);
        startActivity(intent);
    }

    public void buttonExplicit (View view){
        Intent intent = new Intent(MainActivity.this, ExpIntentApp.class);
        startActivity(intent);
    }

}