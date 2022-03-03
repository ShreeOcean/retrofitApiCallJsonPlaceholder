package com.ocean.restapicallretrofit.users;

import com.google.gson.annotations.SerializedName;

public class UserDetailsResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("username")
    private String userName;

    @SerializedName("email")
    private String email;

    @SerializedName("phone")
    private String phone;

    @SerializedName("website")
    private String webSite;

    @SerializedName("address")
    private AddressPojo addressData;

    @SerializedName("company")
    private CompanyPojo companyData;

    public UserDetailsResponse(int id, String name, String userName, String email, String phone, String webSite, AddressPojo addressData, CompanyPojo companyData) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.webSite = webSite;
        this.addressData = addressData;
        this.companyData = companyData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public AddressPojo getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressPojo addressData) {
        this.addressData = addressData;
    }

    public CompanyPojo getCompanyData() {
        return companyData;
    }

    public void setCompanyData(CompanyPojo companyData) {
        this.companyData = companyData;
    }
}
