package com.example.shivam.whatshere;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public class GPSTracker extends Service implements LocationListener {

    private final Context mcontext ;
    Boolean isGPSenabled=false;
    Boolean isNetworkEnabled =false;
    Boolean canGetLocation= false;
    Location location;
    Double lat;
    Double lng;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10 ; // min distance for refreshing
    private static final long MIN_TIME_BETWEEN_UPDATES = 1000*60*1;  // 1 MIN
    protected LocationManager locationmanager ;

    public  GPSTracker(Context context){                //Constructor
        this.mcontext=context;
        getLocation();
    }

    public Location getLocation(){
        try{
            locationmanager=(LocationManager)mcontext.getSystemService(LOCATION_SERVICE);
            isGPSenabled=locationmanager.isProviderEnabled(LocationManager.GPS_PROVIDER) ; // to get gps status
            isNetworkEnabled=locationmanager.isProviderEnabled(LocationManager.NETWORK_PROVIDER); // to get network status

            if(!isGPSenabled && !isNetworkEnabled){
                // do nothing
            }
            else{
                this.canGetLocation=true;

                if(isNetworkEnabled){
                    locationmanager.requestLocationUpdates(locationmanager.NETWORK_PROVIDER, MIN_TIME_BETWEEN_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("netwrok","network");
                    if(locationmanager!=null){
                        location=locationmanager.getLastKnownLocation(locationmanager.NETWORK_PROVIDER);

                        if(location!=null){
                            lat=location.getLatitude();
                            lng=location.getLongitude();
                        }
                    }
                }

                if(isGPSenabled){

                    if(location==null){
                        locationmanager.requestLocationUpdates(locationmanager.GPS_PROVIDER, MIN_TIME_BETWEEN_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                        Log.d("GPSenabled","GPSenabled");
                        if(locationmanager!=null){
                            location=locationmanager.getLastKnownLocation(locationmanager.GPS_PROVIDER);

                            if(location!=null){
                                lat=location.getLatitude();
                                lng=location.getLongitude();
                            }
                        }

                    }

                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return location;
    }

    public void stopUsingGPS(){
        if(locationmanager!=null){
            locationmanager.removeUpdates(GPSTracker.this);
        }
    }

    public double getLatitude(){
        if(location!=null){
            lat=location.getLatitude();
        }
        return lat;
    }

    public double getLongitude(){
        if(location!=null){
            lng=location.getLongitude();
        }
        return lng;
    }

    public boolean canGetLocation(){                          //this fnctn is to check status of data and gps

        return this.canGetLocation;

    }

    public void showSettingsAlert(){
        AlertDialog.Builder alert=new AlertDialog.Builder(mcontext);
        alert.setTitle("GPS Settings");
        alert.setMessage("GPS is not enabled .  Do u want to go to setti ngs ?? ");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mcontext.startActivity(intent);
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();
            }
        });

        alert.show();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLocationChanged(Location arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderDisabled(String arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        // TODO Auto-generated method stub

    }

}
