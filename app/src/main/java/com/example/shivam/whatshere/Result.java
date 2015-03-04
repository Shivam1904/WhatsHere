package com.example.shivam.whatshere;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Result extends ActionBarActivity {
    ListView listView;
    ArrayList<ResultData> rowItems;
    HandleJSON obj;
    String full;
    HandleDetailJSON objnext;

    int percentage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultlist);
        Intent intent = getIntent();
        String option = intent.getStringExtra("option").trim();
        String lat = (intent.getStringExtra("lat")).trim();
        String lng = (intent.getStringExtra("lng")).trim();


        full = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location=" + lat + "," + lng + "&radius=1000&rankby=distance&types=" + option + "&key=AIzaSyDmFaoSg0lkAFcd-fR7rUXLHeDs4iv8XOA";
        Log.d("x", full);
        new getJSON().execute();

//        final ResultAdapter resultadapter= new ResultAdapter(this,getTaskId(),rowItems);


    }



    class getJSON extends AsyncTask<String,String,ArrayList<ResultData>> {

        private ProgressDialog pDialog = new ProgressDialog(Result.this);;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            pDialog.setMessage("Please be patient... We are looking for your query");
           // pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pDialog.setIndeterminate(true);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected ArrayList<ResultData> doInBackground(String... args) {
            obj = new HandleJSON(full);
            obj.fetchJSON();
            while (obj.parsingComplete) ;
            rowItems = new ArrayList<ResultData>();

            int sizearray= obj.placeidArray.size();
            for (int i = 0; i <sizearray; i++) {
                objnext = new HandleDetailJSON((obj.placeidArray).get(i));
                objnext = new HandleDetailJSON("https://maps.googleapis.com/maps/api/place/details/json?placeid=" + (obj.placeidArray).get(i) + "&key=AIzaSyDmFaoSg0lkAFcd-fR7rUXLHeDs4iv8XOA");
                objnext.fetchJSON();
                while (objnext.parsingComplete) ;
                Log.e("x",String.valueOf(objnext.getLat()));
                ResultData item = new ResultData(objnext.getName(), objnext.getPhone(), objnext.getAddress(), R.drawable.ic_launcher, objnext.getLat(), objnext.getLng());
                rowItems.add(item);
                Log.e("d",String.valueOf(i));
                percentage=(i/sizearray)*100;
         //       pDialog.setMessage("Please be patient... We are looking for your query ("+String.valueOf(percentage)+" %)");
            }



                return rowItems;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(ArrayList<ResultData> rowtem) {
            pDialog.dismiss() ;
            final ArrayList<ResultData> rowi=rowtem;
            try {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        listView = (ListView) findViewById(R.id.resultlist1);
                        final ResultAdapter adapter = new ResultAdapter(Result.this,
                                R.layout.resultrow, rowi);
                        listView.setAdapter(adapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String lat=String.valueOf(adapter.getLat(position));
                                String lng=String.valueOf(adapter.getLng(position));
                                // String lng=String.valueOf(objnext.getLng());
                                Log.e("dd",lat+lng);
                                Intent in=new Intent(Result.this,selectedmap.class);
                                in.putExtra("lat",lat);
                                in.putExtra("lng",lng);
                                startActivity(in);
                            }
                        });

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}








