package com.example.android.iansgym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimerScreen extends AppCompatActivity {
    ArrayList<Workout> workouts;
    Timer timer;
    TimerTask task;
    int exNum = 0;
    int exTime;
    String exName = "";
    TextView exerciseTimer;
    TextView exerciseTitle;
    Exercise currentExercise;
    Workout workout;
    boolean pause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timerscreen);
        workout = MainActivity.selectedWorkout;
        exerciseTimer = (TextView) findViewById(R.id.exerciseTimer);
        exerciseTitle = (TextView) findViewById(R.id.exerciseTitle);
        if (workout != null) {
            setExercise(exNum);
            timer = new Timer();
            task = new TimerTask() {
                public void run() {
                    if (!pause) {
                        System.out.println("time: " + exTime);
                        exTime--;
                        if (exTime <= 0) {
                            exNum++;
                            if (exNum < workout.getExercises().size()) {
                                currentExercise = setExercise(exNum);
                            } else {
                                endWorkout();
                                task.cancel();
                            }
                        }
                        setLabels(currentExercise.getName(), exTime);
                    }
                }
            };
            timer.schedule(task, 1, 1000);
        } else {
            System.err.println("Workout is null!");
        }

    }

    private void setLabels(String title, int time) {
        exerciseTitle.setText(title);

        String text = MainActivity.formatDuration(time);
        exerciseTimer.setText(text);
    }

    private Exercise setExercise(int num) {
        currentExercise = workout.getExercises().get(num);
        exTime = currentExercise.getDuration();
        exName = currentExercise.getName();
        setLabels(exName, exTime);
        return currentExercise;
    }

    public void endWorkout() {
        String t = "Good Job!";
        TextView endString = (TextView) findViewById(R.id.endString);
        endString.setText(t);
    }

    public void pauseWorkout(View view) {
        if (!pause) {
            pause = true;
        } else {
            pause = false;
        }
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
