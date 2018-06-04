package com.example.android.mymusicapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by prajbhanda on 5/22/2018.
 */

public class GenresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.songs_list );

        TextView songs_home = (TextView) findViewById( R.id.songs_home );
        TextView songs_library = (TextView) findViewById( R.id.songs_library );
        TextView songs_station = (TextView) findViewById( R.id.songs_station );


        songs_home.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent( GenresActivity.this, MainActivity.class );
                startActivity( homeIntent );
            }
        } );

        songs_station.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent stationsIntent = new Intent( GenresActivity.this, GetExtraActivity.class );
                stationsIntent.putExtra( "SUCCEEDING_INTENT", "STATION" );
                startActivity( stationsIntent );
            }
        } );

        songs_library.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent( GenresActivity.this, GetExtraActivity.class );
                libraryIntent.putExtra( "SUCCEEDING_INTENT", "LIBRARY" );
                startActivity( libraryIntent );
            }
        } );


        String genreName = getIntent().getStringExtra( "GENRE_NAME" );
        setTitle( genreName );


        if (genreName.equalsIgnoreCase( "Pop" )) {
            popSongsInit();
        }
        if (genreName.equalsIgnoreCase( "Rock" )) {
            rockSongsInit();
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

                Intent nowPlayingIntent = new Intent( GenresActivity.this, NowPlayingActivity.class );

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

    public void popSongsInit() {

        final ArrayList<Song> genre1_songs = new ArrayList<Song>();
        genre1_songs.add( new Song( getString( R.string.genre1_song_1 ), getString( R.string.genre1_song1_artist ), R.drawable.dua_lipa, R.raw.give_me_love ) );
        genre1_songs.add( new Song( getString( R.string.genre1_song_2 ), getString( R.string.genre1_song2_artist ), R.drawable.sia, R.raw.give_me_love ) );
        getAdapter( genre1_songs );

    }


    public void rockSongsInit() {
        final ArrayList<Song> genre2_songs = new ArrayList<Song>();
        genre2_songs.add( new Song( getString( R.string.genre2_song_1 ), getString( R.string.genre2_song1_artist ), R.drawable.imagine_dragons, R.raw.tum_hi_ho ) );
        genre2_songs.add( new Song( getString( R.string.genre2_song_2 ), getString( R.string.genre2_song2_artist ), R.drawable.imagine_dragons, R.raw.tum_hi_ho ) );


        getAdapter( genre2_songs );
    }


}

