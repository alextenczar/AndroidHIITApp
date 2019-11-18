package com.example.android.timerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Parcelable;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.app.Fragment;


import com.example.android.timerproject.R;
import com.example.android.timerproject.ui.home.HomeFragment;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import android.content.Intent;
import java.io.Serializable;



public class timerCreator extends AppCompatActivity implements Serializable {

    private EditText nameInput;

    Hashtable<String, Timer> timers = new Hashtable<String, Timer>();

    public Hashtable getHashTable()
    {
        return timers;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_creator);

        int minutes = 0;
        int seconds = 0;
        nameInput = (EditText) findViewById(R.id.timerName);
        EditText trainHours = findViewById(R.id.trainhoursInput);
        EditText trainMinutes = findViewById(R.id.trainminutesInput);
        EditText trainSeconds = findViewById(R.id.trainsecondsInput);

        EditText breakHours = findViewById(R.id.breakhoursInput);
        EditText breakMinutes = findViewById(R.id.breakminutesInput);
        EditText breakSeconds = findViewById(R.id.breaksecondsInput);

        final int exTime = 0;

        Button button = findViewById(R.id.saveTimer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String timerName = String.valueOf(nameInput.getText());
                //exTime = Integer.parseInt(trainHours.getText());
                //exTime = Integer.parseInt(exTime);

                Timer timer = new Timer(timerName, 1, 2);
                System.out.println(timer.getName());
                Intent objectReturn = new Intent();
                objectReturn.putExtra("object", timer);
                //HomeFragment fragobj = new HomeFragment();
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("object", timer);;
                //HomeFragment.setArguments(bundle);

                setResult(Activity.RESULT_OK, objectReturn);


                finish();
            }
        });
    }



}
