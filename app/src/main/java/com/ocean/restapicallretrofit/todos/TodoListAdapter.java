package com.ocean.restapicallretrofit.todos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ocean.restapicallretrofit.R;

import java.util.List;

public class TodoListAdapter extends BaseAdapter {

    private List<TodoResponse> list;
    private Context context;

    public TodoListAdapter(List<TodoResponse> list, Context context) {
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

        view = LayoutInflater.from(context).inflate(R.layout.custom_todo_listview, viewGroup, false);
        TextView tv_todoTitle = view.findViewById(R.id.tv_todo_title);
        TextView tv_complete = view.findViewById(R.id.tv_complete);

        TodoResponse todoData = list.get(i);
        tv_todoTitle.setText(todoData.getTitle());

        if (todoData.isCompleted() == true){
            tv_complete.setText("Completed");
        }else if(todoData.isCompleted() == false){
            tv_complete.setText("Not done yet.");
        }

        return view;
    }
}
