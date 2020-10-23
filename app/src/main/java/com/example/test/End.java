package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class End extends AppCompatActivity {
TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        textView2 = findViewById(R.id.textView2);
//        Intent i = getIntent();
//        String name = i.getStringExtra("name");
//        String email = i.getStringExtra("email");
//        String date = i.getStringExtra("date");
//        String number = i.getStringExtra("number");

        textView2.setText("Order Placed successfully");


    }
}
