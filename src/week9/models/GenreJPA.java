package org.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genres")
@NamedQuery(name = "GenreJPA.findByName", query = "SELECT g FROM GenreJPA g WHERE g.name LIKE :name")
public class GenreJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public GenreJPA() {}

    public GenreJPA(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GenreJPA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @ManyToMany
    @JoinTable(
            name = "album_genres",
            joinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id")
    )
    private List<AlbumJPA> albums;

}
