package com.example.melanie.appaens.model;

public class Question {
    private int categorieId;
    private String question;
    private int answerClient;
    private int answerMentor;
    private String toelichting;

    public Question(int categorieId, String question){
        this.categorieId = categorieId;
        this.question = question;
        this.answerClient = 0;
        this.answerMentor = 0;
        this.toelichting = "";
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswerClient() {
        return answerClient;
    }

    public void setAnswerClient(int answerClient) {
        this.answerClient = answerClient;
    }

    public int getAnswerMentor() {
        return answerMentor;
    }

    public void setAnswerMentor(int answerMentor) {
        this.answerMentor = answerMentor;
    }

    public String getToelichting() {
        return toelichting;
    }

    public void setToelichting(String toelichting) {
        this.toelichting = toelichting;
    }
}
