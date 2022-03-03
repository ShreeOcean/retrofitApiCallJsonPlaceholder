package com.ocean.restapicallretrofit.users;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.ocean.restapicallretrofit.RetrofitApi;
import com.ocean.restapicallretrofit.databinding.ActivityUsersDetailsBinding;
import com.ocean.restapicallretrofit.interfaces.ApiName;
import com.ocean.restapicallretrofit.posts.ActivityPost;
import com.ocean.restapicallretrofit.posts.ListAdapter;
import com.ocean.restapicallretrofit.utility.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersDetailsActivity extends AppCompatActivity {

    ActivityUsersDetailsBinding usersDetailsBinding;
    ProgressDialog progressDialog;
    UserDetailsResponse userDetailsResponse;
    UserDetailsListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        usersDetailsBinding = ActivityUsersDetailsBinding.inflate(getLayoutInflater());
        setContentView(usersDetailsBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<UserDetailsResponse>> call = apiName.getUsersData();
        call.enqueue(new Callback<List<UserDetailsResponse>>() {
            @Override
            public void onResponse(Call<List<UserDetailsResponse>> call, Response<List<UserDetailsResponse>> response) {
                if (response.isSuccessful() && response.code() == 200){
                    List<UserDetailsResponse> userDetailsResponseList = response.body();
                    for (UserDetailsResponse detailsResponse: userDetailsResponseList){
                        progressDialog.hide();
                        listViewAdapter = new UserDetailsListViewAdapter(userDetailsResponseList,getApplicationContext());
                        usersDetailsBinding.listViewUserDetails.setAdapter(listViewAdapter);

                        Log.d("DATA:", detailsResponse.getId()+"\n"+detailsResponse.getUserName()+"\n"+detailsResponse.getName()+"\n"+detailsResponse.getEmail());

                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserDetailsResponse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(UsersDetailsActivity.this, t.getMessage());
            }
        });
    }
}