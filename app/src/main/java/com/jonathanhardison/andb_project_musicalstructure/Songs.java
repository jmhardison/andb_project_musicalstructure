package com.jonathanhardison.andb_project_musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Songs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        //instantiate songs with some images.
        ArrayList<SongDataType> listOfSongs = new ArrayList<SongDataType>();

        listOfSongs.add(new SongDataType("I Want To Destroy Something Beautiful", "Josh Woodward", "Easy Listening",
                getResources().getIdentifier("cemeterybytheroadlicensecc0publicdomain", "drawable", getPackageName())));
        listOfSongs.add(new SongDataType("Swan Song", "Paper Navy", "Country",
                getResources().getIdentifier("cutepuppy13685720501crlicensecc0publicdomain", "drawable", getPackageName())));
        listOfSongs.add(new SongDataType("Bust This Bust That", "Professor Kliq", "Electronic",
                getResources().getIdentifier("frenchbulldogpuppyportrait1509041878usplicensecc0publicdomain", "drawable", getPackageName())));
        listOfSongs.add(new SongDataType("These Days", "Robin Grey", "Easy Listening",
                getResources().getIdentifier("spanishguitarlicensecc0publicdomain", "drawable", getPackageName())));
        listOfSongs.add(new SongDataType("Trail", "Nobara Hayakawa", "Electronic",
                getResources().getIdentifier("spanishguitarlicensecc0publicdomain", "drawable", getPackageName())));

        //put into the adapter
        SongAdapter adapter = new SongAdapter(this, listOfSongs);

        //attach to view
        ListView listViewSongs = (ListView) findViewById(R.id.lvSongs);
        listViewSongs.setAdapter(adapter);

    }
}
