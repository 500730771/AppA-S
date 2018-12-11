package com.example.melanie.appaens.model;

import java.util.Comparator;

public class Score {
    private int buttonId;
    private int score;
    private String text;

    public Score(int buttonId, int score, String text){
        this.score = score;
        this.buttonId = buttonId;
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){this.text = text;}

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    /*Comparator for sorting the list by score*/
    public static Comparator<Score> compareScore = new Comparator<Score>() {

        public int compare(Score s1, Score s2) {

            int rollno1 = s1.getScore();
            int rollno2 = s2.getScore();

            /*For ascending order*/
            return rollno2-rollno1;

            /*For descending order*/
            //rollno2-rollno1;
        }};

}
