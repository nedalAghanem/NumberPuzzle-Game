package com.example.NumberPuzzleGame;

public class Util {

    public static Question generteQuestion(){

        String [][] x = new String[3][3];
        int startNumber = (int) (Math.random() * 10) + 1 ;
        int incStartNumber = (int) (Math.random() * 5) + 1 ;
        int stredNumber ;
        int number = -1 ;

        for (int i = 0 ; i < x.length ; i++){
            for (int j = 0 ; j < x[i].length ; j++){
                stredNumber = startNumber + incStartNumber ;

                if (i == 1 && j == 1){
                    x[i][j] = "??";
                    number = stredNumber;

                }else {

                    x[i][j] = stredNumber + "";
                }
                int random=(int) (Math.random());
                incStartNumber+= random+3;
                startNumber = stredNumber ;

            }


        }
        return new Question(x , number);

    }
}

