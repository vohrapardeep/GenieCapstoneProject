package com.example.test.ui.Feedback;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

public class ThankYoupage extends AppCompatActivity {
TextView edMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_youpage);

        Intent intent= getIntent();
        String getname = intent.getStringExtra("name");
        edMessage = findViewById(R.id.edMessage);
        edMessage.setText("Thank you for your valuable feedback ," + getname);

    }
}