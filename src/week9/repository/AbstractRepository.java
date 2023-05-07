package org.example.repository;

import org.example.manager.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractRepository<T> {
    protected EntityManager entityManager;
    private final Class<T> entityClass;

    public AbstractRepository(EntityManagerFactory emf){
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }

    public void create(T entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public T findById(Long id){
        return entityManager.find(entityClass, id);
    }

    public List<T> findByName(String namePattern){
        TypedQuery<T> query = entityManager.createNamedQuery(entityClass.getSimpleName() + ".findByName", entityClass);
        query.setParameter("name", "%" + namePattern + "%");
        return query.getResultList();
    }

    public void close(){
        entityManager.close();
    }

}
