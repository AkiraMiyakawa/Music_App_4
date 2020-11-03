/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.music_app_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the artists category
        TextView artists = (TextView) findViewById(R.id.artists);

        // Set a click listener on that View
        artists.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the Artists category is clicked on.
            @Override
            public void onClick(View view) {

                // Fill Artist names to the music ArrayList.
                ArrayList<Music> music = new ArrayList<>();


                music.add(new Music(getString(R.string.artist1)));
                music.add(new Music(getString(R.string.artist2)));
                music.add(new Music(getString(R.string.artist3)));

                // Prepare an intent to ArtistActivity class.
                Intent goToArtists = new Intent(MainActivity.this, ArtistsActivity.class);

                // Use music object as an argument of putParcelabelArrayListExtra and start the intent.
                goToArtists.putParcelableArrayListExtra(Music.PARCELABLE_KEY, music);
                startActivity(goToArtists);
            }
        });


        // Find the View that shows the album category
        TextView family = (TextView) findViewById(R.id.albums);

        // Set a click listener on that View
        family.setOnClickListener(new OnClickListener() {

            // The code in this method will be executed when the Albums category is clicked on.
            @Override
            public void onClick(View view) {

                // Fill Album names to the music ArrayList.
                ArrayList<Music> music = new ArrayList<>();
                music.add(new Music(getString(R.string.AlbumA_artist1)));
                music.add(new Music(getString(R.string.AlbumA_artist2)));
                music.add(new Music(getString(R.string.AlbumB_artist2)));
                music.add(new Music(getString(R.string.AlbumA_artist3)));

                // Prepare an intent to AlbumsActivity class.
                Intent goToAlbums = new Intent(MainActivity.this, AlbumsActivity.class);

                // Use music object as an argument of putParcelabelArrayListExtra and start the intent.
                goToAlbums.putParcelableArrayListExtra(Music.PARCELABLE_KEY, (ArrayList<Music>) music);
                startActivity(goToAlbums);
            }
        });

        // Find the View that shows the play list category
        TextView colors = (TextView) findViewById(R.id.playLists);

        // Set a click listener on that View
        colors.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the play list category is clicked on.
            @Override
            public void onClick(View view) {

                // Fill Play list names to the music ArrayList.
                ArrayList<Music> music = new ArrayList<>();
                music.add(new Music(getString(R.string.PlayList1)));
                music.add(new Music(getString(R.string.PlayList2)));

                // Prepare an intent to PlayListActivity class.
                Intent goToPlayLists = new Intent(MainActivity.this, PlaylistsActivity.class);

                // Use music object as an argument of putParcelabelArrayListExtra and start the intent.
                goToPlayLists.putParcelableArrayListExtra(Music.PARCELABLE_KEY, music);
                startActivity(goToPlayLists);
            }
        });

    }
}
