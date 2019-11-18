package com.example.android.timerproject;
import java.io.Serializable;
import java.util.*;

public class Timer implements Serializable {

    private String timerName;
    private int workout;
    private int breakTime;


    public Timer(String timerName, int workout, int breakTime)
    {
        this.timerName = timerName;
        this.workout = workout;
        this.breakTime = breakTime;
    }

    public ArrayList<Timer> timers = new ArrayList<>();

    public String getName()
    {
        return timerName;
    }

    int getWorkout()
    {
        return workout;
    }

    int getBreakTime()
    {
        return breakTime;
    }

    private static int lastTimerId = 0;


}
