package com.example.android.iansgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class NameWorkoutActivity extends AppCompatActivity {

    ArrayList<Workout> workouts;
    static Workout w;


    Bundle args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_workout_screen);
        workouts = WorkoutList.getList();


    }


    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    public void createWorkoutName(View view) {
        EditText et = (EditText) findViewById(R.id.WorkoutName);
        w = new Workout(et.getText().toString());
        workouts.add(w);
        MainActivity.selectedWorkout = w;
        Intent intent = new Intent(this, CreateScreen.class);
        startActivity(intent);


    }

}