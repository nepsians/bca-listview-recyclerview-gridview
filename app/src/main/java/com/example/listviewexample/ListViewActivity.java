package com.example.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = findViewById(R.id.listView);

        // Uncomment this block of code for testing listview with displaying name as a list, make sure to comment below block of code 27 -> 32
//        String names[] = {"Ram", "Shyam", "Hari", "Sita", "Gita", "Rita"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.nameTextView, names);
//        listView.setAdapter(adapter);
        String title[] = {"Item 1", "Item 2", "Item 3", "Item 4"};
        String desc[] = {"This is description 1", "This is description 2", "This is description 3", "This is description 4", "This is description 5", "This is description 6", "This is description 7", "This is description 8", "This is description 9", "This is description 10", "This is description 11", "This is description 12"};


        ArrayList<MyDataModel> myDataModels = new ArrayList<MyDataModel>();
        myDataModels.add(new MyDataModel("Item 1", "This is description 1"));
        myDataModels.add(new MyDataModel("Item 2", "This is description 2"));
        myDataModels.add(new MyDataModel("Item 3", "This is description 3"));
        myDataModels.add(new MyDataModel("Item 4", "This is description 4"));

        MyListAdapter myListAdapter = new MyListAdapter(this, title, myDataModels);

        listView.setAdapter(myListAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
//                String selectedName = myListAdapter.getItem(index);
//
//                Snackbar.make(view, selectedName, Snackbar.LENGTH_LONG).show();
//            }
//        });
    }
}