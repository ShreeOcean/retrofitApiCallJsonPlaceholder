package com.ocean.restapicallretrofit.interfaces;

import com.ocean.restapicallretrofit.comments.CommentsResponse;
import com.ocean.restapicallretrofit.posts.PostResposnse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiName {

    @GET("/posts")
    Call<List<PostResposnse>> getPostsData();


    @POST("/comments")
    Call<List<CommentsResponse>> getCommentsData();
}
