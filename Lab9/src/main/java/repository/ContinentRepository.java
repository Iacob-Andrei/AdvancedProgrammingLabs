package repository;

import entity.ContinentsEntity;
import manager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class ContinentRepository {

    public static void create(int id, String name){

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();

            ContinentsEntity newContinent = new ContinentsEntity();
            newContinent.setId(id);
            newContinent.setName(name);
            em.persist(newContinent);

            transaction.commit();
        } finally {
            if( transaction.isActive() ){
                transaction.rollback();
            }
            em.close();
        }
    }


    public static ContinentsEntity findById(int id){
        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        String query = "SELECT c FROM ContinentsEntity c WHERE c.id = :ID";

        TypedQuery<ContinentsEntity> typedQuery = em.createQuery(query, ContinentsEntity.class);
        typedQuery.setParameter("ID", id);

        try{
            return typedQuery.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }


    public static ContinentsEntity findByName(String name) {

        EntityManager em = ManagerFactory.getEntityManager().createEntityManager();
        TypedQuery<ContinentsEntity> typedQuery = em.createNamedQuery("Continent.byName", ContinentsEntity.class);
        typedQuery.setParameter(1, name);

        return typedQuery.getSingleResult();
    }
}
