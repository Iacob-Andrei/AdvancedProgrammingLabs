package repository;

import entity.CitiesEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class CitiesRepo implements AbstractRepo<CitiesEntity, Integer, String>{

    /**
     * insert the entity into the database
     * @param entity that needs to be added
     */
    @Override
    public void create(CitiesEntity entity) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    /**
     * search into the database a city that has the specified id
     * @param id criteria
     * @return the found object
     */
    @Override
    public CitiesEntity findById(Integer id) {

        try {
            EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
            TypedQuery<CitiesEntity> typedQuery = em.createNamedQuery("Cities.findById", CitiesEntity.class).setParameter("id", id);

            return typedQuery.getSingleResult();
        }
        catch( NoResultException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * search into the database a city that has the specified name
     * @param name criteria
     * @return the found object
     */
    @Override
    public CitiesEntity findByName(String name) {

        try {
            EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
            TypedQuery<CitiesEntity> typedQuery = em.createNamedQuery("Cities.findByName", CitiesEntity.class).setParameter("name", name);

            return typedQuery.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
