package org.example.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    private static final PersistenceManager INSTANCE = new PersistenceManager();
    private final EntityManagerFactory emf;

    private PersistenceManager() {
        emf = Persistence.createEntityManagerFactory("ArtistJPA");
    }

    public static PersistenceManager getInstance() {
        return INSTANCE;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
    public void closeEntityManagerFactory() {
        if(emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
