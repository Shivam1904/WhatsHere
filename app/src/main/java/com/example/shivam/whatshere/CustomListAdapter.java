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
        dataList.add(new SampleData(R.drawable.ic_launcher ," atm "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," bakery "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," bank "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," bar "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," cafe "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," casino "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," church "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," dentist "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," doctor "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," electrician "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," embassy "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," gym "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," hospital "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," laundry "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," mosque "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," museum "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," park "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," parking "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," police "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," restaurant "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," school "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," spa "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," stadium "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," university "));
        dataList.add(new SampleData(R.drawable.ic_launcher ," zoo "));


    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public SampleData getItem(int position) {
        return dataList.get(position);
    }

    public String getvalue(int position){
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
        tv1.setText(data.getName().toUpperCase());
        ImageView img=(ImageView)view.findViewById(R.id.img_list);
        img.setImageResource(data.getId());
        return view;
    }
}
