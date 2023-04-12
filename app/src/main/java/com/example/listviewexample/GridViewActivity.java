package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridView = findViewById(R.id.gridView);

        String names[] = {"Ram", "Shyam", "Hari", "Neha", "Nischal", "Adam"};
        String emails[] = {"asd@gmail.com", "asd@gmail.com", "asd@gmail.com", "asd@gmail.com", "asd@gmail.com", "asd@gmail.com"};

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nameTextView, names);

        MyGridAdapter myGridAdapter = new MyGridAdapter(this, names, emails);

        gridView.setAdapter(myGridAdapter);
    }
}