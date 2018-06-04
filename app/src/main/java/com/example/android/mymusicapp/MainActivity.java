package com.example.android.mymusicapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView( R.layout.activity_main );


        // Find all the views on the activity_main xml file

        TextView main_library = (TextView) findViewById( R.id.main_library );
        TextView main_playing = (TextView) findViewById( R.id.main_now_playing );
        TextView main_station = (TextView) findViewById( R.id.main_station );


        // Set a click listener on the Views. Send extra information like station name and succeding intent

        main_station.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent stationsIntent = new Intent( MainActivity.this, GetExtraActivity.class );
                stationsIntent.putExtra( "SUCCEEDING_INTENT", "STATION" );
                startActivity( stationsIntent );
            }
        } );

        main_library.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent( MainActivity.this, GetExtraActivity.class );
                libraryIntent.putExtra( "SUCCEEDING_INTENT", "LIBRARY" );
                startActivity( libraryIntent );
            }
        } );

        main_playing.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the phrases View is clicked on.
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent( MainActivity.this, NowPlayingActivity.class );
                int image_id = Resources.getSystem().getIdentifier( "dua_lipa", "drawable", "android" );
                nowPlayingIntent.putExtra( "SONG_IMAGE_ID", image_id );
                nowPlayingIntent.putExtra( "SONG_NAME", "Display currently playing song" );
                startActivity( nowPlayingIntent );
            }
        } );
    }


}
