package com.example.NumberPuzzleGame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Activity_Game extends AppCompatActivity {
    SharedPreferences sp;
    String [][] number,new_game;
    EditText et_enternum;
    TextView tv_username,tv_age,tv_score,tv_num1,tv_num2,tv_num3,tv_num4,tv_num5,tv_num6,tv_num7,tv_num8,tv_num9;
    TextView tv_green,tv_red;
    Button btn_check,btn_newgame;
    String enter_number;
    Question question;
    Question refresh_question;
    MyDatabase db;
    Game game;
    String fullname;
    int score;
    String score123;
    int hidding_num;
    boolean check=false;
    int count;
    MediaPlayer md;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);


        et_enternum=findViewById(R.id.activity_game_et_enternum);

        tv_score=findViewById(R.id.activity_game_tv_score);
        tv_username=findViewById(R.id.activity_game_tv_username);
        tv_age=findViewById(R.id.activity_game_tv_age);


        tv_num1=findViewById(R.id.activity_game_tv_num1);
        tv_num2=findViewById(R.id.activity_game_tv_num2);
        tv_num3=findViewById(R.id.activity_game_tv_num3);
        tv_num4=findViewById(R.id.activity_game_tv_num4);
        tv_num5=findViewById(R.id.activity_game_tv_num5);
        tv_num6=findViewById(R.id.activity_game_tv_num6);
        tv_num7=findViewById(R.id.activity_game_tv_num7);
        tv_num8=findViewById(R.id.activity_game_tv_num8);
        tv_num9=findViewById(R.id.activity_game_tv_num9);
        btn_check=findViewById(R.id.activity_game_btn_check);
        btn_newgame=findViewById(R.id.activity_game_btn_newgame);

        db=new MyDatabase(this);

        number=new String[3][3];
        question=Util.generteQuestion();
        hidding_num = question.getHiddiennumber();
        number =question.getData();

        tv_num1.setText(number [0][0]+"");
        tv_num2.setText(number [0][1]+"" );
        tv_num3.setText(number [0][2]+"");
        tv_num4.setText(number [1][0]+"");
        tv_num5.setText(number [1][1]+"");
        tv_num6.setText(number [1][2]+"");
        tv_num7.setText(number [2][0]+"");
        tv_num8.setText(number [2][1]+"");
        tv_num9.setText(number [2][2]+"");


        sp = getSharedPreferences("register", MODE_PRIVATE);
       tv_username.setText(sp.getString("fullname",""));
       tv_age.setText(sp.getString("date",""));


           btn_check.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   if (count==0) {
                       check=true;
                   }
                   if (check==true){
                       count=0;
                       enter_number=et_enternum.getText().toString();
                   if (String.valueOf(hidding_num).equals(enter_number)){
                       // Toast.makeText(getBaseContext(), R.string.True_tv_in_game, Toast.LENGTH_SHORT).show();
                       v= LayoutInflater.from(getBaseContext()).inflate(R.layout.custom_toast_truenumber,null,false);
                       tv_green=v.findViewById(R.id.custom_toast_tv_green);
                       tv_green.setText(R.string.True_tv_in_game);
                       Toast toast=new Toast(getBaseContext());
                       toast.setView(v);
                       toast.setDuration(Toast.LENGTH_LONG);
                       toast.show();
                       et_enternum.setText("");
                       check=true;
                       new_game = new String[3][3];

                       refresh_question = Util.generteQuestion();
                       hidding_num = refresh_question.getHiddiennumber();


                       new_game = refresh_question.getData();

                       tv_num1.setText(new_game[0][0] + "");
                       tv_num2.setText(new_game[0][1] + "");
                       tv_num3.setText(new_game[0][2] + "");
                       tv_num4.setText(new_game[1][0] + "");
                       tv_num5.setText(new_game[1][1] + "");
                       tv_num6.setText(new_game[1][2] + "");
                       tv_num7.setText(new_game[2][0] + "");
                       tv_num8.setText(new_game[2][1] + "");
                       tv_num9.setText(new_game[2][2] + "");
                       score+=5;
                       count+=1;
                       tv_score.setText("Score"+" "+String.valueOf(score));
                       md=MediaPlayer.create(getBaseContext(),R.raw.a1);
                       md.start();
                       check=false;
                       Calendar calendar=Calendar.getInstance();
                       String c=String.valueOf(calendar.getTime());
                       fullname=tv_username.getText().toString();
                       score123=tv_score.getText().toString();

                       game=new Game(fullname,c,score123);
                       db.insertGameData(game);
                   }else{
                       //Toast.makeText(getBaseContext(), R.string.false_tv_in_game, Toast.LENGTH_SHORT).show();
                       md=MediaPlayer.create(getBaseContext(),R.raw.b2);
                       md.start();
                       check=true;
                       v= LayoutInflater.from(getBaseContext()).inflate(R.layout.custom_toast_errornumber,null,false);
                       tv_red=v.findViewById(R.id.custom_toast_tv_red);
                       tv_red.setText(R.string.false_tv_in_game);
                       Toast toast=new Toast(getBaseContext());
                       toast.setView(v);
                       toast.setDuration(Toast.LENGTH_LONG);
                       toast.show();
                       Calendar calendar=Calendar.getInstance();
                       String c=String.valueOf(calendar.getTime());
                       fullname=tv_username.getText().toString();
                       score123=tv_score.getText().toString();
                       game=new Game(fullname,c,score123);
                       db.insertGameData(game);
                       }


                   }else {

                       v= LayoutInflater.from(getBaseContext()).inflate(R.layout.custom_toast_errornumber,null,false);
                       tv_red=v.findViewById(R.id.custom_toast_tv_red);
                       tv_red.setText("You shoud cleck on new game ");
                       Toast toast=new Toast(getBaseContext());
                       toast.setView(v);
                       toast.setDuration(Toast.LENGTH_LONG);
                       toast.show();
                       //Toast.makeText(getBaseContext(), "You shoud cleck on new game ", Toast.LENGTH_SHORT).show();
                   }

               }
           });


            btn_newgame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    et_enternum.setText("");
                    check=true;
                    new_game = new String[3][3];

                    refresh_question = Util.generteQuestion();
                    hidding_num = refresh_question.getHiddiennumber();


                    new_game = refresh_question.getData();

                    tv_num1.setText(new_game[0][0] + "");
                    tv_num2.setText(new_game[0][1] + "");
                    tv_num3.setText(new_game[0][2] + "");
                    tv_num4.setText(new_game[1][0] + "");
                    tv_num5.setText(new_game[1][1] + "");
                    tv_num6.setText(new_game[1][2] + "");
                    tv_num7.setText(new_game[2][0] + "");
                    tv_num8.setText(new_game[2][1] + "");
                    tv_num9.setText(new_game[2][2] + "");


                }
            });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }@Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sitting:
                Intent int_setting=new Intent(getBaseContext(),Activity_Settings.class);
                startActivity(int_setting);
                return true;
            case R.id.Exit:
                /*Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/
                Activity_Login.check_exist=false;
                Register_activity.check_exist=false;
                Intent intent = new Intent(getBaseContext(),Activity_Login.class);
                startActivity(intent);
                return true;
        }
        return false;
    }
}
