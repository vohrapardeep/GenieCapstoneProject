package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.test.ui.Location.UserLocation;

public class Animation extends AppCompatActivity {


    android.view.animation.Animation topanim;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        topanim= AnimationUtils.loadAnimation(this,R.anim.fade_animation);
        topanim=AnimationUtils.loadAnimation(this,R.anim.fadeout);

        image=findViewById(R.id.image);

        image.setAnimation(topanim);
        image.setAnimation(topanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Animation.this, UserLocation.class);
                startActivity(intent);
                finish();
            }
        },4500);

    }
}