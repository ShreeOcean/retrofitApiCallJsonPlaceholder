package com.ocean.restapicallretrofit.users;

import com.google.gson.annotations.SerializedName;

public class AddressPojo {

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipCode;

    @SerializedName("geo")
    private GeoPojo geoData;

    public AddressPojo(String street, String suite, String city, String zipCode, GeoPojo geoData) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipCode = zipCode;
        this.geoData = geoData;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public GeoPojo getGeoData() {
        return geoData;
    }

    public void setGeoData(GeoPojo geoData) {
        this.geoData = geoData;
    }
}
