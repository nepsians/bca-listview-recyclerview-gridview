package com.example.listviewexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyGridAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] names;
    String[] emails;

    public MyGridAdapter(@NonNull Activity context, String[] names, String[] emails) {
        super(context, R.layout.custom_list, names);

        this.context = context;
        this.names = names;
        this.emails = emails;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_list, null, true);

        TextView nameTextView = rowView.findViewById(R.id.nameTv);
        TextView emailTextView = rowView.findViewById(R.id.emailTv);

        nameTextView.setText(names[position]);
        emailTextView.setText(emails[position]);

        return rowView;
    }
}
