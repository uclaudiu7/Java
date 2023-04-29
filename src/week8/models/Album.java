package org.example.models;

import java.util.List;

public class Album {
    private int id;
    private int releaseYear;
    private String title;
    private Artist artist;
    private List<Genre> genres;

    public Album(int releaseYear, String title, Artist artist, List<Genre> genres) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres = genres;
    }

    public void setId(int id) {this.id = id; }
    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() { return artist; }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
