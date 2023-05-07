package org.example;

import org.example.repository.AlbumRepository;
import org.example.repository.ArtistRepository;
import org.example.repository.GenreRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArtistJPA");
        ArtistRepository artistRepository = new ArtistRepository(emf);
        GenreRepository genreRepository = new GenreRepository(emf);
        AlbumRepository albumRepository = new AlbumRepository(emf);

        System.out.println(albumRepository.findById(5L));
        albumRepository.close();
    }
}