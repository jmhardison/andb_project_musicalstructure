package com.jonathanhardison.andb_project_musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SongDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        //get views
        TextView tvSongName = SongDetailActivity.this.findViewById(R.id.tvInfoSongName);
        TextView tvSongArtist = SongDetailActivity.this.findViewById(R.id.tvInfoArtist);
        TextView tvSongGenre = SongDetailActivity.this.findViewById(R.id.tvInfoGenre);
        ImageView ivSongAlbumArt = SongDetailActivity.this.findViewById(R.id.tvInfoAlbumArt);

        //set text and image
        //retrieve the data from passed strings in the extras
        Bundle data = getIntent().getExtras();
        SongDataType songInfo = data.getParcelable("songinfo");

        tvSongName.setText("Name: " + songInfo.getSongName());
        tvSongArtist.setText("Artist: " + songInfo.getSongArtist());
        tvSongGenre.setText("Genre: " + songInfo.getSongGenre());
        ivSongAlbumArt.setImageResource(songInfo.getAlbumImage());

        //set up button to return
        Button bReturn = findViewById(R.id.infoReturn);
        bReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //return to previous by finishing.
                finish();
            }
        });
    }
}
