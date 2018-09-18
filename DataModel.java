package com.example.kathir.paginationtrail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created By Kathir on 4/9/18 on 3:13 PM.
 */
public class DataModel {

    String tmpData;
    public static List<String> data = new ArrayList<>();


    public DataModel(List<String> data) {
        this.data = data;
    }

    public static List<String> createString(int itemCount) {
        List<String> movies = new ArrayList<>();
        System.out.println("check 1 - data size in data model = "+data.size());
        /*for (int i = 0; i < 10; i++) {
            String tmp = data.get(itemCount+i);
            System.out.println("check 1 - data @dataModel = "+data.get(itemCount+i));
            movies.add(tmp);
        }*/
        //commit by ulaga
        return movies;
    }

}
