package com.jonathanhardison.andb_project_musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Custom data class for song type.
 */
public class SongDataType implements Parcelable{
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

    /**
     * Handle parcelable instance.
     * @param in
     */
    public SongDataType(Parcel in){
        String[] data = new String[4];
        in.readStringArray(data);

        _Name = data[0];
        _Artist = data[1];
        _Genre = data[2];
        _AlbumImage = Integer.parseInt(data[3]);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                this._Name,
                this._Artist,
                this._Genre,
                String.valueOf(this._AlbumImage)
        });
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SongDataType createFromParcel(Parcel in) {
            return new SongDataType(in);
        }

        public SongDataType[] newArray(int size) {
            return new SongDataType[size];
        }
    };
}
