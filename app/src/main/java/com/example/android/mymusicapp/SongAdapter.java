package com.example.android.mymusicapp;

import android.app.Activity;
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
 * Adapter for displaying song name and image corresponding to the song
 * Created by prajbhanda on 5/22/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {


    public SongAdapter(Activity context, ArrayList<Song> songs) {

        super( context, 0, songs );
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Song currentSongAdapter = getItem( position );

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate( R.layout.list_item, parent, false );
        }


        TextView songTextView = (TextView) listItemView.findViewById( R.id.song_text_view );
        songTextView.setText( currentSongAdapter.getSongName() );


        // Set the image resource ID to the view
        ImageView songImageView = (ImageView) listItemView.findViewById( R.id.song_image_view );
        songImageView.setImageResource( currentSongAdapter.getImageResourceId() );


        return listItemView;


    }
}
