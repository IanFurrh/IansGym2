package com.example.android.iansgym;

import static android.content.Context.MODE_PRIVATE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import java.util.ArrayList;

public class WorkoutList extends AppCompatActivity {

    private static ArrayList<Workout> WorkoutList = new ArrayList<>();

    private WorkoutList() {
    }


    public static ArrayList<Workout> getList() {
        return WorkoutList;
    }

}