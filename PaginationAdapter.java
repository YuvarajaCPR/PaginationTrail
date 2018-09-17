package com.example.kathir.paginationtrail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Kathir on 4/9/18 on 2:35 PM.
 */
public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    List<String> data = new ArrayList<>();
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private Context context;

    public PaginationAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    private boolean isLoadingAdded = false;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                View v2 = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingVH(v2);
                break;
        }
        return viewHolder;

    }

    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {

        RecyclerView.ViewHolder viewHolder;
        View v1 = inflater.inflate(R.layout.item, parent, false);
        viewHolder = new MovieVH(v1);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        String tmpData = data.get(position);

        switch (getItemViewType(position)) {
            case ITEM:
                MovieVH movieVH = (MovieVH) holder;

                movieVH.textView.setText("   "+tmpData+"   ");
                break;
            case LOADING:
//                Do nothing
                break;
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == data.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }


    public void add(String mc) {
        data.add(mc);
        notifyItemInserted(data.size() - 1);
    }

    public void addAll(List<String> mcList) {
        for (String mc : mcList) {
            add(mc);
        }
    }

    public void remove(String city) {
        int position = data.indexOf(city);
        if (position > -1) {
            data.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) remove(data.get(0));
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new String());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = data.size() - 1;
        String item = getItem(position);

        if (item != null) {
            data.remove(position);
            notifyItemRemoved(position);
        }
    }

    public String getItem(int position) {
        return data.get(position);
    }

}
