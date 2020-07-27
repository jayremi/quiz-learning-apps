package com.example.janct;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AnimationActivity extends AppCompatActivity {
    Handler handler1;
    Runnable runnable1;
    ImageView img1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        img1 = findViewById(R.id.img1);
        img1.animate().alpha(4000).setDuration(0);

        handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(AnimationActivity.this,LoginActivity.class);
                startActivity(dsp);
                finish();
            }
        },4000);
    }
}
