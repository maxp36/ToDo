package com.test.maxp36.todo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.maxp36.todo.ListToDo;
import com.test.maxp36.todo.R;
import com.test.maxp36.todo.adapter.ListToDoAdapter;

public class MyListFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListToDo listToDo[] = new ListToDo[]
                {
                        new ListToDo("First Item"),
                        new ListToDo("Second Item")
                };

        ListToDoAdapter adapter = new ListToDoAdapter(getActivity(), R.layout.list_fragment_item , listToDo);

        setListAdapter(adapter);
    }
}
