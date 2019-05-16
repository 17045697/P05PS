package com.example.p05ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    private ArrayList<Song> song;
    private Context context;
    private TextView tvSongYear, tvSongTitle, tvSongSinger;
    private ImageView ivSong, ivStar, ivStar2, ivStar3, ivStar4, ivStar5;

    public SongAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);

        song = objects;

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_layout, parent, false);

        tvSongTitle = rowView.findViewById(R.id.tvSongTitle);
        tvSongSinger = rowView.findViewById(R.id.tvSongSinger);
        tvSongYear = rowView.findViewById(R.id.tvSongYear);

        ivSong = rowView.findViewById(R.id.ivSong);
        ivStar = rowView.findViewById(R.id.ivStar);
        ivStar2 = rowView.findViewById(R.id.ivStar2);
        ivStar3 = rowView.findViewById(R.id.ivStar3);
        ivStar4 = rowView.findViewById(R.id.ivStar4);
        ivStar5 = rowView.findViewById(R.id.ivStar5);

        Song currentSong = song.get(position);

        tvSongTitle.setText(currentSong.getTitle());
        tvSongSinger.setText(currentSong.getSingers());
        tvSongYear.setText(currentSong.getYears());

        if(currentSong.isStar()) {
            ivStar.setImageResource(R.drawable.star);
        }
        else {
            ivStar.setImageResource(R.drawable.nostar);
        }

        return rowView;
    }

}
