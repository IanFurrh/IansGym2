package com.example.android.iansgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class CreateScreen extends AppCompatActivity {

    private static final String TAG = "CreateScreen";


    ArrayList<Workout> workouts;
    Workout w;
    ListView createList;



    ArrayList<Exercise> list = new ArrayList<Exercise>();
    Button btnAdd;
    EditText ExNameEt;
    EditText ExMinEt;
    EditText ExSecEt;
    ExerciseListAdapter exerciseListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        workouts = WorkoutList.getList();

        setContentView(R.layout.activity_create_screen);
        Log.d(TAG, "onCreate: Started.");


        w = MainActivity.selectedWorkout;
        list = w.getExercises();
        TextView wnDisplay = (TextView) findViewById(R.id.WorkoutNameDisplay);
        wnDisplay.setText(w.getWorkoutName());


        createList = (ListView) findViewById(R.id.createList);

        exerciseListAdapter = new ExerciseListAdapter(this, R.layout.exercise_array, list);

        btnAdd = (Button) findViewById(R.id.btnAdd);


        //exerciseListAdapter = new ArrayAdapter<Exercise>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        createList.setAdapter(exerciseListAdapter);
    }


    public void btnAdd(View view) {


        ExNameEt = (EditText) findViewById(R.id.etExName);
        ExMinEt = (EditText) findViewById(R.id.etExMin);
        ExSecEt = (EditText) findViewById(R.id.etExSec);
        String names = ExNameEt.getText().toString();
        String min = ExMinEt.getText().toString();
        String sec = ExSecEt.getText().toString();
        if (min == null || min.trim().length() < 1) {
            min = "0";
        }
        if (sec == null || sec.trim().length() < 1) {
            sec = "0";
        }
        w.addExercise(new Exercise(names, Integer.parseInt(min), Integer.parseInt(sec)));
        exerciseListAdapter.notifyDataSetChanged();
        ExNameEt.setText("");
        ExMinEt.setText("");
        ExSecEt.setText("");


    }

    public void saveData() {
        SharedPreferences sp = getSharedPreferences("myApp", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        // use GSON to convert entire list into json XML text
        Gson gson = new Gson();
        String json = gson.toJson(workouts);

        // write out do the shared preferences under the key "myApp" the json text
        //  representing all the data in the list
        editor.putString("myList", json);
        editor.apply();

    }

    public void saveWorkout(View view) {

        saveData();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void runWorkout(View view) {

        saveData();
        Intent intent = new Intent(this, TimerScreen.class);
        startActivity(intent);
    }


    public void goBack(View view) {
        MainActivity.selectedWorkout = null;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
