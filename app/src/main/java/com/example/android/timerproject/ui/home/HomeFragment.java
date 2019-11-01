package com.example.android.timerproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


import com.example.android.timerproject.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FloatingActionButton fab;
    RecyclerView recyclerView;

    List<Timer> timers = new ArrayList<Timer>();

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

        //FAB
        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), timerCreator.class);
                startActivity(intent);
            }
        });

        //RecyclerView
        recyclerView = (RecyclerView) root.findViewById(R.id.timerList);


        return root;
    }
}