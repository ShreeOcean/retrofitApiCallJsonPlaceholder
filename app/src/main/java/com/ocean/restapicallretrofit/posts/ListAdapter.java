package com.ocean.restapicallretrofit.posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ocean.restapicallretrofit.R;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private List<PostResposnse> list;
    private Context context;

    public ListAdapter(List<PostResposnse> list, Context context) {
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

        view = LayoutInflater.from(context).inflate(R.layout.custom_posts_listview_items, viewGroup,false);

        TextView tvTittle = view.findViewById(R.id.tv_tittle);
        TextView tvBody = view.findViewById(R.id.tv_body);

        PostResposnse data = list.get(i);

        tvTittle.setText("Title : "+data.getTitle());
        tvBody.setText("Post Body : "+data.getBody());
        return view;
    }
}
