package com.ocean.restapicallretrofit.interfaces;

import com.ocean.restapicallretrofit.comments.CommentsResponse;

import java.util.List;

public interface OnItemClickListener {

    void onItemClick(List<CommentsResponse> todoListModelList, int position);
}
