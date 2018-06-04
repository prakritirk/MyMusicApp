package com.example.android.mymusicapp;

/**
 * {@link Song} represents a song that is displayed as list item
 * It contains song name, artist name and image resource id for the song.
 * Created by prajbhanda on 5/22/2018.
 */

public class Song {

    // Name of the song
    private String mSongName;
    // Name of the artist
    private String mArtistName;
    // Resource id for the raw file
    private int mAudioResourceId;
    // Drawable resource ID
    private int mImageResourceId;

    /*
    * Create a new Song object.
    *
    * @param mSongName is the name of the song
    * @param mArtistName is the name of the artist
    * @param mImageResourceId resource id of the image corresponding to the song
    * @param mAudioResourceId is resource id of the raw file  corresponding to the song
    *
    * */


    public Song(String songName, String artistName, int imageResourceId, int audioResourceId) {
        mSongName = songName;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
        mArtistName = artistName;
    }

    /**
     * Get the song's name
     */

    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the artist's name
     */


    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the image resource ID
     */

    public int getImageResourceId() {
        return mImageResourceId;
    }



}