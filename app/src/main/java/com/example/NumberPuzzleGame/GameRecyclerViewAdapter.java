package com.example.NumberPuzzleGame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GameRecyclerViewAdapter extends RecyclerView.Adapter<GameRecyclerViewAdapter.GameViewHolder> {
    ArrayList<Game> games;

    public GameRecyclerViewAdapter(ArrayList<Game> games) {
        this.games = games;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=  LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_adapter,null,false);
        GameViewHolder gameViewHolder=new GameViewHolder(v);
        return gameViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        Game g=games.get(position);
        holder.full_name.setText(g.getFullname());
        holder.time_date.setText(g.getTimedate());
        holder.score.setText(String.valueOf(g.getScore()));
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    class GameViewHolder extends RecyclerView.ViewHolder {
        TextView full_name;
        TextView time_date;
        TextView score;
        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            full_name=itemView.findViewById(R.id.custom_layout_fullname);
            time_date=itemView.findViewById(R.id.custom_layout_timedate);
            score=itemView.findViewById(R.id.custom_layout_score);
        }
    }
}
