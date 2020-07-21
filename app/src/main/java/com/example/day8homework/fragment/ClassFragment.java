package com.example.day8homework.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.day8homework.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassFragment extends Fragment {


    private TextView tv_class;

    public ClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_class, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tv_class = view.findViewById(R.id.tv_class);
        tv_class.setText("课程");
    }

}
