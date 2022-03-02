package com.ocean.restapicallretrofit.albums;

import com.google.gson.annotations.SerializedName;

public class AlbumsResponse {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("tittle")
    private String tittle;

    public AlbumsResponse(int userId, int id, String tittle) {
        this.userId = userId;
        this.id = id;
        this.tittle = tittle;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
}
