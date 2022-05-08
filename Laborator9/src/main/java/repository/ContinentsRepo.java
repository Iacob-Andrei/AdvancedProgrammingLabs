package repository;

import entity.ContinentsEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ContinentsRepo implements AbstractRepo<ContinentsEntity, Integer, String>{

    @Override
    public void create(ContinentsEntity entity) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public ContinentsEntity findById(Integer id) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<ContinentsEntity> typedQuery = em.createNamedQuery("Continent.findById", ContinentsEntity.class).setParameter("id", id);

        return typedQuery.getSingleResult();
    }

    @Override
    public ContinentsEntity findByName(String name) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<ContinentsEntity> typedQuery = em.createNamedQuery("Continent.findByName", ContinentsEntity.class).setParameter("name", name);
        typedQuery.setParameter(1, name);

        return typedQuery.getSingleResult();
    }
}
