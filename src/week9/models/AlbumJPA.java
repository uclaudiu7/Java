package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
@NamedQuery(name = "AlbumJPA.findByTitle", query = "SELECT a FROM AlbumJPA a WHERE a.title LIKE :title")
public class AlbumJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "release_year")
    private int release_year;

    @Column(name = "title")
    private String title;

    @Column(name = "artist_id")
    private Long artist_id;

    public AlbumJPA() {}

    public AlbumJPA(int release_year, String title, Long artist_id) {
        this.release_year = release_year;
        this.title = title;
        this.artist_id = artist_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Long artist_id) {
        this.artist_id = artist_id;
    }

    @Override
    public String toString() {
        return "AlbumJPA{" +
                "id=" + id +
                ", release_year=" + release_year +
                ", title='" + title + '\'' +
                ", artist_id=" + artist_id +
                '}';
    }

    @ManyToMany
    @JoinTable(
        name = "album_genres",
        joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<GenreJPA> genres;
}
