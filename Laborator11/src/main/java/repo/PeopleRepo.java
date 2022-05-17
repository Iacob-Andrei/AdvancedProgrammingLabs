package repo;

import database.EntityManagerTool;
import entity.People;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class PeopleRepo {

    public static List<People> findAll(){
        EntityManager em = EntityManagerTool.getEntityManager().createEntityManager();
        String query = "SELECT c FROM People c";

        TypedQuery<People> typedQuery = em.createQuery(query, People.class);

        try{
            return typedQuery.getResultList();
        } catch (NoResultException e){
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }
}
