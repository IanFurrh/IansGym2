package com.example.android.iansgym;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WorkoutAdapter extends ArrayAdapter<Workout> {

    private static final String TAG = "exerciseListAdapter";
    private Context mContext;
    int mResource;

    public WorkoutAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Workout> objects) {
        super(context, resource, (List<Workout>) objects);
        mContext = context;
        mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Workout workout = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView WorkoutName = (TextView) convertView.findViewById(R.id.WorkoutName);

        TextView WorkoutTime = (TextView) convertView.findViewById(R.id.WorkoutTime);

        // Populate the data into the template view using the data object

        WorkoutName.setText(workout.getWorkoutName());
        String text = MainActivity.formatDuration(workout.getWorkoutTime());

        WorkoutTime.setText(text);
        convertView.setLongClickable(true);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.discoverClicked) {
                    MainActivity.selectedWorkout = MainActivity.discoverWorkouts.get(position);
                } else {
                    MainActivity.selectedWorkout = MainActivity.workouts.get(position);
                }
                Intent intent = new Intent(mContext, CreateScreen.class);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }


}
