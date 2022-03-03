package com.ocean.restapicallretrofit.albums;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.ocean.restapicallretrofit.RetrofitApi;
import com.ocean.restapicallretrofit.databinding.ActivityAlbumsBinding;
import com.ocean.restapicallretrofit.interfaces.ApiName;
import com.ocean.restapicallretrofit.posts.ActivityPost;
import com.ocean.restapicallretrofit.posts.ListAdapter;
import com.ocean.restapicallretrofit.posts.PostResposnse;
import com.ocean.restapicallretrofit.utility.Utility;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {

    ActivityAlbumsBinding albumsBinding;
    ProgressDialog progressDialog;
    AlbumListAdapter albumListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        albumsBinding = ActivityAlbumsBinding.inflate(getLayoutInflater());
        setContentView(albumsBinding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<AlbumsResponse>> call = apiName.getAlbumsData();
        call.enqueue(new Callback<List<AlbumsResponse>>() {
            @Override
            public void onResponse(Call<List<AlbumsResponse>> call, Response<List<AlbumsResponse>> response) {
                if (response.isSuccessful() && response.code() == 200){
                    List<AlbumsResponse> albumsResponses = response.body();
                    for (AlbumsResponse albumData : albumsResponses){
                        progressDialog.hide();
                        albumListAdapter = new AlbumListAdapter(albumsResponses, getApplicationContext());
                        albumsBinding.albumsListView.setAdapter(albumListAdapter);

                        //Log.d("DATA:", albumData.getUserId()+"\n"+albumData.getUserId()+"\n"+albumData.getTittle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<AlbumsResponse>> call, Throwable t) {
                progressDialog.hide();
                Utility.showLongToast(AlbumsActivity.this, t.getMessage());
            }
        });

    }
}