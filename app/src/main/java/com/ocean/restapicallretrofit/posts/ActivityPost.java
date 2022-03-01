package com.ocean.restapicallretrofit.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ocean.restapicallretrofit.R;
import com.ocean.restapicallretrofit.RetrofitApi;
import com.ocean.restapicallretrofit.databinding.ActivityMainBinding;
import com.ocean.restapicallretrofit.databinding.ActivityPostBinding;
import com.ocean.restapicallretrofit.interfaces.ApiName;
import com.ocean.restapicallretrofit.utility.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPost extends AppCompatActivity {

    ActivityPostBinding postBinding;
    ProgressDialog progressDialog;
    PostResposnse postResposnse;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        postBinding = ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(postBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<PostResposnse>> call = apiName.getPostsData();
        call.enqueue(new Callback<List<PostResposnse>>() {
            @Override
            public void onResponse(Call<List<PostResposnse>> call, Response<List<PostResposnse>> response) {
                if (response.isSuccessful() && response.code() == 200){
                    List<PostResposnse> postsResponses = response.body();
                    for (PostResposnse postData : postsResponses){

                        //listAdapter = new ListAdapter(getApplicationContext(), R.layout.custom_posts_listview_items,postsResponses);
                        postBinding.listView.setAdapter(listAdapter);

                        Log.d("DATA:", postData.getUserId()+"\n"+postData.getUserId()+"\n"+postData.getTitle()+"\n"+postData.getBody());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PostResposnse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(ActivityPost.this, t.getMessage());
            }
        });


    }
}