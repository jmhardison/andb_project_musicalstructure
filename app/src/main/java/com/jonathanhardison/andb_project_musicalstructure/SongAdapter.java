package com.jonathanhardison.andb_project_musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.ArrayList;

/**
 * Custom ArrayAdapter for SongDataType
 */
public class SongAdapter extends ArrayAdapter<SongDataType> {


    public SongAdapter(Context context, ArrayList<SongDataType> songs){
        super(context, 0, songs);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vListItem = convertView;

        if(vListItem == null){
            vListItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        SongDataType currentSong = getItem(position);

        //get views
        TextView tvSongName = (TextView)vListItem.findViewById(R.id.itemSongName);
        TextView tvSongArtist = (TextView)vListItem.findViewById(R.id.itemSongArtist);
        ImageView tvSongAlbumArt = (ImageView)vListItem.findViewById(R.id.itemSongAlbumArt);
        ImageView bPlay = (ImageView)vListItem.findViewById(R.id.btnPlay);
        ImageView bInfo = (ImageView)vListItem.findViewById(R.id.btnInfo);

        //set view data from current song
        tvSongName.setText(currentSong.getSongName());
        tvSongArtist.setText(currentSong.getSongArtist());
        tvSongAlbumArt.setImageResource(currentSong.getAlbumImage());

        final SongDataType infoCurrentSong = (SongDataType) getItem(position);

        //onclick setup
        //storing data about currently selected song in extra's for retrieval in the next activity.
        bPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NowPlaying.class);
                intent.putExtra("songname", infoCurrentSong.getSongName());
                intent.putExtra("songartist", infoCurrentSong.getSongArtist());
                intent.putExtra("songgenre", infoCurrentSong.getSongGenre());
                intent.putExtra("songalbum", infoCurrentSong.getAlbumImage());
                getContext().startActivity(intent);
            }
        });

        bInfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SongDetail.class);
                intent.putExtra("songname", infoCurrentSong.getSongName());
                intent.putExtra("songartist", infoCurrentSong.getSongArtist());
                intent.putExtra("songgenre", infoCurrentSong.getSongGenre());
                intent.putExtra("songalbum", infoCurrentSong.getAlbumImage());
                getContext().startActivity(intent);
            }
        });

        return vListItem;

    }
}
