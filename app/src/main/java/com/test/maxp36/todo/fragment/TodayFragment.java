package com.test.maxp36.todo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.maxp36.todo.R;

public class TodayFragment extends Fragment {

    public static final int LAYOUT = R.layout.today_fragment_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getChildFragmentManager().beginTransaction()
                .replace(R.id.overdue, new OverdueListFragment())
                .replace(R.id.today, new TodayListFragment())
                .commit();

        return inflater.inflate(LAYOUT, container, false);
    }
}
