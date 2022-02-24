package com.example.NumberPuzzleGame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper{
    public static final String DB_NAME ="games_dp";
    public static final int VERSION =1;
    public static final String TP_NAME ="game_details";
    public static final String COL_GAME_ID="game_id";
    public static final String COL_FULL_NAME="fullname";
    public static final String COL_TIME_DATE="timedate";
    public static final String COL_SCORE="score";
    Adapter adapter;

    public MyDatabase(Context context) {
        super(context, DB_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table "+ TP_NAME + " (" + COL_GAME_ID +" integer primary key autoincrement," + COL_FULL_NAME +" text ," + COL_TIME_DATE+" text ," + COL_SCORE +" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists game_details");
        onCreate(db);

    }
    public boolean insertGameData(Game game){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_FULL_NAME,game.getFullname());
        values.put(COL_TIME_DATE,game.getTimedate());
        values.put(COL_SCORE,game.getScore());
        long result=db.insert(TP_NAME,null,values);
        return result != -1;
    }
    public boolean deleteGameData(){
        SQLiteDatabase db=getWritableDatabase();
            db.execSQL("delete FROM "+TP_NAME);
            return true;
    }
    public ArrayList<Game>  deleteAllGameData(){
        ArrayList<Game> games =new ArrayList<>();
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor= db.rawQuery("delete FROM "+TP_NAME,null);

        if (cursor != null && cursor.moveToFirst()){
            do {

                int id=cursor.getInt(cursor.getColumnIndex(COL_GAME_ID));
                String fullname=cursor.getString(cursor.getColumnIndex(COL_FULL_NAME));
                String datetime=cursor.getString(cursor.getColumnIndex(COL_TIME_DATE));
                String score=cursor.getString(cursor.getColumnIndex(COL_SCORE));
                Game game=new Game(id,fullname,datetime,score);
                games.add(game);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return games;
    }
    public ArrayList<Game> getAllGames(){
        ArrayList<Game> games =new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM "+TP_NAME,null);

        if (cursor != null && cursor.moveToFirst()){
            do {

                int id=cursor.getInt(cursor.getColumnIndex(COL_GAME_ID));
                String fullname=cursor.getString(cursor.getColumnIndex(COL_FULL_NAME));
                String datetime=cursor.getString(cursor.getColumnIndex(COL_TIME_DATE));
                String score=cursor.getString(cursor.getColumnIndex(COL_SCORE));
                Game game=new Game(id,fullname,datetime,score);
                games.add(game);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return games;
    }


}
