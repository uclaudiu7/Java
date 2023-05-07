package org.example.repository;

import org.example.models.AlbumJPA;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository extends AbstractRepository<AlbumJPA> {
    public AlbumRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public List<AlbumJPA> findByTitle(String titlePattern) {
        TypedQuery<AlbumJPA> query = getEntityManager().createNamedQuery("AlbumJPA.findByTitle", AlbumJPA.class);
        query.setParameter("title", "%" + titlePattern + "%");
        return query.getResultList();
    }
}
