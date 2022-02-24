package com.example.NumberPuzzleGame;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Register_activity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    EditText et_fullname,et_emailaddress,et_username,et_pass,et_re_pass;
    Spinner sp_country;
    EditText et_date;
    Calendar calendar;
    int year, month, day;
    RadioButton rb_male,rb_female;
    ImageView iv_image;
    Button btn_save;
    public static boolean check_exist=true;

    public static final int IMGE_REC_CODE=123;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        et_fullname =findViewById(R.id.Regester_activity_et_full_Name);
        et_emailaddress =findViewById(R.id.Regester_activity_et_email_address);
        et_username =findViewById(R.id.Regester_activity_et_user_name);
        et_pass =findViewById(R.id.Regester_activity_et_pass);
        et_re_pass =findViewById(R.id.Regester_activity_et_re_pass);
        sp_country =findViewById(R.id.Regester_activity_sp_country);
        et_date =findViewById(R.id.Regester_activity_et_date);
        rb_male =findViewById(R.id.Regester_activity_rb_male);
        rb_female =findViewById(R.id.Regester_activity_rb_female);
        iv_image=findViewById(R.id.Regester_activity_iv_image);
        btn_save=findViewById(R.id.Regester_activity_btn_save);

        calendar = Calendar.getInstance();
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        day = calendar.get(calendar.DAY_OF_MONTH);
        month+=1;
        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDiaLog();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String image=uri.toString();
                String fullname=et_fullname.getText().toString();
                String emailaddress=et_emailaddress.getText().toString();
                String username=et_username.getText().toString();
                String pass=et_pass.getText().toString();
                String re_pass=et_re_pass.getText().toString();
                String country=sp_country.getSelectedItem().toString();
                String date="["+et_date.getText().toString()+"]";
                String password ="";
                if (pass.equals(re_pass)){
                    password=pass;
                }else{
                    password="pass does not match";
                    Toast.makeText(getBaseContext(), "pass does not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                String Gender="";
                if (rb_male.isChecked()){
                    Gender="male";
                }else{
                    Gender="female";
                }
                //sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                 sp= getSharedPreferences("register",MODE_PRIVATE);
                 editor = sp.edit();
                //editor.putString("image" ,image);
                 editor.putString("fullname" ,fullname);
                //editor.putString("emailaddress" ,emailaddress);
                 editor.putString("username", username);
                 editor.putString("password", password);
                //editor.putString("Gender" ,Gender);
                // editor.putString("country" ,country);
                 editor.putString("date" ,date);
                 editor.putBoolean("check_exist" ,check_exist);
                 editor.apply();
                if (check_exist==false){
                    editor.clear();
                    Toast.makeText(Register_activity.this, "check_exist==false", Toast.LENGTH_SHORT).show();
                }


                Intent int_Avt_log = new Intent(getBaseContext(), Activity_Login.class);
               /*  int_Avt_log.putExtra("username",username);
                int_Avt_log.putExtra("password",password);
                int_Avt_log.putExtra("fullname",fullname);
                int_Avt_log.putExtra("date",date);*/
                //int_Avt_log.putExtra("image",image);

                startActivity(int_Avt_log);


            }
        });




        iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent,IMGE_REC_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMGE_REC_CODE) {
            uri = data.getData();
            iv_image.setImageURI(uri);
        }
    }
    private void showDiaLog() {
        DatePickerDialog datePickerDialog=new DatePickerDialog(Register_activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+=1;
                et_date.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },year,month,day);
        datePickerDialog.show();
    }
}
