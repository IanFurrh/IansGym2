package com.example.android.iansgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Iterator;

public class LibraryScreen extends AppCompatActivity {

    ArrayList<Workout> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.selectedWorkout = null;
        setContentView(R.layout.activity_library_screen);

        if (MainActivity.discoverClicked) {
            workouts = MainActivity.discoverWorkouts;
        } else {
            workouts = WorkoutList.getList();
        }

        WorkoutAdapter adapter = new WorkoutAdapter(this, R.layout.workout, workouts);

        ListView listView = (ListView) findViewById(R.id.libraryList);

        listView.setAdapter(adapter);

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}