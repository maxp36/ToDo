package com.test.maxp36.todo.adapter;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.test.maxp36.todo.ListToDo;
import com.test.maxp36.todo.R;

import java.util.ArrayList;
import java.util.List;

public class ListToDoAdapter extends ArrayAdapter<ListToDo> {

    private Context context;
    private int layoutResourceId;
    private List<ListToDo> data = null;

    public ListToDoAdapter (Context context, int layoutResourceId, ArrayList<ListToDo> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListToDoHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ListToDoHolder();
            holder.name = (TextView)row.findViewById(R.id.to_do_item_name);
            holder.date = (TextView)row.findViewById(R.id.to_do_item_date);

            row.setTag(holder);
        } else {
            holder = (ListToDoHolder)row.getTag();
        }

        ListToDo item = data.get(position);
        holder.name.setText(item.name);
        holder.date.setText(item.date);

        return row;
    }

    private static class ListToDoHolder {
        private TextView name;
        private TextView date;
    }
}
