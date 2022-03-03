package com.ocean.restapicallretrofit.photos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ocean.restapicallretrofit.R;

import java.util.List;

public class PhotoListAdapter extends BaseAdapter {

    private List<PhotoResponse> list;
    private Context context;

    public PhotoListAdapter(List<PhotoResponse> list, Context context) {
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

        view = LayoutInflater.from(context).inflate(R.layout.custom_photo_listview, viewGroup, false);
        TextView tv_title = view.findViewById(R.id.tv_photo_title);
        ImageView imageView_photo = view.findViewById(R.id.imageView_photo);

        PhotoResponse photoData = list.get(i);
        tv_title.setText(photoData.getTitle());
        imageView_photo.setImageURI(photoData.getUrl());
        return view;
    }
}
