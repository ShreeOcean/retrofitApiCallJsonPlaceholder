package com.ocean.restapicallretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ocean.restapicallretrofit.databinding.ActivityMainBinding;
import com.ocean.restapicallretrofit.posts.ActivityPost;
import com.ocean.restapicallretrofit.posts.PostResposnse;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.outlinedBtnPosts.setOnClickListener(view -> {
            //Intent intent = new Intent(MainActivity.this, PostResposnse.class);
            startActivity(new Intent(MainActivity.this, ActivityPost.class));
        });
    }
}