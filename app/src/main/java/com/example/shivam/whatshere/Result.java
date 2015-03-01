package com.example.shivam.whatshere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivam on 3/1/2015.
 */
public class Result extends ActionBarActivity {
    ListView listView;
    ArrayList<ResultData> rowItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlist);
 //       Intent intent=getIntent();
//        String option=intent.getStringExtra("option");
//        Double lat =Double.valueOf(intent.getStringExtra("lat"));
//        Double lng=Double.valueOf(intent.getStringExtra("lng"));

        rowItems = new ArrayList<ResultData>();
        for (int i = 0; i < 5; i++) {
            String str=String.valueOf(i);
            ResultData item = new ResultData(str, str, str, R.drawable.ic_launcher);
            rowItems.add(item);
        }
        listView = (ListView) findViewById(R.id.resultlist1);
        ResultAdapter adapter = new ResultAdapter(this,
                R.layout.resultrow, rowItems);
        listView.setAdapter(adapter);




    }
}
