package com.ocean.restapicallretrofit.comments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ocean.restapicallretrofit.databinding.CustomCommentsListviewItemsBinding;
import com.ocean.restapicallretrofit.interfaces.OnItemClickListener;

import java.util.List;

public class CommentsRecyclerViewAdapter extends RecyclerView.Adapter<CommentsRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<CommentsResponse> commentsDataModelList;
    private OnItemClickListener listner;

    public CommentsRecyclerViewAdapter(Context context, List<CommentsResponse> commentsDataModelList, OnItemClickListener listner) {
        this.context = context;
        this.commentsDataModelList = commentsDataModelList;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        CustomTodoListBinding customTodoListBinding = CustomTodoListBinding.inflate(LayoutInflater.from(context), parent, false);
//        return new ViewHolder(customTodoListBinding);
        CustomCommentsListviewItemsBinding commentsListviewItemsBinding = CustomCommentsListviewItemsBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(commentsListviewItemsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CommentsResponse commentData = commentsDataModelList.get(position);
        holder.itemsBinding.tvNameComment.setText(commentData.getName());
        holder.itemsBinding.tvBodyComment.setText(commentData.getBody());
        holder.itemsBinding.tvEmailComment.setText(commentData.getEmail());

        listner.onItemClick(commentsDataModelList, position);

    }

    @Override
    public int getItemCount() {
        return commentsDataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CustomCommentsListviewItemsBinding itemsBinding;
        public ViewHolder(@NonNull CustomCommentsListviewItemsBinding itemView) {
            super(itemView.getRoot());
            itemsBinding = itemView;
        }
    }
}
