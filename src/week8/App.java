package org.example;

import java.util.List;

public class App
{
    public static void main(String[] args) {
        ArtistDAO artistDAO = new ArtistDAO();
        artistDAO.addArtist("The Beatles");
        List<String> artists = artistDAO.getAllArtists();
        for (String artist : artists) {
            System.out.println(artist);
        }
    }
}
