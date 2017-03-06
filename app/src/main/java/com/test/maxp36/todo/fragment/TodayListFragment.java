package com.test.maxp36.todo.fragment;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.test.maxp36.todo.ListToDo;
import com.test.maxp36.todo.R;
import com.test.maxp36.todo.adapter.ListToDoAdapter;
import com.test.maxp36.todo.sqlite.MySQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TodayListFragment extends ListFragment {

    private SQLiteDatabase db;
    private Cursor cursor;
    //private ArrayList<ListToDo> listToDo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View header = createHeader("Today", savedInstanceState);
        getListView().addHeaderView(header);

        //new MySQLiteOpenHelper(getContext());

        initListToDo();

        /*ListToDo listToDo[] = new ListToDo[]
                {
                        new ListToDo("First Item"),
                        new ListToDo("Second Item")
                };*/

        //ListToDoAdapter adapter = new ListToDoAdapter(getActivity(), R.layout.list_fragment_item , listToDo);



        //setListAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        cursor.close();
        db.close();
    }

    private void initListToDo() {
        //listToDo = new ArrayList<>();

        try {

            SQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());
            db = mySQLiteOpenHelper.getReadableDatabase();
            cursor = db.query("TODO_ITEMS",
                    new String[]{"_id", "NAME", "DATE", "PRIORITY", "MARK"},
                    "DATE = ?",
                    new String[]{new SimpleDateFormat("dd.MM.yyyy").format(new Date())},
                    null, null, null);

            CursorAdapter cursorAdapter = new SimpleCursorAdapter(getContext(),
                    R.layout.list_fragment_item,
                    cursor,
                    new String[]{"NAME", "DATE"},
                    new int[]{R.id.to_do_item_name, R.id.to_do_item_date},
                    0);

            setListAdapter(cursorAdapter);

            //cursor.close();
            //db.close();

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }

        //addToDo("Second Item");
    }

    public void addToDo(String name) {
        //listToDo.add(new ListToDo(name));

        try {

            SQLiteOpenHelper mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());
            db = mySQLiteOpenHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("NAME", name);
            cv.put("DATE", new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
            db.insert("TODO_ITEMS", null, cv);

            db.close();

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(getActivity(), "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    private View createHeader(String name, @Nullable Bundle savedInstanceState) {
        View v = getLayoutInflater(savedInstanceState).inflate(R.layout.header_list_view, null);
        ((TextView)v.findViewById(R.id.name_day)).setText(name);
        return v;
    }
}
