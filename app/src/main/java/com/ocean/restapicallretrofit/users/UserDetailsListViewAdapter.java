package com.ocean.restapicallretrofit.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ocean.restapicallretrofit.R;

import java.util.List;

public class UserDetailsListViewAdapter extends BaseAdapter {

    private List<UserDetailsResponse> list;
    private Context context;

    public UserDetailsListViewAdapter(List<UserDetailsResponse> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView tvUserName,tvUsersUserName,tvUserEmail,tvUserAddress,tvUserLocation,tvUserPhone,tvUserWebsite,tvUserCompany;
        view = LayoutInflater.from(context).inflate(R.layout.custom_user_listview, viewGroup, false);

        tvUserName = view.findViewById(R.id.tv_userdetails_name);
        tvUsersUserName = view.findViewById(R.id.tv_userdetails_username);
        tvUserEmail = view.findViewById(R.id.tv_userdetails_email);
        tvUserAddress = view.findViewById(R.id.tv_userdetails_address);
        tvUserLocation = view.findViewById(R.id.tv_userdetails_location);
        tvUserPhone = view.findViewById(R.id.tv_userdetails_phone);
        tvUserWebsite = view.findViewById(R.id.tv_userdetails_website);
        tvUserCompany = view.findViewById(R.id.tv_userdetails_company);

        UserDetailsResponse userData = list.get(i);
        tvUserName.setText(userData.getName());
        tvUsersUserName.setText(userData.getUserName());
        tvUserEmail.setText(userData.getEmail());
        tvUserAddress.setText("Street :"+userData.getAddressData().getStreet()+
                                "\n Suite: "+ userData.getAddressData().getSuite()+
                                "\n City : " + userData.getAddressData().getCity()+
                                "\n Zipcode : " + userData.getAddressData().getZipCode());
        tvUserLocation.setText("Latitude : "+userData.getAddressData().getGeoData().getLatitude()+
                                "\n Longitude : " + userData.getAddressData().getGeoData().getLongitude());
        tvUserPhone.setText(userData.getPhone());
        tvUserWebsite.setText(userData.getWebSite());
        tvUserWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tvUserCompany.setText("Company Name : "+userData.getCompanyData().getCompanyName()+
                                "\n CatchPhrase : " + userData.getCompanyData().getCatchPhrase()+
                                "\n BS : " + userData.getCompanyData().getBs());
        return view;
    }
}
