package com.example.melanie.appaens.model;

import java.io.Serializable;

public class Informatie implements Serializable {
    private int id;
    private String shortText;
    private String mateSpanningText;
    private String richtingSpanningText;

    public Informatie (int id, String shortText, String mateSpanningText, String richtingSpanningText){
        this.id = id;
        this.shortText = shortText;
        this.mateSpanningText = mateSpanningText;
        this.richtingSpanningText = richtingSpanningText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
