package com.example.android.iansgym;

import java.util.ArrayList;

public class Workout {

    ArrayList<Exercise> exercises = new ArrayList<>();

    public Workout(String WorkoutName) {
        this.workoutName = WorkoutName;
    }


    private String workoutName;
    private int workoutId;

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }


    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public int getWorkoutTime() {
        int totalTime = 0;
        for (Exercise e : exercises) {
            totalTime += e.getDuration();
        }
        return totalTime;
    }


    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise e) {
        exercises.add(e);
    }
}
