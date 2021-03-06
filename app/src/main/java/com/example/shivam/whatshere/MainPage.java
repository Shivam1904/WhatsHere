package com.example.shivam.whatshere;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainPage extends ActionBarActivity {
    ListView listview;
    public ArrayList<String> newlist;
    GPSTracker gpsin;
    public Double lat,lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        final CustomListAdapter adapter = new CustomListAdapter(getLayoutInflater());


        listview = (ListView) findViewById(R.id.optionlist);
        listview.setAdapter((android.widget.ListAdapter) adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gpsin = new GPSTracker(MainPage.this);
                if (gpsin.canGetLocation()) {
                    Double lt,ln;
                    lat = gpsin.getLatitude();
                    lng = gpsin.getLongitude();
                    lt=lat;
                    ln=lng;
                }


                String optionSelected = adapter.getvalue(position);
                Intent in = new Intent(MainPage.this,Result.class);
                in.putExtra("option", optionSelected);
                in.putExtra("lat", String.valueOf(lat));
                in.putExtra("lng", String.valueOf(lng));
//                Toast.makeText(getApplicationContext(), optionSelected, Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainPage.this, "Your Current latitude is " + lat + " and your longitude is " + lng, Toast.LENGTH_LONG).show();Toast.makeText(MainPage.this, "Your Current latitude is " + lat + " and your longitude is " + lng, Toast.LENGTH_LONG).show();
                startActivity(in);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
