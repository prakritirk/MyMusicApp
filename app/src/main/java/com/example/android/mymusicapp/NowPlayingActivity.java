package com.example.android.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by prajbhanda on 5/22/2018.
 */

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        //Set information about now playing song on activity_playing.xml layout.
        setContentView( R.layout.activity_playing );


        // Grab extra information like song name,artist and image related to the song.
        int song_image_id = getIntent().getIntExtra( "SONG_IMAGE_ID", -1 );
        String song_name = getIntent().getStringExtra( "SONG_NAME" );
        String artist_name = getIntent().getStringExtra( "ARTIST_NAME" );

        //Set the now playing text on Textview of activity_playing xml file.
        TextView song_text = (TextView) findViewById( R.id.now_playing_name );
        song_text.setText( "Now Playing: " + song_name + "\n" + "Artist: " + artist_name );

        /*
          Grab the image view on the activity_playing layout and set it to the extra resource id.
         */
        ImageView song_image = (ImageView) findViewById( R.id.now_playing_image );
        song_image.setImageResource( (int) song_image_id );

        // Grab all the views on the activity_playing xml layout.
        TextView songs_home = (TextView) findViewById( R.id.now_playing_home );
        TextView songs_library = (TextView) findViewById( R.id.now_playing_library );
        TextView songs_station = (TextView) findViewById( R.id.now_playing_station );

        // Set a click listener on the Views. Send extra information like station name and succeding intent
        songs_home.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent( NowPlayingActivity.this, MainActivity.class );
                startActivity( homeIntent );
            }
        } );

        songs_station.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent stationsIntent = new Intent( NowPlayingActivity.this, GetExtraActivity.class );
                stationsIntent.putExtra( "SUCCEEDING_INTENT", "STATION" );
                startActivity( stationsIntent );
            }
        } );


        songs_library.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent( NowPlayingActivity.this, GetExtraActivity.class );
                libraryIntent.putExtra( "SUCCEEDING_INTENT", "LIBRARY" );
                startActivity( libraryIntent );
            }
        } );
//

    }


}

