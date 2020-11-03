package com.example.android.music_app_4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class PlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_songs.xml layout file
        setContentView(R.layout.activity_songs);

        // Receive the extra ArrayList coming from the intent (Music class object).
        final ArrayList<Music> tracks = getIntent().getExtras().getParcelableArrayList(Music.PARCELABLE_KEY);

        // Use an MusicAdapter object to inflate received ArrayList.
        MusicAdapter itemsAdapter = new MusicAdapter(this, tracks);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        // set OnItemClickListner to call Playing screen with the selected song title.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {

                setContentView(R.layout.playing_screen);

                // Create a new Music class object and assign tracks ArralList with selected position.
                Music m = tracks.get(position);

                // Call Artist name getter
                String trackName = m.getArtist();
                String albumName = m.getAlbum();

                TextView textView_track = (TextView) findViewById(R.id.albumTitle);
                textView_track.setText(trackName);

                TextView textView_album = (TextView) findViewById(R.id.trackTitle);
                textView_album.setText(albumName);

            }

        });
    }
}


