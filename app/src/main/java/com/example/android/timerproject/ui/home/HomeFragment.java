package com.example.android.timerproject.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.android.timerproject.*;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.timerproject.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import com.google.android.material.snackbar.*;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


import com.example.android.timerproject.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FloatingActionButton fab;
    RecyclerView recyclerView;

    private CustomListAdapter mAdapter;
    private ListView listView;
    private ArrayList<Timer> timers = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        listView = (ListView) root.findViewById(R.id.list_view);











        //FAB
        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), timerCreator.class), 1001);//2 is request code
            }
        });

        return root;



    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            //Intent intent2 = getActivity().getIntent();
            //Bundle bundle = intent2.getBundleExtra("bundle");

            //Timer t = (Timer) getActivity().getIntent().getSerializableExtra("object");
            Timer t = (Timer) data.getSerializableExtra("object");

            System.out.println(t.getClass().getName());

            timers.add(t);
            mAdapter = new CustomListAdapter(getActivity(), timers);
            listView.setAdapter(mAdapter);


        }
    }

}

