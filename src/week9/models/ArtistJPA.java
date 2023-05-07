package org.example.models;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "artists")
@NamedQuery(name = "ArtistJPA.findByName", query = "SELECT a FROM ArtistJPA a WHERE a.name LIKE :name")
public class ArtistJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public ArtistJPA() {
    }
    public ArtistJPA(String name) {
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
        return "ArtistJPA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
