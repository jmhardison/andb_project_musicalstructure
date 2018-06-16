package com.jonathanhardison.andb_project_musicalstructure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //get views
        TextView tvSongName = NowPlayingActivity.this.findViewById(R.id.tvNowPlayingSongName);
        TextView tvSongArtist = NowPlayingActivity.this.findViewById(R.id.tvNowPlayingSongArtist);
        ImageView ivSongAlbumArt = NowPlayingActivity.this.findViewById(R.id.tvNowPlayingAlbumArt);

        //set text and image
        //retrieve the data from passed strings in the extras
        Bundle data = getIntent().getExtras();
        SongDataType songInfo = data.getParcelable("songinfo");

        tvSongName.setText(songInfo.getSongName());
        tvSongArtist.setText(songInfo.getSongArtist());
        ivSongAlbumArt.setImageResource(songInfo.getAlbumImage());

        //set onclicks for buttons, they do nothing other than pop a notification.
        //this could have been wired up to play a song.

        ImageView bPlay = findViewById(R.id.bNowPlayingPlay);
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pop toast
                Toast.makeText(NowPlayingActivity.this,"Now Playing", Toast.LENGTH_LONG).show();

            }
        });


        ImageView bPause = findViewById(R.id.bNowPlayingPause);
        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pop toast
                Toast.makeText(NowPlayingActivity.this,"Now Paused", Toast.LENGTH_LONG).show();
            }
        });

        //button to return
        Button bReturn = findViewById(R.id.nowPlayingReturn);
        bReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //return to previous by finishing.
                finish();
            }
        });

    }
}
