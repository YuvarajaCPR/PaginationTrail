package com.example.kathir.paginationtrail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created By Kathir on 4/9/18 on 2:48 PM.
 */
class MovieVH extends RecyclerView.ViewHolder {

    public TextView textView;

    public MovieVH(View itemView) {
        super(itemView);
        //comment line
        //push to github
        //after push
        textView = (TextView) itemView.findViewById(R.id.value);
    }
}
