package com.example.melanie.appaens.model;

public class Informatie {
    private int kleur;
    private String shortText;
    private String mateSpanningText;
    private String richtingSpanningText;

    public Informatie(int kleur, String shortText, String mateSpanningText, String richtingSpanningText){
        this.kleur = kleur;
        this.shortText = shortText;
        this.mateSpanningText = mateSpanningText;
        this.richtingSpanningText = richtingSpanningText;
    }

    public int getKleur() {
        return kleur;
    }

    public void setKleur(int kleur) {
        this.kleur = kleur;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getMateSpanningText() {
        return mateSpanningText;
    }

    public void setMateSpanningText(String mateSpanningText) {
        this.mateSpanningText = mateSpanningText;
    }

    public String getRichtingSpanningText() {
        return mateSpanningText;
    }

    public void setRichtingSpanningText(String richtingSpanningText) {
        this.richtingSpanningText = richtingSpanningText;
    }
}
