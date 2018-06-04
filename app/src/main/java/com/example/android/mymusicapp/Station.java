package com.example.android.mymusicapp;

/**
 * {@link Station} represents a station that has corresponding genre of songs
 * It contains station name and image resource id for the station.
 * Created by prajbhanda on 5/23/2018.
 */

public class Station {
    // Init Vars
    private String mStationName;
    private int mImageId;

    /*
   * Create a new Station object.
   *
   * @param mStationName is the name of the station
   * @param mImageId resource id of the image corresponding to the station
   *
   * */
    public Station(String stationName, int stationImageId) {
        this.mStationName = stationName;
        this.mImageId = stationImageId;
    }

    /**
     * Get the song's name
     */
    public String getStationName() {
        return this.mStationName;
    }


    /**
     * Get the image resource ID
     */
    public int getStationImageId() {
        return this.mImageId;
    }

}
