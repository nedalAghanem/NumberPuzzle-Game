package com.example.NumberPuzzleGame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    EditText et_username,et_password;
    Button btn_login,btn_register;
    CheckBox cb_remember;
    ImageView iv_image;
    String username;
    String password;
    String fullname;
    String date;
    String user;
    String pass;
    String new_pass;
    public static boolean check_exist=true;
    boolean check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);

        et_username = findViewById(R.id.activity_login_et_username);
        et_password = findViewById(R.id.activity_login_et_password);
        btn_login = findViewById(R.id.activity_login_btn_login);
        btn_register = findViewById(R.id.activity_login_btn_register);
        cb_remember = findViewById(R.id.activity_login_cb_remember);
        iv_image = findViewById(R.id.activity_login_iv_image);
        //Intent str = getIntent();

        sp = getSharedPreferences("register", MODE_PRIVATE);
        boolean aa = sp.getBoolean("check_exist", false);
        if (aa == true) {

        } else {
           // editor.clear();
        }

        if (check_exist == false) {
            //editor.clear();
            et_username.setText("");
            et_password.setText("");
        } else {
            user = sp.getString("username", "");
            pass = sp.getString("password", "");
            new_pass = sp.getString("new_pass", "");
            if (cb_remember.isChecked()) {
                et_username.setText(user);
                if (!new_pass.equals("")) {
                    et_password.setText(new_pass);
                    password = new_pass;
                } else {
                    et_password.setText(pass);
                    password = pass;
                }
            }
        }

            btn_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (et_username.getText().toString().equals(user) && et_password.getText().toString().equals(pass)) {
                        Intent intent = new Intent(getBaseContext(), Activity_Game.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getBaseContext(), "The User Name or Password is Error", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            btn_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), Register_activity.class);
                    startActivity(intent);
                }
            });
        }
    }

