package com.example.android.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prajbhanda on 5/22/2018.
 */

public class StationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.songs_list );
        setTitle( "Stations" );

        TextView songs_home = (TextView) findViewById( R.id.songs_home );
        TextView songs_library = (TextView) findViewById( R.id.songs_library );
        TextView songs_station = (TextView) findViewById( R.id.songs_station );


        songs_home.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent( StationsActivity.this, MainActivity.class );
                startActivity( homeIntent );
            }
        } );

        songs_station.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent stationsIntent = new Intent( StationsActivity.this, GetExtraActivity.class );
                stationsIntent.putExtra( "SUCCEEDING_INTENT", "STATION" );
                startActivity( stationsIntent );
            }
        } );


        songs_library.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent( StationsActivity.this, GetExtraActivity.class );
                libraryIntent.putExtra( "SUCCEEDING_INTENT", "LIBRARY" );
                startActivity( libraryIntent );
            }
        } );


        String stationName = getIntent().getStringExtra( "STATION_NAME" );
        setTitle( stationName );


        if (stationName.equalsIgnoreCase( "Bollywood Hits" )) {
            bollywoodSongsInit();
        }
        if (stationName.equalsIgnoreCase( "Dance Hits" )) {
            danceSongsInit();
        }
        if (stationName.equalsIgnoreCase( "US Top Charts" )) {
            usHitsInit();
        }

        if (stationName == null) {
            Log.v( stationName, "is null" );
        }
    }

    /*
     Function to get adapter and pass corresponding songs list
  */
    public void getAdapter(final ArrayList<Song> songs) {

        SongAdapter adapter = new SongAdapter( this, songs );


        ListView listView = (ListView) findViewById( R.id.songs_list );

        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Get the current song
                Song song = songs.get( i );

                Intent nowPlayingIntent = new Intent( StationsActivity.this, NowPlayingActivity.class );

                // Grabbing the extra information of station name to pass on to Station activity
                nowPlayingIntent.putExtra( "SONG_NAME", song.getSongName() );
                nowPlayingIntent.putExtra( "ARTIST_NAME", song.getArtistName() );
                nowPlayingIntent.putExtra( "SONG_IMAGE_ID", song.getImageResourceId() );
                // Start intent activity
                startActivity( nowPlayingIntent );


            }
        } );


    }


    //Create init methods corresponding to each stations

    public void bollywoodSongsInit() {
        final ArrayList<Song> bollywoodSongs = new ArrayList<Song>();
        bollywoodSongs.add( new Song( getString( R.string.artist1_song_1 ), getString( R.string.artist_1 ), R.drawable.arijit_singh, R.raw.tum_hi_ho ) );
        bollywoodSongs.add( new Song( getString( R.string.artist1_song_2 ), getString( R.string.artist_1 ), R.drawable.arijit_singh, R.raw.tum_hi_ho ) );
        getAdapter( bollywoodSongs );

    }

    public void usHitsInit() {
        final ArrayList<Song> usSongs = new ArrayList<Song>();

        usSongs.add( new Song( getString( R.string.genre1_song_1 ), getString( R.string.genre1_song1_artist ), R.drawable.dua_lipa, R.raw.give_me_love ) );
        usSongs.add( new Song( getString( R.string.genre1_song_2 ), getString( R.string.genre1_song1_artist ), R.drawable.sia, R.raw.give_me_love ) );

        getAdapter( usSongs );
    }

    public void danceSongsInit() {
        final ArrayList<Song> danceSongs = new ArrayList<Song>();
        danceSongs.add( new Song( getString( R.string.genre2_song_1 ), getString( R.string.genre2_song1_artist ), R.drawable.imagine_dragons, R.raw.give_me_love ) );
        danceSongs.add( new Song( getString( R.string.genre1_song_1 ), getString( R.string.genre1_song1_artist ), R.drawable.sia, R.raw.give_me_love ) );

        getAdapter( danceSongs );
    }


}


