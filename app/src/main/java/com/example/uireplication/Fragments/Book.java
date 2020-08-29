package com.example.uireplication.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uireplication.Adapter.ListAdapter1;
import com.example.uireplication.R;


public class Book extends Fragment {


    private RecyclerView recyclerView;
    private ListAdapter1 mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_book, container, false);


        recyclerView=(RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,true);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ListAdapter1(getActivity());
        recyclerView.setAdapter(mAdapter);

        return view;
    }
}