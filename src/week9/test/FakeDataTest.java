package org.example.test;

import org.example.models.AlbumJPA;
import org.example.models.ArtistJPA;
import org.example.repository.AlbumRepository;
import org.example.repository.ArtistRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakeDataTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArtistJPA");
    private static final ArtistRepository artistRepository = new ArtistRepository(emf);
    private static final AlbumRepository albumRepository = new AlbumRepository(emf);

    @AfterAll
    public static void tearDown() {
        artistRepository.close();
        albumRepository.close();
    }

    @Test
    @DisplayName("Create fake data")
    public void testCreateFakeData() {
        Instant start = Instant.now();

        List<ArtistJPA> artists = new ArrayList<>();

        for(int i = 1; i < 100; i++) {
            ArtistJPA artist = new ArtistJPA("Artist " + i);
            artists.add(artist);
            artistRepository.create(artist);
        }

        Random random = new Random();
        List<AlbumJPA> albums = new ArrayList<>();
        for(ArtistJPA artist : artists) {
            AlbumJPA album = new AlbumJPA(2000 + random.nextInt(31), "Album " + artist.getName(), artist.getId());
            albums.add(album);
            albumRepository.create(album);
        }

        Instant finish = Instant.now();

        System.out.println("Time elapsed: " + (finish.toEpochMilli() - start.toEpochMilli()) + " milliseconds");

        Assertions.assertEquals(99, artists.size());
        Assertions.assertEquals(99, albums.size());

    }

}
