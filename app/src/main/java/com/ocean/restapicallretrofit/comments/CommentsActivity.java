package com.ocean.restapicallretrofit.comments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.ocean.restapicallretrofit.R;
import com.ocean.restapicallretrofit.RetrofitApi;
import com.ocean.restapicallretrofit.databinding.ActivityCommentsBinding;
import com.ocean.restapicallretrofit.databinding.CustomCommentsListviewItemsBinding;
import com.ocean.restapicallretrofit.interfaces.ApiName;
import com.ocean.restapicallretrofit.utility.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {

    ActivityCommentsBinding commentsBinding;
    ProgressDialog progressDialog;
    CommentsRecyclerViewAdapter recyclerViewAdapter;
    CustomCommentsListviewItemsBinding commentsListviewItemsBinding;
    List<CommentsResponse> commentsResponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        commentsBinding = ActivityCommentsBinding.inflate(getLayoutInflater());
        setContentView(commentsBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        commentsBinding.recyclerViewCommentsActivity.setLayoutManager(linearLayoutManager);
        //recyclerViewAdapter = new CommentsRecyclerViewAdapter(commentsResponses, getApplicationContext());
        commentsBinding.recyclerViewCommentsActivity.setAdapter(recyclerViewAdapter);

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<CommentsResponse>> call = apiName.getCommentsData();
        call.enqueue(new Callback<List<CommentsResponse>>() {
            @Override
            public void onResponse(Call<List<CommentsResponse>> call, Response<List<CommentsResponse>> response) {
                if(response.isSuccessful() && response.code() == 200){
                    commentsResponses = response.body();
                    for (CommentsResponse commentData : commentsResponses){
                        progressDialog.hide();
//                        recyclerViewAdapter = new CommentsRecyclerViewAdapter();
//                        commentsBinding.recyclerViewCommentsActivity.setAdapter(recyclerViewAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CommentsResponse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(CommentsActivity.this, t.getMessage());
            }
        });

    }
}