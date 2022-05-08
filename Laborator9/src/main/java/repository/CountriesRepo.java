package repository;

import entity.ContinentsEntity;
import entity.CountriesEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CountriesRepo implements AbstractRepo<CountriesEntity, Integer, String>{

    @Override
    public void create(CountriesEntity entity) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public CountriesEntity findById(Integer id) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<CountriesEntity> typedQuery = em.createNamedQuery("Countries.findById", CountriesEntity.class).setParameter("id", id);

        return typedQuery.getSingleResult();
    }

    @Override
    public CountriesEntity findByName(String name) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<CountriesEntity> typedQuery = em.createNamedQuery("Countries.findByName", CountriesEntity.class).setParameter("name", name);

        return typedQuery.getSingleResult();
    }
}
