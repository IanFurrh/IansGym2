package com.example.android.iansgym;

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

public class ExerciseListAdapter extends ArrayAdapter<Exercise> {

    private static final String TAG = "exerciseListAdapter";
    private Context mContext;
    int mResource;

    public ExerciseListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Exercise> objects) {
        super(context, resource, (List<Exercise>) objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        int min = getItem(position).getMin();
        int sec = getItem(position).getSec();

        Exercise ex1 = new Exercise(name, min, sec);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView tvTime = (TextView) convertView.findViewById(R.id.textViewTime);

        tvName.setText(name);
        String duration = MainActivity.formatDuration(ex1.getDuration());
        tvTime.setText(duration);

        return convertView;
    }
}
