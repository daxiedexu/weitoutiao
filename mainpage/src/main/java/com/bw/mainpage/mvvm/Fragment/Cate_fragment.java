package com.bw.mainpage.mvvm.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bw.mainpage.R;

public class Cate_fragment extends Fragment {


    private RecyclerView cateRv;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate=inflater.inflate(R.layout.fragment_cate_fragment, container, false);


        cateRv = (RecyclerView)inflate. findViewById(R.id.cate_rv);

        return inflate;


    }
}