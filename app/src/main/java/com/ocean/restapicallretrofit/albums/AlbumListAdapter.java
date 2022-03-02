package com.ocean.restapicallretrofit.albums;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ocean.restapicallretrofit.R;
import com.ocean.restapicallretrofit.posts.PostResposnse;

import java.util.List;

public class AlbumListAdapter extends BaseAdapter {

    private List<AlbumsResponse> list;
    private Context context;

    public AlbumListAdapter(List<AlbumsResponse> list, Context context) {
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

        view = LayoutInflater.from(context).inflate(R.layout.album_custom_listview, viewGroup,false);
        TextView tvTittle = view.findViewById(R.id.tv_album_tittle);

        AlbumsResponse albumData = list.get(i);
        tvTittle.setText(albumData.getTittle());
        return view;
    }
}
