package com.example.kathir.paginationtrail;


import android.graphics.Movie;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    PaginationAdapter adapter;

    List<String> data1 = new ArrayList<>();
    List<String> data2 = new ArrayList<>();
    RecyclerAdapter recyclerAdapter;

    Button button1;
    Button button2;

    RecyclerView recyclerView;
    ProgressBar progressBar;

    private static final int PAGE_START = 0;
    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int TOTAL_PAGES = 10;
    private int currentPage = PAGE_START;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.main_progress);

        setData();
        setData();
        setData();
        setData();


        System.out.println("Check 1 - data1 size = "+data1.size());

        adapter = new PaginationAdapter(this,data1);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(MainActivity.this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new PaginationScrollListener(layoutManager) {

            @Override
            protected void loadMoreItems() {
                System.out.println("check 1 - loadMoreItems called");
                isLoading = true;
                currentPage += 1;

                // mocking network delay for API call
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadNextPage();
                    }
                }, 1000);
            }

            @Override
            public int getTotalPageCount() {
                System.out.println("check 1 - getTotalPageCount called");
                return TOTAL_PAGES;
            }

            @Override
            public boolean isLastPage() {
                System.out.println("check 1 - isLastPage called");
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                System.out.println("check 1 - isLoading called");
                return isLoading;
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadFirstPage();
            }
        }, 1000);

        /*recyclerAdapter = new RecyclerAdapter(data1);
        recyclerView.setAdapter(recyclerAdapter);*/

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*recyclerAdapter = new RecyclerAdapter(data1);
                recyclerView.setAdapter(recyclerAdapter);*/
                adapter = new PaginationAdapter(MainActivity.this,data1);
                recyclerView.setAdapter(adapter);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*recyclerAdapter = new RecyclerAdapter(data2);
                recyclerView.setAdapter(recyclerAdapter);*/

                adapter = new PaginationAdapter(MainActivity.this,data2);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    public void setData() {

        data1.add("Tablet");
        data1.add("Ointment");
        data1.add("Powder");
        data1.add("Respules");
        data1.add("Sachet");
        data1.add("Capsule");
        data1.add("Drops");
        data1.add("Legium");
        data1.add("Oil Bottle");
        data1.add("Syrupicon");
        data1.add("Suture");
        data1.add("Container");
        data1.add("Syringe");
        data1.add("Gloves");
        data1.add("Banded");
        data1.add("Venflon");
        data1.add("Saline Tube");
        data1.add("Lotion");
        data1.add("Inhaler");
        data1.add("Solution");
        data1.add("Chendrum");
        data1.add("Injuction");
        data1.add("Suppository");
        data1.add("Infusion");
        data1.add("Tablet");
        data1.add("Ointment");
        data1.add("Powder");
        data1.add("Respules");
        data1.add("Sachet");
        data1.add("Capsule");
        data1.add("Drops");
        data1.add("Legium");
        data1.add("Oil Bottle");
        data1.add("Syrupicon");
        data1.add("Suture");
        data1.add("Container");
        data1.add("Syringe");
        data1.add("Gloves");
        data1.add("Banded");
        data1.add("Venflon");
        data1.add("Saline Tube");
        data1.add("Lotion");
        data1.add("Inhaler");
        data1.add("Solution");
        data1.add("Chendrum");
        data1.add("Injuction");
        data1.add("Suppository");
        data1.add("Infusion");
        data1.add("Tablet");
        data1.add("Ointment");
        data1.add("Powder");
        data1.add("Respules");
        data1.add("Sachet");
        data1.add("Capsule");
        data1.add("Drops");
        data1.add("Legium");
        data1.add("Oil Bottle");
        data1.add("Syrupicon");
        data1.add("Suture");
        data1.add("Container");
        data1.add("Syringe");
        data1.add("Gloves");
        data1.add("Banded");
        data1.add("Venflon");
        data1.add("Saline Tube");
        data1.add("Lotion");
        data1.add("Inhaler");
        data1.add("Solution");
        data1.add("Chendrum");
        data1.add("Injuction");
        data1.add("Suppository");
        data1.add("Infusion");
        data1.add("Tablet");
        data1.add("Ointment");
        data1.add("Powder");
        data1.add("Respules");
        data1.add("Sachet");
        data1.add("Capsule");
        data1.add("Drops");
        data1.add("Legium");
        data1.add("Oil Bottle");
        data1.add("Syrupicon");
        data1.add("Suture");
        data1.add("Container");
        data1.add("Syringe");
        data1.add("Gloves");
        data1.add("Banded");
        data1.add("Venflon");
        data1.add("Saline Tube");
        data1.add("Lotion");
        data1.add("Inhaler");
        data1.add("Solution");
        data1.add("Chendrum");
        data1.add("Injuction");
        data1.add("Suppository");
        data1.add("Infusion");
        data1.add("Tablet");
        data1.add("Ointment");
        data1.add("Powder");
        data1.add("Respules");
        data1.add("Sachet");
        data1.add("Capsule");
        data1.add("Drops");
        data1.add("Legium");
        data1.add("Oil Bottle");
        data1.add("Syrupicon");
        data1.add("Suture");
        data1.add("Container");
        data1.add("Syringe");
        data1.add("Gloves");
        data1.add("Banded");
        data1.add("Venflon");
        data1.add("Saline Tube");
        data1.add("Lotion");
        data1.add("Inhaler");
        data1.add("Solution");
        data1.add("Chendrum");
        data1.add("Injuction");
        data1.add("Suppository");
        data1.add("Infusion");
        data1.add("Tablet");
        data1.add("Ointment");
        data1.add("Powder");
        data1.add("Respules");
        data1.add("Sachet");
        data1.add("Capsule");
        data1.add("Drops");
        data1.add("Legium");
        data1.add("Oil Bottle");
        data1.add("Syrupicon");
        data1.add("Suture");
        data1.add("Container");
        data1.add("Syringe");
        data1.add("Gloves");
        data1.add("Banded");
        data1.add("Venflon");
        data1.add("Saline Tube");
        data1.add("Lotion");
        data1.add("Inhaler");
        data1.add("Solution");
        data1.add("Chendrum");
        data1.add("Injuction");
        data1.add("Suppository");
        data1.add("Infusion");

        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");
        data2.add("data2");


    }

    private void loadFirstPage() {
        System.out.println("check 1 - "+"loadFirstPage: ");
        DataModel dataModel = new DataModel(data1);
        List<String> movies = DataModel.createString(adapter.getItemCount());
        progressBar.setVisibility(View.GONE);
        adapter.addAll(movies);

        if (currentPage <= TOTAL_PAGES) adapter.addLoadingFooter();
        else isLastPage = true;

    }

    private void loadNextPage() {
        System.out.println("check 1 - "+"loadNextPage: " + currentPage+"adapter.getCount = "+adapter.getItemCount());
        DataModel dataModel = new DataModel(data1);
        List<String> movies = dataModel.createString(adapter.getItemCount());

        adapter.removeLoadingFooter();
        isLoading = false;

        adapter.addAll(movies);

        if (currentPage != TOTAL_PAGES) adapter.addLoadingFooter();
        else isLastPage = true;
    }
}
