package com.jonathanhardison.andb_project_musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        //instantiate songs with some images.
        ArrayList<SongDataType> listOfSongs = new ArrayList<SongDataType>();

        listOfSongs.add(new SongDataType("I Want To Destroy Something Beautiful", "Josh Woodward", "Easy Listening", R.drawable.cemeterybytheroadlicensecc0publicdomain));
        listOfSongs.add(new SongDataType("Swan Song", "Paper Navy", "Country", R.drawable.cutepuppy13685720501crlicensecc0publicdomain));
        listOfSongs.add(new SongDataType("Bust This Bust That", "Professor Kliq", "Electronic", R.drawable.frenchbulldogpuppyportrait1509041878usplicensecc0publicdomain));
        listOfSongs.add(new SongDataType("These Days", "Robin Grey", "Easy Listening", R.drawable.spanishguitarlicensecc0publicdomain));
        listOfSongs.add(new SongDataType("Trail", "Nobara Hayakawa", "Electronic", R.drawable.spanishguitarlicensecc0publicdomain));

        //put into the adapter
        SongAdapter adapter = new SongAdapter(this, listOfSongs);

        //attach to view
        ListView listViewSongs = findViewById(R.id.lvSongs);
        listViewSongs.setAdapter(adapter);

    }
}
