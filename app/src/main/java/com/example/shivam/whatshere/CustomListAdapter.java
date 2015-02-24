package com.example.shivam.whatshere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class CustomListAdapter extends BaseAdapter {
    /** The inflator used to inflate the XML layout */
    public LayoutInflater inflator;

    /** A list containing some sample data to show. */
    public ArrayList<SampleData> dataList;

    public CustomListAdapter(LayoutInflater inflator){
        super();
        this.inflator=inflator;

        dataList=new ArrayList<SampleData>();
        dataList.add(new SampleData(R.drawable.ic_launcher ,"Apple"));
        dataList.add(new SampleData(R.drawable.ic_launcher ,"Blackberry"));
        dataList.add(new SampleData(R.drawable.ic_launcher ,"Android"));
        dataList.add(new SampleData(R.drawable.ic_launcher ,"Windows"));
        dataList.add(new SampleData(R.drawable.ic_launcher ,"Ubuntu"));
        dataList.add(new SampleData(R.drawable.ic_launcher ,"RedHat"));

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public SampleData getItem(int position) {
        return dataList.get(position);
    }

    public String xyz(int position){
        SampleData data =  getItem(position);
        return data.getName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override

    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = inflator.inflate(R.layout.choicerow, null);
        }

        SampleData data =  getItem(position);
        TextView tv1 = (TextView) view.findViewById(R.id.img_name);
        tv1.setText(data.getName());
        ImageView img=(ImageView)view.findViewById(R.id.img_list);
        img.setImageResource(data.getId());
        return view;
    }
}
