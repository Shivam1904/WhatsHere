package com.example.shivam.whatshere;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HandleJSON {

	String country ,  humidity , pressure  , min , max , winds , urlin , temp , name ;
    public ArrayList<String> placeidArray;
    public volatile boolean parsingComplete = true;

	public HandleJSON(String url){                             //const

        this.urlin = url;
	}


	public void fetchJSON(){

		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
                    Log.e("x", "abv");
					URL url = new URL(urlin);
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                    Log.e("x","abv2");
					conn.setReadTimeout(10000 /* milliseconds */);
					conn.setConnectTimeout(15000 /* milliseconds */);
					conn.setRequestMethod("GET");
					conn.setDoInput(true);
                    Log.e("x","abv3");
					// Starts the query
					conn.connect();
                    Log.e("x","abv4");
					InputStream stream = conn.getInputStream();
                    Log.e("x","abv5");
					String data = convertStreamToString(stream);
                    Log.e("x","abv6");
					readAndParseJSON(data);
					stream.close();
                    Log.e("x","abv7");
				} catch (Exception e) {
					System.out.print("gaya");
				}
			}
		});

		thread.start(); 		
	}



	@SuppressLint("NewApi")
	public void readAndParseJSON(String in) {
		try {
			JSONObject json = new JSONObject(in);
	//      JSONObject json  = reader.getJSONObject("results");
            Log.e("x", "readandparse");
            JSONArray jsonarray=json.getJSONArray("results");
            JSONObject json_data;
            String placeid;
            int i;
            Log.e("d",String.valueOf(jsonarray.length()));
            placeidArray=new ArrayList<String>();
            for( i=0; i<jsonarray.length(); i++){
                json_data = jsonarray.getJSONObject(i);
                placeid = json_data.getString("place_id");
                Log.e("d",String.valueOf(i)+placeid);
                placeidArray.add(placeid);
            }

			parsingComplete = false;



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


    static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}


	public String getname(){
		return name;
	}

}



