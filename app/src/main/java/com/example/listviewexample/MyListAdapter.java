package com.example.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {
    Activity context;
    ArrayList<MyDataModel> myDataModels;

    public MyListAdapter(Activity context, String title[], ArrayList<MyDataModel> myDataModels) {
        super(context, R.layout.custom_list, title);
        this.context = context;
        this.myDataModels = myDataModels;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list, null, true);

        TextView titleTextView = rowView.findViewById(R.id.nameTv);
        TextView descTextView = rowView.findViewById(R.id.emailTv);
        titleTextView.setText(myDataModels.get(position).getTitle());
        descTextView.setText(myDataModels.get(position).getDesc());

        return rowView;
    }
}
