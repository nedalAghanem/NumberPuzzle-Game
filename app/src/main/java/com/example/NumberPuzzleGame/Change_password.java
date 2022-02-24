package com.example.NumberPuzzleGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change_password extends AppCompatActivity {
    String pass;
    String oldpassword;
    String newpassword;
    EditText et_old_password,et_new_password;
    Button btn_save_change_password;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        et_old_password=findViewById(R.id.activity_settings_et_old_password);
        et_new_password=findViewById(R.id.activity_settings_et_new_password);

        btn_save_change_password=findViewById(R.id.activity_settings_btn_save_change_password);

        sp= getSharedPreferences("register",MODE_PRIVATE);

        pass = sp.getString("password","null");

        oldpassword = et_old_password.getText().toString();
        newpassword = et_new_password.getText().toString();

        btn_save_change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pass.equals(oldpassword)) {
                    pass = newpassword;
                    editor.putString("password", pass);
                    editor.apply();
                }else if (!pass.equals(oldpassword)){
                    Toast.makeText(Change_password.this, "The password is not old password", Toast.LENGTH_SHORT).show();
                }
                Intent intent =new Intent(getBaseContext(),Activity_Login.class);
                startActivity(intent);

            }
        });
    }
}
