package com.example.android.music_app_4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter {

    public MusicAdapter(Context context, ArrayList<Music> pMusics) {
        super(context, 0, pMusics);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Music my_music = (Music) getItem(position);
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artistName_text_view);
        artistTextView.setText(my_music.getArtist());

        // Check if the Album information is null and delete Album TextView.
        if (my_music.getAlbum() == null) {
            listItemView.findViewById(R.id.albumName_text_view).setVisibility(View.GONE);
            return listItemView;
        }

        TextView albumTextView = (TextView) listItemView.findViewById(R.id.albumName_text_view);
        albumTextView.setText(my_music.getAlbum());

        return listItemView;
    }

}