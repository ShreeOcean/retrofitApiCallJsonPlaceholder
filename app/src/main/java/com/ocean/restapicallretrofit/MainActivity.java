package com.ocean.restapicallretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ocean.restapicallretrofit.albums.AlbumsActivity;
import com.ocean.restapicallretrofit.comments.CommentsActivity;
import com.ocean.restapicallretrofit.databinding.ActivityMainBinding;
import com.ocean.restapicallretrofit.photos.PhotoActivity;
import com.ocean.restapicallretrofit.posts.ActivityPost;
import com.ocean.restapicallretrofit.posts.PostResposnse;
import com.ocean.restapicallretrofit.todos.TodoActivity;
import com.ocean.restapicallretrofit.users.UsersDetailsActivity;

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

        mainBinding.outlinedBtnComments.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, CommentsActivity.class));
        });

        mainBinding.outlinedBtnAlbums.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, AlbumsActivity.class));
        });

        mainBinding.outlinedBtnPhotos.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, PhotoActivity.class));
        });

        mainBinding.outlinedBtnTodos.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, TodoActivity.class));
        });

        mainBinding.outlinedBtnUsers.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, UsersDetailsActivity.class));
        });
    }
}