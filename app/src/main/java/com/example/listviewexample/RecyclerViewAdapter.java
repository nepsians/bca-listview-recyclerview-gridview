package com.example.listviewexample;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Activity activity;
    ArrayList<MyDataModel> tasks;

    public RecyclerViewAdapter(Activity activity, ArrayList<MyDataModel> tasks) {
        this.activity = activity;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View listItem = layoutInflater.inflate(R.layout.custom_list_task, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.taskTv.setText(tasks.get(position).getTitle());

        holder.taskIdTv.setText(position + 1 + ". ");
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(ArrayList<MyDataModel> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskIdTv, taskTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTv = itemView.findViewById(R.id.taskTv);
            taskIdTv = itemView.findViewById(R.id.taskIdTv);
        }
    }
}
