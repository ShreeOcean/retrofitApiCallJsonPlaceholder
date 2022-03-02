package com.ocean.restapicallretrofit.users;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ocean.restapicallretrofit.databinding.ActivityUsersDetailsBinding;

public class UsersDetailsActivity extends AppCompatActivity {

    ActivityUsersDetailsBinding usersDetailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usersDetailsBinding = ActivityUsersDetailsBinding.inflate(getLayoutInflater());
        setContentView(usersDetailsBinding.getRoot());
    }
}