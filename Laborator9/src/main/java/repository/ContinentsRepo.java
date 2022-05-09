package repository;

import entity.ContinentsEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ContinentsRepo implements AbstractRepo<ContinentsEntity, Integer, String>{


    /**
     * insert the entity into the database
     * @param entity that needs to be added
     */
    @Override
    public void create(ContinentsEntity entity) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * search into the database a continent that has the specified id
     * @param id criteria
     * @return the found object
     */
    @Override
    public ContinentsEntity findById(Integer id) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<ContinentsEntity> typedQuery = em.createNamedQuery("Continent.findById", ContinentsEntity.class).setParameter("id", id);

        return typedQuery.getSingleResult();
    }

    /**
     * search into the database a continent that has the specified name
     * @param name criteria
     * @return the found object
     */
    @Override
    public ContinentsEntity findByName(String name) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<ContinentsEntity> typedQuery = em.createNamedQuery("Continent.findByName", ContinentsEntity.class).setParameter("name", name);

        return typedQuery.getSingleResult();
    }
}
