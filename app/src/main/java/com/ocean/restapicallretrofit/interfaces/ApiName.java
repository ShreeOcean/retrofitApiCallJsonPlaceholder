package com.ocean.restapicallretrofit.interfaces;

import com.ocean.restapicallretrofit.posts.PostResposnse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiName {

    @GET("/posts")
    Call<List<PostResposnse>> getPostsData();

}
