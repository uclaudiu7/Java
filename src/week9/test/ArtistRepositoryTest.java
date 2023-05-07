package org.example.test;

import org.example.models.ArtistJPA;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.example.repository.ArtistRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtistRepositoryTest {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArtistJPA");
    private static ArtistRepository artistRepository;

    @BeforeAll
    public static void setup() {
        artistRepository = new ArtistRepository(emf);
    }

    @AfterAll
    public static void tearDown() {
        artistRepository.close();
    }

    @Test
    public void testCreateArtist() {
        ArtistJPA artist = new ArtistJPA("Test Artist1");
        artistRepository.create(artist);
        ArtistJPA artist2 = artistRepository.findById(artist.getId());
        assertEquals(artist, artist2);
    }

    @Test
    public void testFindArtistById() {
        ArtistJPA artist1 = new ArtistJPA("Test Artist2");
        artistRepository.create(artist1);
        ArtistJPA artist2 = new ArtistJPA("Test Artist3");
        artistRepository.create(artist2);
        ArtistJPA persistedArtist = artistRepository.findById(artist1.getId());
        ArtistJPA persistedArtist2 = artistRepository.findById(artist2.getId());
        assertEquals(artist1, persistedArtist);
        assertEquals(artist2, persistedArtist2);
    }

    @Test
    public void testFindArtistByName() {
        ArtistJPA artist1 = new ArtistJPA("Claudiu 1");
        ArtistJPA artist2 = new ArtistJPA("Claudiu 2");
        ArtistJPA artist3 = new ArtistJPA("Claudiu 3");

        artistRepository.create(artist1);
        artistRepository.create(artist2);
        artistRepository.create(artist3);



        List<ArtistJPA> artists = artistRepository.findByName("Claudiu");
        assertEquals(3, artists.size());
        for(ArtistJPA artist : artists) {
            assertEquals("Claudiu", artist.getName().substring(0, 7));
        }
    }
}
