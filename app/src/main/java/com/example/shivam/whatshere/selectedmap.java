package com.example.shivam.whatshere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by Shivam on 3/3/2015.
 */
public class selectedmap extends ActionBarActivity {
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectedmap);

        Intent intent=getIntent();
        String lat=intent.getStringExtra("lat");
        String lng=intent.getStringExtra("lng");

        tx=(TextView)findViewById(R.id.map_heading);
        tx.setText(lat+" "+lng);

    }
}
