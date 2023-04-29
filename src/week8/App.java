package org.example;

import org.example.DAOs.ArtistDAO;
import org.example.database.DataImporter;
import org.example.models.Artist;

public class App
{
    public static void main(String[] args) {

        DataImporter dataImporter = new DataImporter();
        //dataImporter.importData();
        Artist artist = new Artist("The Beatles");

        ArtistDAO artistDAO = new ArtistDAO();
        artistDAO.deleteArtist(artist);

    }
}