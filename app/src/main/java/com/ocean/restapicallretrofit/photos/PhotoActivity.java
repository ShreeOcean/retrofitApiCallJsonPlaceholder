package com.ocean.restapicallretrofit.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.ocean.restapicallretrofit.RetrofitApi;
import com.ocean.restapicallretrofit.databinding.ActivityPhotoBinding;
import com.ocean.restapicallretrofit.interfaces.ApiName;
import com.ocean.restapicallretrofit.posts.ActivityPost;
import com.ocean.restapicallretrofit.posts.ListAdapter;
import com.ocean.restapicallretrofit.posts.PostResposnse;
import com.ocean.restapicallretrofit.utility.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoActivity extends AppCompatActivity {

    ActivityPhotoBinding photoBinding;
    ProgressDialog progressDialog;
    PhotoListAdapter photoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        photoBinding = ActivityPhotoBinding.inflate(getLayoutInflater());
        setContentView(photoBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<PhotoResponse>> call = apiName.getPhotoData();
        call.enqueue(new Callback<List<PhotoResponse>>() {
            @Override
            public void onResponse(Call<List<PhotoResponse>> call, Response<List<PhotoResponse>> response) {

                    if (response.isSuccessful() && response.code() == 200){
                        List<PhotoResponse> photoResponses = response.body();
                        for (PhotoResponse photoData : photoResponses){
                            progressDialog.hide();
                            photoListAdapter = new PhotoListAdapter(photoResponses, getApplicationContext());
                            photoBinding.photoListview.setAdapter(photoListAdapter);

                            Log.d("Photo Response--->", "onResponse: " + photoData.getTitle() +" "+ photoData.getUrl());
                        }
                    }
            }

            @Override
            public void onFailure(Call<List<PhotoResponse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(PhotoActivity.this, t.getMessage());
            }
        });
    }
}