package com.example.NumberPuzzleGame;

public class Question {
    private String[][] data;
    private int hiddiennumber;

    public Question(String[][] data, int hiddiennumber) {
        this.data = data;
        this.hiddiennumber = hiddiennumber;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public int getHiddiennumber() {
        return hiddiennumber;
    }

    public void setHiddiennumber(int hiddiennumber) {
        this.hiddiennumber = hiddiennumber;
    }
}