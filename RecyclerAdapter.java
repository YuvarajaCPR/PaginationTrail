package com.example.kathir.paginationtrail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Kathir on 3/9/18 on 2:46 PM.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    public LayoutInflater inflater;
    List<String> data = new ArrayList<>();
//dsafdfsdgdfsgdfsg
    public RecyclerAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view = inflater.inflate(R.layout.item, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {

        holder.valueText.setText(" "+data.get(position)+" ");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView valueText;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            valueText = (TextView) itemView.findViewById(R.id.value);
        }
    }
}
