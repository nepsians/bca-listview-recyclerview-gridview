package com.example.listviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        setTitle("TODO App");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText taskEt = findViewById(R.id.taskEt);
        Button saveBtn = findViewById(R.id.saveBtn);

        ArrayList<MyDataModel> tasks = new ArrayList<MyDataModel>();
        // Description is not used in this recycler view example, so leaving it empty for now.
        tasks.add(new MyDataModel("Wake up at 8am", ""));
        tasks.add(new MyDataModel("Learn java programming for 2 hour", ""));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, tasks);
        recyclerView.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                String deletedTodo = tasks.get(viewHolder.getAdapterPosition()).getTitle();
                int position = viewHolder.getAdapterPosition();
                tasks.remove(position);
                adapter.setTasks(tasks);
                Snackbar.make(recyclerView, deletedTodo, Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tasks.add(position, new MyDataModel(deletedTodo, ""));
                        adapter.setTasks(tasks);
                    }
                }).show();
            }
        }).attachToRecyclerView(recyclerView);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskValue = taskEt.getText().toString();
                if (taskValue.length() < 1) {
                    Snackbar.make(view, "Task cannot be empty.", Snackbar.LENGTH_LONG).show();
                    return;
                }

                tasks.add(new MyDataModel(taskValue, ""));

                adapter.setTasks(tasks);

                taskEt.getText().clear();

                hideKeyboard(view);
            }
        });
    }

    private void hideKeyboard(View v) {

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
    }
}