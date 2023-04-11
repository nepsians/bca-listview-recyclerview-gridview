package com.example.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] title;
    String[] description;

    public MyListAdapter(Activity context, String[] title, String[] description) {
        super(context, R.layout.custom_list, title);
        this.context = context;
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list, null, true);

        TextView titleTextView = rowView.findViewById(R.id.title);
        TextView descTextView = rowView.findViewById(R.id.description);
        titleTextView.setText(title[position]);
        descTextView.setText(description[position]);

        return rowView;
    }
}
