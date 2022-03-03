package com.ocean.restapicallretrofit.todos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.ocean.restapicallretrofit.RetrofitApi;
import com.ocean.restapicallretrofit.databinding.ActivityTodoBinding;
import com.ocean.restapicallretrofit.interfaces.ApiName;
import com.ocean.restapicallretrofit.posts.ActivityPost;
import com.ocean.restapicallretrofit.posts.ListAdapter;
import com.ocean.restapicallretrofit.posts.PostResposnse;
import com.ocean.restapicallretrofit.utility.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoActivity extends AppCompatActivity {

    ActivityTodoBinding todoBinding;
    TodoResponse todoResponse;
    ProgressDialog progressDialog;
    TodoListAdapter todoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        todoBinding = ActivityTodoBinding.inflate(getLayoutInflater());
        setContentView(todoBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<TodoResponse>> call = apiName.getTodoData();
        call.enqueue(new Callback<List<TodoResponse>>() {
            @Override
            public void onResponse(Call<List<TodoResponse>> call, Response<List<TodoResponse>> response) {
                if (response.isSuccessful() && response.code() == 200){
                    List<TodoResponse> todoResponses = response.body();
                    for (TodoResponse todoData : todoResponses){
                        progressDialog.hide();
                        todoListAdapter = new TodoListAdapter(todoResponses, getApplicationContext());
                        todoBinding.listViewTodo.setAdapter(todoListAdapter);

                        Log.d("DATA:", todoData.getUserId()+"\n"+todoData.getId()+"\n"+todoData.getTitle()+"\n"+todoData.isCompleted());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<TodoResponse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(TodoActivity.this, t.getMessage());
            }
        });

    }
}