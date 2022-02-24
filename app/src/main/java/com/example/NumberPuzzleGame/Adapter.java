package com.example.NumberPuzzleGame;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Game> games;

    public Adapter(Context context, int layout, ArrayList<Game> games) {
        this.context = context;
        this.layout = layout;
        this.games = games;
    }


    @Override
    public int getCount() {
        return games.size();
    }
    public void addItem(Game g){
        this.games.add(g) ;
        notifyDataSetChanged();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
           convertView = LayoutInflater.from(context).inflate(layout,null);
        }
        TextView full_name=convertView.findViewById(R.id.custom_layout_fullname);
        TextView time_date=convertView.findViewById(R.id.custom_layout_timedate);
        TextView score=convertView.findViewById(R.id.custom_layout_score);

        Game g=games.get(position);

        full_name.setText(g.getFullname());
        time_date.setText(g.getTimedate());
        score.setText(String.valueOf(g.getScore()));

        return convertView;
    }
}
