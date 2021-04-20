package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity_Second extends AppCompatActivity {

    TextView txtHello;
    private String nama;
    private String KEY_NAME = "NAMA" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__second);
        txtHello = (TextView) findViewById(R.id.txtHello);
        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        txtHello.setText("Hello,"+ nama + "!");
    }
}