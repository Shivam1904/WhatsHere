package com.example.shivam.whatshere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivam on 3/1/2015.
 */
public class Result extends ActionBarActivity {
    ListView listView;
    ArrayList<ResultData> rowItems;
    HandleJSON obj;
    HandleDetailJSON objnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlist);
        Intent intent =getIntent();
        String option = intent.getStringExtra("option").trim();
        String lat = (intent.getStringExtra("lat")).trim();
        String lng = (intent.getStringExtra("lng")).trim();
        Log.e("x",option);
        Log.e("x",lat);
        Log.e("x",lng);
      //String full="https://maps.googleapis.com/maps/api/place/radarsearch/json?location=%2025.2820,%2082.9563&radius=5000&types=bar&key=AIzaSyDmFaoSg0lkAFcd-fR7rUXLHeDs4iv8XOA";
//        String full="https://maps.googleapis.com/maps/api/place/radarsearch/json?location=%2025.2820,%2082.9563&radius=5000&types="+option+"&key=AIzaSyDmFaoSg0lkAFcd-fR7rUXLHeDs4iv8XOA";
        String full="https://maps.googleapis.com/maps/api/place/radarsearch/json?location="+lat+","+lng+"&radius=1000&types="+option+"&key=AIzaSyDmFaoSg0lkAFcd-fR7rUXLHeDs4iv8XOA";
        Log.d("x",full);
        obj = new HandleJSON(full);
        obj.fetchJSON();
        while (obj.parsingComplete) ;
        rowItems = new ArrayList<ResultData>();

        for (int i = 0; i < obj.placeidArray.size(); i++) {
            objnext=new HandleDetailJSON((obj.placeidArray).get(i));
            objnext=new HandleDetailJSON("https://maps.googleapis.com/maps/api/place/details/json?placeid="+(obj.placeidArray).get(i)+"&key=AIzaSyDmFaoSg0lkAFcd-fR7rUXLHeDs4iv8XOA");
            objnext.fetchJSON();
            while(objnext.parsingComplete);
            ResultData item = new ResultData(objnext.getName(), objnext.getPhone(), objnext.getAddress(), R.drawable.ic_launcher);
            rowItems.add(item);
        }



//        for (int i = 0; i < obj.placeidArray.size(); i++) {
//            String str = String.valueOf(i);
//            ResultData item = new ResultData((obj.placeidArray).get(i), "shivam", "sri", R.drawable.ic_launcher);
//            rowItems.add(item);
//        }

        listView = (ListView) findViewById(R.id.resultlist1);
        ResultAdapter adapter = new ResultAdapter(this,
                R.layout.resultrow, rowItems);
        listView.setAdapter(adapter);
   }

    }

