package com.example.shivam.whatshere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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
    TextView tx;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectedmap);
        Intent intent=getIntent();
        String lat1=intent.getStringExtra("lat");
        String lng1=intent.getStringExtra("lng");

        tx=(TextView)findViewById(R.id.map_heading);
        tx.setText(lat1+" "+lng1);

        final LatLng HAMBURG1;
        Double lat=Double.parseDouble(lat1);
        Double lng=Double.parseDouble(lng1);

        HAMBURG1 = new LatLng(lat, lng);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        Marker hamburg = map.addMarker(new MarkerOptions().position(HAMBURG1).title("Hamburg"));

        // Move the camera instantly to hamburg with a zoom of 20.
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(HAMBURG1,20));

        // Zoom in, animating the camera.
        //map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        map.animateCamera(CameraUpdateFactory.zoomTo(13), 2000, null);

    }
}
