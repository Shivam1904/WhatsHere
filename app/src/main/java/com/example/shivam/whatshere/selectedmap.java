package com.example.shivam.whatshere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Shivam on 3/3/2015.
 */
public class selectedmap extends ActionBarActivity {
    TextView txname,txaddress;
    GoogleMap map;

    MainPage mpg=new MainPage();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectedmap);
        Intent intent=getIntent();

        String name=intent.getStringExtra("dname");
        String address=intent.getStringExtra("daddress");

        String lat1=intent.getStringExtra("dlat");
        String lng1=intent.getStringExtra("dlng");
        String lat0=intent.getStringExtra("clat");
        String lng0=intent.getStringExtra("clng");

        txname=(TextView)findViewById(R.id.map_heading);
        txaddress=(TextView)findViewById(R.id.mapaddress);
        txname.setText(name);
        txaddress.setText(address);

        final LatLng DESTINATION;
        final LatLng CURRENT;
        Double lat=Double.parseDouble(lat1);
        Double lng=Double.parseDouble(lng1);
        Double clat=Double.parseDouble(lat0);
        Double clng=Double.parseDouble(lng0);

       DESTINATION = new LatLng(lat, lng);
        Log.e("c","3");

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        Marker Destination = map.addMarker(new MarkerOptions().position(DESTINATION).title("Destination"));
        Log.e("c","4");
        CURRENT = new LatLng(clat,clng);
        Marker current = map.addMarker(new MarkerOptions().position(CURRENT).title("Your Location"));
//
        // Move the camera instantly to hamburg with a zoom of 20.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(DESTINATION,21));

        // Zoom in, animating the camera.
        //map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        map.animateCamera(CameraUpdateFactory.zoomTo(14), 2000, null);

    }
}
