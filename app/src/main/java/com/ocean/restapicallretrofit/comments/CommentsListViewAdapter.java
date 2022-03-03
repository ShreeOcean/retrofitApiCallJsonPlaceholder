package com.ocean.restapicallretrofit.comments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ocean.restapicallretrofit.R;

import java.util.List;

public class CommentsListViewAdapter extends BaseAdapter {

    List<CommentsResponse> list;
    Context context;

    public CommentsListViewAdapter(List<CommentsResponse> list, Context context) {
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

        view = LayoutInflater.from(context).inflate(R.layout.custom_comments_listview_items, viewGroup, false);
        TextView tvname, tvEmail, tvBody;
        tvname = view.findViewById(R.id.tv_name_comment);
        tvEmail = view.findViewById(R.id.tv_email_comment);
        tvBody = view.findViewById(R.id.tv_body_comment);

        CommentsResponse commentData = list.get(i);

        tvname.setText("Name : "+commentData.getName());
        tvEmail.setText("Email : "+commentData.getEmail());
        tvBody.setText("Comment : "+commentData.getBody());

        return view;
    }
}
