package org.example.repository;

import org.example.models.GenreJPA;

import javax.persistence.EntityManagerFactory;

public class GenreRepository extends AbstractRepository<GenreJPA>{

    public GenreRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
