package com.example.android.music_app_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_songs.xml layout file
        setContentView(R.layout.activity_songs);

        // Receive the extra ArrayList coming from the intent (Music class object).
        final ArrayList<Music> artists = getIntent().getExtras().getParcelableArrayList(Music.PARCELABLE_KEY);

        // Use an MusicAdapter object to inflate received ArrayList.
        MusicAdapter adapter = new MusicAdapter(this, artists);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // set OnItemClickListner to call PlayingActivity class with different song titles.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    final ArrayList<Music> artistSongs1 = new ArrayList<>();
                    artistSongs1.add(new Music(getString(R.string.artist1), getString(R.string.artist1music1)));
                    artistSongs1.add(new Music(getString(R.string.artist1), getString(R.string.artist1music2)));

                    Intent goToTrack = new Intent(AlbumsActivity.this, PlayingActivity.class);
                    goToTrack.putParcelableArrayListExtra(Music.PARCELABLE_KEY, artistSongs1);

                    startActivity(goToTrack);
                }
                if (position == 1) {
                    final ArrayList<Music> artistSongs2 = new ArrayList<>();
                    artistSongs2.add(new Music(getString(R.string.artist2), getString(R.string.artist2music1_albumA)));
                    artistSongs2.add(new Music(getString(R.string.artist2), getString(R.string.artist2music2_albumA)));

                    Intent goToTrack = new Intent(AlbumsActivity.this, PlayingActivity.class);

                    goToTrack.putParcelableArrayListExtra(Music.PARCELABLE_KEY, artistSongs2);

                    startActivity(goToTrack);
                }
                if (position == 2) {
                    final ArrayList<Music> artistSongs3 = new ArrayList<>();
                    artistSongs3.add(new Music(getString(R.string.artist2), getString(R.string.artist2music1_albumB)));

                    Intent goToTrack = new Intent(AlbumsActivity.this, PlayingActivity.class);

                    goToTrack.putParcelableArrayListExtra(Music.PARCELABLE_KEY, artistSongs3);

                    startActivity(goToTrack);
                }
                if (position == 3) {
                    final ArrayList<Music> artistSongs4 = new ArrayList<>();
                    artistSongs4.add(new Music(getString(R.string.artist3), getString(R.string.artist3music1)));
                    artistSongs4.add(new Music(getString(R.string.artist3), getString(R.string.artist3music2)));
                    artistSongs4.add(new Music(getString(R.string.artist3), getString(R.string.artist3music3)));

                    Intent goToTrack = new Intent(AlbumsActivity.this, PlayingActivity.class);
                    goToTrack.putParcelableArrayListExtra(Music.PARCELABLE_KEY, artistSongs4);
                    startActivity(goToTrack);
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
