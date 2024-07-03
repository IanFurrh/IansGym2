package com.example.android.iansgym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<Workout> workouts;
    static ArrayList<Workout> discoverWorkouts = loadData();
    static Workout selectedWorkout = null;

    static boolean discoverClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        workouts = WorkoutList.getList();
        setContentView(R.layout.activity_main);

        if (workouts.size() == 0) {
            // readData will read in data from persistent storage (using preferences)
            // if there aren't any (this is the FIRST time the app has been ever run)
            //  readData will create some dummy data.  probably want to remove the dummy
            //  data code once you get this finalized.
            readData();
        }


    }


    public void CreateScreen(View view) {
        Intent intent = new Intent(this, NameWorkoutActivity.class);
        startActivity(intent);
    }

    public void discoverScreen(View view) {
        discoverClicked = true;
        Intent intent = new Intent(this, LibraryScreen.class);
        startActivity(intent);
    }

    public void libraryScreen(View view) {
        discoverClicked = false;
        Intent intent = new Intent(this, LibraryScreen.class);
        startActivity(intent);
    }

    public static String formatDuration(int duration) {
        int minutes = (new Integer(duration / 60)).intValue();
        int seconds = duration % 60;
        String mins = String.format("%02d", minutes);
        String secs = String.format("%02d", seconds);
        String text = minutes > 0 ? mins + ":" + secs : secs;
        return text;
    }

    private void readData() {
        // get access to shared preferences under the key "myApp"
        SharedPreferences sp = getSharedPreferences("myApp", MODE_PRIVATE);
        if (sp != null) {
            Gson gson = new Gson();
            // read in the text from the share preference into a json XML string
            String json = sp.getString("myList", null);

            // code to parse the items from json into objects and store them into the
            //  arraylist.
            //
            //  Thge typ listed in TypeToken is the type of the arraylist.  Mine is
            //   and ArrayList<String>() but yours will be an ArrayList<Workout> or something
            //   similar so you'll need to change that there
            Type type = new TypeToken<ArrayList<Workout>>() {
            }.getType();
            ArrayList<Workout> tmp = gson.fromJson(json, type);

            // copy all the items in the tmp arraylist that just go populated from storage
            //  into the myList arraylist which is a reference to the SHARED ARRAY LIST all
            //  activities will have access to
            if (tmp != null)
                for (Workout s : tmp)
                    workouts.add(s);
        }
    }

    public static ArrayList<Workout> loadData() {
        Workout w;
        ArrayList<Workout> workouts = new ArrayList<Workout>();
        w = new Workout("Workout 1");
        w.addExercise(new Exercise("exercise 1", 1, 30));
        w.addExercise(new Exercise("exercise 2", 1, 30));
        w.addExercise(new Exercise("exercise 3", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 2");
        w.addExercise(new Exercise("exercise 4", 1, 30));
        w.addExercise(new Exercise("exercise 5", 1, 30));
        w.addExercise(new Exercise("exercise 6", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 3");
        w.addExercise(new Exercise("exercise 7", 1, 30));
        w.addExercise(new Exercise("exercise 8", 1, 30));
        w.addExercise(new Exercise("exercise 9", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 4");
        w.addExercise(new Exercise("exercise 10", 1, 30));
        w.addExercise(new Exercise("exercise 11", 1, 30));
        w.addExercise(new Exercise("exercise 12", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 5");
        w.addExercise(new Exercise("exercise 13", 1, 30));
        w.addExercise(new Exercise("exercise 14", 1, 30));
        w.addExercise(new Exercise("exercise 15", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 6");
        w.addExercise(new Exercise("exercise 16", 1, 30));
        w.addExercise(new Exercise("exercise 17", 1, 30));
        w.addExercise(new Exercise("exercise 18", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 7");
        w.addExercise(new Exercise("exercise 19", 1, 30));
        w.addExercise(new Exercise("exercise 20", 1, 30));
        w.addExercise(new Exercise("exercise 21", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 8");
        w.addExercise(new Exercise("exercise 22", 1, 30));
        w.addExercise(new Exercise("exercise 23", 1, 30));
        w.addExercise(new Exercise("exercise 24", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 9");
        w.addExercise(new Exercise("exercise 25", 1, 30));
        w.addExercise(new Exercise("exercise 26", 1, 30));
        w.addExercise(new Exercise("exercise 27", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 10");
        w.addExercise(new Exercise("exercise 28", 1, 30));
        w.addExercise(new Exercise("exercise 29", 1, 30));
        w.addExercise(new Exercise("exercise 30", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 11");
        w.addExercise(new Exercise("exercise 31", 1, 30));
        w.addExercise(new Exercise("exercise 32", 1, 30));
        w.addExercise(new Exercise("exercise 33", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 12");
        w.addExercise(new Exercise("exercise 34", 1, 30));
        w.addExercise(new Exercise("exercise 35", 1, 30));
        w.addExercise(new Exercise("exercise 36", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 13");
        w.addExercise(new Exercise("exercise 37", 1, 30));
        w.addExercise(new Exercise("exercise 38", 1, 30));
        w.addExercise(new Exercise("exercise 39", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 14");
        w.addExercise(new Exercise("exercise 40", 1, 30));
        w.addExercise(new Exercise("exercise 41", 1, 30));
        w.addExercise(new Exercise("exercise 42", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 15");
        w.addExercise(new Exercise("exercise 43", 1, 30));
        w.addExercise(new Exercise("exercise 44", 1, 30));
        w.addExercise(new Exercise("exercise 45", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 16");
        w.addExercise(new Exercise("exercise 46", 1, 30));
        w.addExercise(new Exercise("exercise 47", 1, 30));
        w.addExercise(new Exercise("exercise 48", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 17");
        w.addExercise(new Exercise("exercise 49", 1, 30));
        w.addExercise(new Exercise("exercise 50", 1, 30));
        w.addExercise(new Exercise("exercise 51", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 18");
        w.addExercise(new Exercise("exercise 52", 1, 30));
        w.addExercise(new Exercise("exercise 53", 1, 30));
        w.addExercise(new Exercise("exercise 54", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 19");
        w.addExercise(new Exercise("exercise 55", 1, 30));
        w.addExercise(new Exercise("exercise 56", 1, 30));
        w.addExercise(new Exercise("exercise 57", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 20");
        w.addExercise(new Exercise("exercise 58", 1, 30));
        w.addExercise(new Exercise("exercise 59", 1, 30));
        w.addExercise(new Exercise("exercise 60", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 21");
        w.addExercise(new Exercise("exercise 61", 1, 30));
        w.addExercise(new Exercise("exercise 62", 1, 30));
        w.addExercise(new Exercise("exercise 63", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 22");
        w.addExercise(new Exercise("exercise 64", 1, 30));
        w.addExercise(new Exercise("exercise 65", 1, 30));
        w.addExercise(new Exercise("exercise 66", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 23");
        w.addExercise(new Exercise("exercise 67", 1, 30));
        w.addExercise(new Exercise("exercise 68", 1, 30));
        w.addExercise(new Exercise("exercise 69", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 24");
        w.addExercise(new Exercise("exercise 70", 1, 30));
        w.addExercise(new Exercise("exercise 71", 1, 30));
        w.addExercise(new Exercise("exercise 72", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 25");
        w.addExercise(new Exercise("exercise 73", 1, 30));
        w.addExercise(new Exercise("exercise 74", 1, 30));
        w.addExercise(new Exercise("exercise 75", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 26");
        w.addExercise(new Exercise("exercise 76", 1, 30));
        w.addExercise(new Exercise("exercise 77", 1, 30));
        w.addExercise(new Exercise("exercise 78", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 27");
        w.addExercise(new Exercise("exercise 79", 1, 30));
        w.addExercise(new Exercise("exercise 80", 1, 30));
        w.addExercise(new Exercise("exercise 81", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 28");
        w.addExercise(new Exercise("exercise 82", 1, 30));
        w.addExercise(new Exercise("exercise 83", 1, 30));
        w.addExercise(new Exercise("exercise 84", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 29");
        w.addExercise(new Exercise("exercise 85", 1, 30));
        w.addExercise(new Exercise("exercise 86", 1, 30));
        w.addExercise(new Exercise("exercise 87", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 30");
        w.addExercise(new Exercise("exercise 88", 1, 30));
        w.addExercise(new Exercise("exercise 89", 1, 30));
        w.addExercise(new Exercise("exercise 90", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 31");
        w.addExercise(new Exercise("exercise 91", 1, 30));
        w.addExercise(new Exercise("exercise 92", 1, 30));
        w.addExercise(new Exercise("exercise 93", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 32");
        w.addExercise(new Exercise("exercise 94", 1, 30));
        w.addExercise(new Exercise("exercise 95", 1, 30));
        w.addExercise(new Exercise("exercise 96", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 33");
        w.addExercise(new Exercise("exercise 97", 1, 30));
        w.addExercise(new Exercise("exercise 98", 1, 30));
        w.addExercise(new Exercise("exercise 99", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 34");
        w.addExercise(new Exercise("exercise 100", 1, 30));
        w.addExercise(new Exercise("exercise 101", 1, 30));
        w.addExercise(new Exercise("exercise 102", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 35");
        w.addExercise(new Exercise("exercise 103", 1, 30));
        w.addExercise(new Exercise("exercise 104", 1, 30));
        w.addExercise(new Exercise("exercise 105", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 36");
        w.addExercise(new Exercise("exercise 106", 1, 30));
        w.addExercise(new Exercise("exercise 107", 1, 30));
        w.addExercise(new Exercise("exercise 108", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 37");
        w.addExercise(new Exercise("exercise 109", 1, 30));
        w.addExercise(new Exercise("exercise 110", 1, 30));
        w.addExercise(new Exercise("exercise 111", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 38");
        w.addExercise(new Exercise("exercise 112", 1, 30));
        w.addExercise(new Exercise("exercise 113", 1, 30));
        w.addExercise(new Exercise("exercise 114", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 39");
        w.addExercise(new Exercise("exercise 115", 1, 30));
        w.addExercise(new Exercise("exercise 116", 1, 30));
        w.addExercise(new Exercise("exercise 117", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 40");
        w.addExercise(new Exercise("exercise 118", 1, 30));
        w.addExercise(new Exercise("exercise 119", 1, 30));
        w.addExercise(new Exercise("exercise 120", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 41");
        w.addExercise(new Exercise("exercise 121", 1, 30));
        w.addExercise(new Exercise("exercise 122", 1, 30));
        w.addExercise(new Exercise("exercise 123", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 42");
        w.addExercise(new Exercise("exercise 124", 1, 30));
        w.addExercise(new Exercise("exercise 125", 1, 30));
        w.addExercise(new Exercise("exercise 126", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 43");
        w.addExercise(new Exercise("exercise 127", 1, 30));
        w.addExercise(new Exercise("exercise 128", 1, 30));
        w.addExercise(new Exercise("exercise 129", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 44");
        w.addExercise(new Exercise("exercise 130", 1, 30));
        w.addExercise(new Exercise("exercise 131", 1, 30));
        w.addExercise(new Exercise("exercise 132", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 45");
        w.addExercise(new Exercise("exercise 133", 1, 30));
        w.addExercise(new Exercise("exercise 134", 1, 30));
        w.addExercise(new Exercise("exercise 135", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 46");
        w.addExercise(new Exercise("exercise 136", 1, 30));
        w.addExercise(new Exercise("exercise 137", 1, 30));
        w.addExercise(new Exercise("exercise 138", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 47");
        w.addExercise(new Exercise("exercise 139", 1, 30));
        w.addExercise(new Exercise("exercise 140", 1, 30));
        w.addExercise(new Exercise("exercise 141", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 48");
        w.addExercise(new Exercise("exercise 142", 1, 30));
        w.addExercise(new Exercise("exercise 143", 1, 30));
        w.addExercise(new Exercise("exercise 144", 1, 30));
        workouts.add(w);

        w = new Workout("Workout 49");
        w.addExercise(new Exercise("exercise 145", 1, 30));
        w.addExercise(new Exercise("exercise 146", 1, 30));
        w.addExercise(new Exercise("exercise 147", 1, 30));
        workouts.add(w);

        return workouts;
    }
}