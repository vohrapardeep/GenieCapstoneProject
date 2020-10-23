package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class One extends AppCompatActivity {

    TextView txtviewTitle,txtviewPrice;
    ImageView img1;
    Button btnCheckout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        txtviewTitle = findViewById(R.id.txtviewTitle);
        txtviewPrice = findViewById(R.id.txtviewPrice);
        img1 = findViewById(R.id.img1);
        btnCheckout = findViewById(R.id.btnCheckout);

        //getting Intent to get passed data
        Bundle bundle = getIntent().getExtras();
        String title=bundle.getString("title1");
        int img= bundle.getInt("img1");
        String price = bundle.getString("price1");

        //Passing values received to respective resources
        txtviewTitle.setText(title);
        img1.setImageResource(img);
        txtviewPrice.setText("$"+ price);

        //checkout button click listener
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Checkout.class);
                startActivity(i);
            }
        });
    }
}
