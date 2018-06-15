package com.jonathanhardison.andb_project_musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //get views
        TextView tvSongName = (TextView) NowPlaying.this.findViewById(R.id.tvNowPlayingSongName);
        TextView tvSongArtist = (TextView) NowPlaying.this.findViewById(R.id.tvNowPlayingSongArtist);
        ImageView ivSongAlbumArt = (ImageView) NowPlaying.this.findViewById(R.id.tvNowPlayingAlbumArt);

        //set text and image
        //retrieve the data from passed strings in the extras
        tvSongName.setText(getIntent().getExtras().getString("songname"));
        tvSongArtist.setText(getIntent().getExtras().getString("songartist"));
        ivSongAlbumArt.setImageResource(getIntent().getExtras().getInt("songalbum"));

        //set onclicks for buttons, they do nothing other than pop a notification.
        //this could have been wired up to play a song.

        ImageView bPlay = (ImageView) findViewById(R.id.bNowPlayingPlay);
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pop toast
                Toast.makeText(NowPlaying.this,"Now Playing", Toast.LENGTH_LONG).show();

            }
        });


        ImageView bPause = (ImageView) findViewById(R.id.bNowPlayingPause);
        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pop toast
                Toast.makeText(NowPlaying.this,"Now Paused", Toast.LENGTH_LONG).show();
            }
        });

    }
}
