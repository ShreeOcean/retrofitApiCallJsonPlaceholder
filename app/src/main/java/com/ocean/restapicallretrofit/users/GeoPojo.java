package com.ocean.restapicallretrofit.users;

import com.google.gson.annotations.SerializedName;

public class GeoPojo {

    @SerializedName("lat")
    private String latitude;

    @SerializedName("lng")
    private String longitude;

    public GeoPojo(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }


}
