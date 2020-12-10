package com.example.test.ui.Feedback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

public class Feedback extends AppCompatActivity {

    EditText edName,edEmail,edPhone,edFeedback;
    Spinner spinner;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);
        edFeedback = findViewById(R.id.edFeedback);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edName.getText().toString();
                if(edFeedback.getText().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Feedback",Toast.LENGTH_LONG);
                }
                else{

                    Intent i = new Intent(getApplicationContext(),ThankYoupage.class);
                    i.putExtra("name",name);
                    startActivity(i);
                }
            }
        });


    }
}