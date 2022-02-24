package com.example.NumberPuzzleGame;

import java.util.Date;

public class Game {
    private int Id;
    private String fullname;
    private String timedate;
    private String score;

    public Game() {
    }

    public Game(int id, String fullname, String timedate, String score) {
        Id = id;
        this.fullname = fullname;
        this.timedate = timedate;
        this.score = score;
    }

    public Game(String fullname, String timedate, String score) {
        this.fullname = fullname;
        this.timedate = timedate;
        this.score = score;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTimedate() {
        return timedate;
    }

    public void setTimedate(String timedate) {
        this.timedate = timedate;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}