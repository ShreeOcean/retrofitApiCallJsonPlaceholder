package com.ocean.restapicallretrofit.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ocean.restapicallretrofit.databinding.ActivityPhotoBinding;

public class PhotoActivity extends AppCompatActivity {

    ActivityPhotoBinding photoBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photoBinding = ActivityPhotoBinding.inflate(getLayoutInflater());
        setContentView(photoBinding.getRoot());
    }
}