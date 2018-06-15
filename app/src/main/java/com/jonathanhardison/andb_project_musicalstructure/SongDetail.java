package com.jonathanhardison.andb_project_musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SongDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        //get views
        TextView tvSongName = (TextView) SongDetail.this.findViewById(R.id.tvNowPlayingSongName);
        TextView tvSongArtist = (TextView) SongDetail.this.findViewById(R.id.tvNowPlayingSongArtist);
        TextView tvSongGenre = (TextView) SongDetail.this.findViewById(R.id.tvNowPlayingGenre);
        ImageView ivSongAlbumArt = (ImageView) SongDetail.this.findViewById(R.id.tvNowPlayingAlbumArt);

        //set text and image
        //retrieve the data from passed strings in the extras
        tvSongName.setText("Name: " + getIntent().getExtras().getString("songname"));
        tvSongArtist.setText("Artist: " + getIntent().getExtras().getString("songartist"));
        tvSongGenre.setText("Genre: " + getIntent().getExtras().getString("songgenre"));
        ivSongAlbumArt.setImageResource(getIntent().getExtras().getInt("songalbum"));

    }
}
