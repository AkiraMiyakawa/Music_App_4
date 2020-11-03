package com.example.android.music_app_4;

import android.os.Parcel;
import android.os.Parcelable;


public class Music implements Parcelable {
    /**
     * Artist name
     */
    private String mArtistInfo;
    /**
     * album name
     */
    private String mAlbumInfo;


    /**
     * constructor for Playlists
     */
    public Music(String artistName, String albumName) {
        mArtistInfo = artistName;
        mAlbumInfo = albumName;
    }

    /**
     * constructor for Artists name
     */
    public Music(String artistName) {
        mArtistInfo = artistName;
    }


    /**
     * Parcelable
     */

    public static final String PARCELABLE_KEY = "music";

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        public Music[] newArray(int size) {
            return new Music[size];
        }
    };


    protected Music(Parcel in) {
        mArtistInfo = in.readString();
        mAlbumInfo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mArtistInfo);
        dest.writeString(mAlbumInfo);
    }

    @Override
    public int describeContents() {
        return 0;
    }


    /**
     * Get the Artist name.
     */

    public String getArtist() {
        return mArtistInfo;
    }

    /**
     * Get the Album name.
     */

    public String getAlbum() {
        return mAlbumInfo;
    }

}
