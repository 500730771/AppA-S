package com.example.melanie.appaens.model;

import android.provider.ContactsContract;

import java.util.Date;

public class Observatie {

    private String client;
    private String observator;
    private String datum;
    private String email;
    private boolean video;

//    public ContactsContract.CommonDataKinds.Email getEmail() {
//        return email;
//    }
//
//    public void setEmail(ContactsContract.CommonDataKinds.Email email) {
//        this.email = email;
//    }

    public Observatie(String client, String observator, String datum, boolean video, String email
//            , ContactsContract.CommonDataKinds.Email email)
    ){
        this.client = client;
        this.observator = observator;
        this.datum = datum;
        this.video = video;
        this.email = email;
    }

    public String getEmail(){return email;}
    public void setEmail(){this.email=email;}

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getObservator() {
        return observator;
    }

    public void setObservator(String observator) {
        this.observator = observator;
    }
}
