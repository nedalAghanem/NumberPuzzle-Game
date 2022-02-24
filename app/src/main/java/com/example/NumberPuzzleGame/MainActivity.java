package com.example.NumberPuzzleGame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_list;
    RecyclerView rv_recyclerView;
    ArrayList<Game> games;
    Adapter lv_adapter;
    GameRecyclerViewAdapter rv_adapter;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //lv_list = findViewById(R.id.main_lv_list);
        rv_recyclerView = findViewById(R.id.main_rv_recyclerview);
        db=new MyDatabase(this);

        // Testing for list
        /*games= new ArrayList<>();
        games=db.getAllGames();
       //games= new MyDatabase(this).getAllGames();
        lv_adapter = new Adapter(this, R.layout.custom_layout_adapter, games);
        lv_list.setAdapter(lv_adapter);
        lv_adapter.notifyDataSetChanged();*/

        games=new ArrayList<>();
        games =db.getAllGames();
        rv_adapter = new GameRecyclerViewAdapter(games);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv_recyclerView.setHasFixedSize(true);
        rv_recyclerView.setLayoutManager(lm);
        rv_recyclerView.setAdapter(rv_adapter);
    }
}
