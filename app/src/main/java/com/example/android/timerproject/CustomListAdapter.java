package com.example.android.timerproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class CustomListAdapter extends ArrayAdapter<Timer> {
    //to reference the Activity

    Context mcontext;
    private List<Timer> timers = new ArrayList<>();
    int count = 0;
    int limit;
    private LayoutInflater inflater = null;

    public CustomListAdapter(Context context, ArrayList timersList)
    {
        super(context, 0, timersList);
        mcontext = context;
        timers = timersList;
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mcontext).inflate(R.layout.timer_list_row,parent,false);

        Timer currentTimer = timers.get(position);

        TextView name = (TextView)listItem.findViewById(R.id.timerName);
        name.setText(currentTimer.getName());

        TextView exLength = (TextView)listItem.findViewById(R.id.timerExLength);
        exLength.setText("Workout Interval: " + currentTimer.getWorkout());

        TextView brLength = (TextView)listItem.findViewById(R.id.timerBrLength);
        brLength.setText("Break Interval: " + currentTimer.getBreakTime());

        return listItem;
    }
}