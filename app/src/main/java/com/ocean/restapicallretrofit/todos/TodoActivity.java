package com.ocean.restapicallretrofit.todos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ocean.restapicallretrofit.databinding.ActivityTodoBinding;

public class TodoActivity extends AppCompatActivity {

    ActivityTodoBinding todoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        todoBinding = ActivityTodoBinding.inflate(getLayoutInflater());
        setContentView(todoBinding.getRoot());
    }
}