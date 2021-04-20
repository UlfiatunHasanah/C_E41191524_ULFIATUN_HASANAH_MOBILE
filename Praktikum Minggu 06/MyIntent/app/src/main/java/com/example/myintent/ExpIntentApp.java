package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExpIntentApp extends AppCompatActivity {
    EditText name;
    Button btnSend;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_intent_app);
        EditText name = (EditText) findViewById(R.id.editNama);
        Button btnSend = (Button) findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String nama = name.getText().toString();
                    if (nama != "") {
                        Intent i = new Intent(ExpIntentApp.this, Activity_Second.class);
                        i.putExtra(KEY_NAME, nama);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplication(),  "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT);

                    }
                } catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN",Toast.LENGTH_SHORT);
                }

            }
        });

    }
}