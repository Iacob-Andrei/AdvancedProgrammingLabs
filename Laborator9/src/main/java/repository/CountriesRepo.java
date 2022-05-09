package repository;

import entity.ContinentsEntity;
import entity.CountriesEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CountriesRepo implements AbstractRepo<CountriesEntity, Integer, String>{

    /**
     * insert the entity into the database
     * @param entity that needs to be added
     */
    @Override
    public void create(CountriesEntity entity) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * search into the database a country that has the specified id
     * @param id criteria
     * @return the found object
     */
    @Override
    public CountriesEntity findById(Integer id) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<CountriesEntity> typedQuery = em.createNamedQuery("Countries.findById", CountriesEntity.class).setParameter("id", id);

        return typedQuery.getSingleResult();
    }

    /**
     * search into the database a country that has the specified name
     * @param name criteria
     * @return the found object
     */
    @Override
    public CountriesEntity findByName(String name) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<CountriesEntity> typedQuery = em.createNamedQuery("Countries.findByName", CountriesEntity.class).setParameter("name", name);

        return typedQuery.getSingleResult();
    }
}
