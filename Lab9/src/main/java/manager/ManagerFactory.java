package manager;

import javax.persistence.Persistence;

public class ManagerFactory {

    public static javax.persistence.EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private ManagerFactory(){}

    public static javax.persistence.EntityManagerFactory getEntityManager() {
        return entityManagerFactory;
    }

    public static void close(){
        entityManagerFactory.close();
    }
}
