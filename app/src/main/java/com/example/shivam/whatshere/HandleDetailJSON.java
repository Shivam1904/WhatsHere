package com.example.shivam.whatshere;

import android.annotation.SuppressLint;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HandleDetailJSON {

	String country ,  address , phone  , min , max , winds , urlin , temp , name ;
    Double lat,lng;
    public ArrayList<String> placeidArray;
    public volatile boolean parsingComplete = true;

	public HandleDetailJSON(String url){                             //const
		this.urlin = url;
	}


	public void fetchJSON(){

		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					URL url = new URL(urlin);
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					conn.setReadTimeout(10000 /* milliseconds */);
					conn.setConnectTimeout(15000 /* milliseconds */);
					conn.setRequestMethod("GET");
					conn.setDoInput(true);
					// Starts the query
					conn.connect();
					InputStream stream = conn.getInputStream();

					String data = convertStreamToString(stream);

					readAndParseJSON(data);
					stream.close();

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

	        JSONObject jsonresult  = json.getJSONObject("result");
            name = jsonresult.getString("name");
            address = jsonresult.getString("formatted_address");

            if(!jsonresult.isNull("formatted_phone_number")){
                phone = jsonresult.getString("formatted_phone_number").replaceAll("\\s+","");

            }
            else {
                phone = "";
            }

            JSONObject location = jsonresult.getJSONObject("geometry").getJSONObject("location");
            //JSONObject location = geometry.getJSONObject("location");

            lat=location.getDouble("lat");
            lng=location.getDouble("lng");

			parsingComplete = false;



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


    static String convertStreamToString(InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}


	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public Double getLat(){
        return lat;
	}public Double getLng(){
        return lng;
	}public String getPhone(){
        return phone;
	}

}



