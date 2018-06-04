package com.example.android.mymusicapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prajbhanda on 5/22/2018.
 */
public class GetExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_station );


        TextView station_home = (TextView) findViewById( R.id.station_home );
        TextView station_playing = (TextView) findViewById( R.id.station_now_playing );
        TextView station_library = (TextView) findViewById( R.id.station_library );
        TextView station_station = (TextView) findViewById( R.id.station_station );


        station_home.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent( GetExtraActivity.this, MainActivity.class );
                startActivity( homeIntent );
            }
        } );

        station_playing.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent( GetExtraActivity.this, NowPlayingActivity.class );
                int dummy_image_id = Resources.getSystem().getIdentifier( "dua_lipa", "drawable", "android" );
                nowPlayingIntent.putExtra( "SONG_IMAGE_ID", dummy_image_id );
                nowPlayingIntent.putExtra( "SONG_NAME", "Display currently playing song" );
                startActivity( nowPlayingIntent );
            }
        } );

        station_station.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent stationsIntent = new Intent( GetExtraActivity.this, GetExtraActivity.class );
                stationsIntent.putExtra( "SUCCEEDING_INTENT", "STATION" );
                startActivity( stationsIntent );
            }
        } );


        station_library.setOnClickListener( new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent( GetExtraActivity.this, GetExtraActivity.class );
                libraryIntent.putExtra( "SUCCEEDING_INTENT", "LIBRARY" );
                startActivity( libraryIntent );
            }
        } );


        String succeedingIntentName = getIntent().getStringExtra( "SUCCEEDING_INTENT" );

        if (succeedingIntentName.equalsIgnoreCase( "STATION" )) {

            // Create a ArrayList<Station>
            final ArrayList<Station> stationList = new ArrayList<Station>();
            // creating list of station names
            stationList.add( new Station( getString( R.string.category_dance ), R.drawable.dance_hits ) );
            stationList.add( new Station( getString( R.string.category_us ), R.drawable.us_hits ) );
            stationList.add( new Station( getString( R.string.category_bollywood ), R.drawable.bollywood_hits ) );


            // Adapter for Station Names
            StationAdapter adapter = new StationAdapter( this, stationList );

            // Get the ListView by id:
            final ListView listView = (ListView) findViewById( R.id.stations_list );

            // Set the adapter to listView
            listView.setAdapter( adapter );

        /*
            Create a ClickListener and set a explicit intent with Extra vars
         */
            listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    // Get the current station name
                    Station station_name = stationList.get( i );

                    // Create new Intent
                    Intent stationIntent = new Intent( GetExtraActivity.this, StationsActivity.class );

                    // Grabbing the extra information of station name to pass on to Station activity
                    stationIntent.putExtra( "STATION_NAME", station_name.getStationName() );
                    stationIntent.putExtra( "STATION_IMAGE", station_name.getStationImageId() );

                    // Start station activity
                    startActivity( stationIntent );
                }
            } );

        }


        if (succeedingIntentName.equalsIgnoreCase( "LIBRARY" )) {

            // Create a ArrayList<Station>
            final ArrayList<Station> genreList = new ArrayList<Station>();
            // creating list of station names

            genreList.add( new Station( getString( R.string.genre_1 ), R.drawable.pop ) );
            genreList.add( new Station( getString( R.string.genre_2 ), R.drawable.rock ) );

            // Adapter for Station Names
            StationAdapter adapter = new StationAdapter( this, genreList );

            // Get the ListView by id:
            final ListView listView = (ListView) findViewById( R.id.stations_list );

            // Set the adapter to listView
            listView.setAdapter( adapter );

        /*
           On click listeners on the station names with extra character to pass onto genres activity
         */
            listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    // Get the current genre
                    Station station_name = genreList.get( i );

                    // Create new Intent
                    Intent genreIntent = new Intent( GetExtraActivity.this, GenresActivity.class );

                    // Grabbing the extra information of station name to pass on to Station activity
                    genreIntent.putExtra( "GENRE_NAME", station_name.getStationName() );
                    genreIntent.putExtra( "GENRE_IMAGE", station_name.getStationImageId() );

                    // Start genre activity
                    startActivity( genreIntent );
                }
            } );

        }


    }
}
