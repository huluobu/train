package com.carrot.train.bean;

import java.util.ArrayList;

public class Film {
    private String filmName;
    private String releaseDate;
    private ArrayList<String> actorName;
    private String filmTypeName;

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<String> getActorName() {
        return actorName;
    }

    public void setActorName(ArrayList<String> actorName) {
        this.actorName = actorName;
    }

    public String getFilmTypeName() {
        return filmTypeName;
    }

    public void setFilmTypeName(String filmTypeName) {
        this.filmTypeName = filmTypeName;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", actorName=" + actorName +
                ", filmTypeName='" + filmTypeName + '\'' +
                '}';
    }
}
