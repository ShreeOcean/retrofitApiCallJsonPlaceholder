package com.ocean.restapicallretrofit.interfaces;

import com.ocean.restapicallretrofit.albums.AlbumsResponse;
import com.ocean.restapicallretrofit.comments.CommentsResponse;
import com.ocean.restapicallretrofit.photos.PhotoResponse;
import com.ocean.restapicallretrofit.posts.PostResposnse;
import com.ocean.restapicallretrofit.todos.TodoResponse;
import com.ocean.restapicallretrofit.users.UserDetailsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiName {

    @GET("/posts")
    Call<List<PostResposnse>> getPostsData();


    @GET("/comments")
    Call<List<CommentsResponse>> getCommentsData();

    @GET("/albums")
    Call<List<AlbumsResponse>> getAlbumsData();

    @GET("/photos")
    Call<List<PhotoResponse>> getPhotoData();

    @GET("/todos")
    Call<List<TodoResponse>> getTodoData();

    @GET("/users")
    Call<List<UserDetailsResponse>> getUsersData();
}
