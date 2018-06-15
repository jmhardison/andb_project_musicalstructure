package com.jonathanhardison.andb_project_musicalstructure;

import android.support.annotation.Nullable;

/**
 * Custom data class for song type.
 */
public class SongDataType {
    private String _Name;
    private String _Artist;
    private String _Genre;
    //passing an int here to do resource by ID ont he ImageView later.
    private int _AlbumImage;

    public SongDataType(String name, String artist, String genre, @Nullable int albumImage){
        _Name = name;
        _Artist = artist;
        _Genre = genre;
        _AlbumImage = albumImage;
    }

    /**
     * Returns the Song Name for item.
     */
    public String getSongName(){
        return _Name;
    }

    /**
     * Returns the Song Artist for item.
     */
    public String getSongArtist(){
        return _Artist;
    }

    /**
     * Returns the Song Genre for item.
     */
    public String getSongGenre(){
        return _Genre;
    }

    /**
     * Returns the Album Image RID for item.
     */
    public int getAlbumImage() {
        return _AlbumImage;
    }
}
