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

    static class SongViewHolder {
        //get views
        private TextView tvSongName;
        private TextView tvSongArtist;
        private ImageView tvSongAlbumArt;
        private ImageView bPlay;
        private ImageView bInfo;
    }

    public SongAdapter(Context context, ArrayList<SongDataType> songs){
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vListItem = convertView;
        SongViewHolder holder;

        if(vListItem == null){
            vListItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
            holder = new SongViewHolder();
            //get views
            holder.tvSongName = vListItem.findViewById(R.id.itemSongName);
            holder.tvSongArtist = vListItem.findViewById(R.id.itemSongArtist);
            holder.tvSongAlbumArt = vListItem.findViewById(R.id.itemSongAlbumArt);
            holder.bPlay = vListItem.findViewById(R.id.btnPlay);
            holder.bInfo = vListItem.findViewById(R.id.btnInfo);
        }
        else{
            holder = (SongViewHolder) convertView.getTag();
        }

        SongDataType currentSong = getItem(position);



        //set view data from current song
        holder.tvSongName.setText(currentSong.getSongName());
        holder.tvSongArtist.setText(currentSong.getSongArtist());
        holder.tvSongAlbumArt.setImageResource(currentSong.getAlbumImage());

        final SongDataType infoCurrentSong = (SongDataType) getItem(position);

        //onclick setup
        //storing data about currently selected song in extra's for retrieval in the next activity.
        holder.bPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), NowPlayingActivity.class);
                intent.putExtra("songinfo", new SongDataType(
                        infoCurrentSong.getSongName(),
                        infoCurrentSong.getSongArtist(),
                        infoCurrentSong.getSongGenre(),
                        infoCurrentSong.getAlbumImage()
                        ));

                getContext().startActivity(intent);
            }
        });

        holder.bInfo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SongDetailActivity.class);
                intent.putExtra("songinfo", new SongDataType(
                        infoCurrentSong.getSongName(),
                        infoCurrentSong.getSongArtist(),
                        infoCurrentSong.getSongGenre(),
                        infoCurrentSong.getAlbumImage()
                ));

                getContext().startActivity(intent);
            }
        });

        return vListItem;

    }
}
