package com.example.melanie.appaens.model;

import android.media.Image;

public class Categorie {
    private String naam;
    private Image image;
    private int maxVragen;
    private int beantwoordeVragen;

    public Categorie(String naam, Image image, int maxVragen, int beantwoordeVragen){
        this.naam = naam;
        this.image = image;
        this.maxVragen = maxVragen;
        this.beantwoordeVragen = beantwoordeVragen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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
