package com.example.melanie.appaens.model;

import android.media.Image;
import android.widget.ImageView;

public class Categorie {
    private int id;
    private String naam;
    private int image;
    private int maxVragen;
    private int beantwoordeVragen;

    public Categorie(int id, String naam, int image, int maxVragen, int beantwoordeVragen){
        this.id = id;
        this.naam = naam;
        this.image = image;
        this.maxVragen = maxVragen;
        this.beantwoordeVragen = beantwoordeVragen;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getMaxVragen() {
        return maxVragen;
    }

    public void setMaxVragen(int maxVragen) {
        this.maxVragen = maxVragen;
    }

    public int getBeantwoordeVragen() {
        return beantwoordeVragen;
    }

    public void setBeantwoordeVragen(int beantwoordeVragen) {
        this.beantwoordeVragen = beantwoordeVragen;
    }
}
