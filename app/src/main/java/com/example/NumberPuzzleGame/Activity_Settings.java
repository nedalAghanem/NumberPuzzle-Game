package com.example.NumberPuzzleGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Settings extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    Button btn_show_all_game,btn_last_game_data,btn_change_password,btn_clear_game_histiry;
    String pass;
    MyDatabase dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__settings);

        btn_show_all_game=findViewById(R.id.activity_settings_btn_show_all_game);
        btn_last_game_data=findViewById(R.id.activity_settings_btn_last_game_data);
        btn_change_password=findViewById(R.id.activity_settings_btn_change_password);
        btn_clear_game_histiry=findViewById(R.id.activity_settings_btn_clear_game_histiry);

        dp=new MyDatabase(this);

        sp= getSharedPreferences("register",MODE_PRIVATE);

        pass = sp.getString("password","null");

        btn_show_all_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btn_last_game_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Game> games=dp.getAllGames();
                String data="";

                for (Game game : games) {
                    data = game.getTimedate();
                }
                Toast.makeText(Activity_Settings.this, "DateLastGame is : "+ data , Toast.LENGTH_SHORT).show();
            }
        });
        btn_change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getBaseContext(),Change_password.class);
                startActivity(intent);
            }
        });
        btn_clear_game_histiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Game> games=dp.getAllGames();
                Game game=new Game();
                //for (int i=0;i<=games.size();i++) {
                  //  game.setId(1);

               // }
                dp.deleteGameData();

                Toast.makeText(Activity_Settings.this, "The data is delete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
