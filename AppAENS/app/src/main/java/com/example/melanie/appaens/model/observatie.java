package com.example.melanie.appaens.model;

import java.util.Date;

public class observatie {

    private String client;
    private String observator;
    private Date datum;
    private boolean video;

    observatie(String client, String observator, Date datum, boolean video){
        this.client = client;
        this.observator = observator;
        this.datum = datum;
        this.video = video;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
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
