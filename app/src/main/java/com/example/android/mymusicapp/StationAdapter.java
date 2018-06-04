package com.example.android.mymusicapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prajbhanda on 5/24/2018.
 * Adapter for displaying station name and image corresponding to the station
 */

public class StationAdapter extends ArrayAdapter<Station> {
    // Create GenreAdapter constructor
    public StationAdapter(@NonNull Context context, ArrayList<Station> stations) {
        super(context, 0, stations);
    }

    /*
        Override getView method
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Create a view
        View listItemView = convertView;

        // If the view is null, inflate it by id: list_item
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the current station by the position id
        Station currentStation = getItem(position);

        // Set the station name to the view
        TextView stationName = (TextView) listItemView.findViewById(R.id.song_text_view);
        stationName.setText(currentStation.getStationName());

        // Set the image resource ID to the view
        ImageView stationImage = (ImageView) listItemView.findViewById(R.id.song_image_view);
        stationImage.setImageResource(currentStation.getStationImageId());

        // return the view
        return listItemView;
    }
}
