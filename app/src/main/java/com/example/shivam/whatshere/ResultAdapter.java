package com.example.shivam.whatshere;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivam on 3/1/2015.
 */
public class ResultAdapter extends ArrayAdapter<ResultData> {
    Context context;

    public ResultAdapter(Context context, int resourceId,
                         List<ResultData> items) {
        super(context, resourceId, items);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ResultData user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.resultrow, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.name_result);
        TextView tvDistance = (TextView) convertView.findViewById(R.id.distance_result);
        TextView tvPhone = (TextView) convertView.findViewById(R.id.phone_result);
        // Populate the data into the template view using the data object
        tvName.setText(user.getName());

        tvDistance.setText(user.getDistance());
        tvPhone.setText(user.getAddress());

        // Return the completed view to render on screen
        return convertView;
    }

}

