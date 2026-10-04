package com.bookmyshow.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "Movies",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_movie_title",
                columnNames = {"title"}
        )
)
public class Movie {
    public long getId() {
        return id;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getLanguge() {
        return languge;
    }

    public void setLanguge(String languge) {
        this.languge = languge;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterurl() {
        return posterurl;
    }

    public void setPosterurl(String posterurl) {
        this.posterurl = posterurl;
    }

    public String getTrailerurl() {
        return trailerurl;
    }

    public void setTrailerurl(String trailerurl) {
        this.trailerurl = trailerurl;
    }

    public boolean isActivate() {
        return activate;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String languge;
    private int duration;

    public Movie(String title, String languge, int duration, String certificate, String description, String posterurl, String trailerurl, boolean activate) {
        this.title = title;
        this.languge = languge;
        this.duration = duration;
        this.certificate = certificate;
        this.description = description;
        this.posterurl = posterurl;
        this.trailerurl = trailerurl;
        this.activate = activate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    private String genre;
    private String certificate;
    private String description;
    private String posterurl;
    private String trailerurl;
    private boolean activate = true;

}
