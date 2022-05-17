package database;
import javax.persistence.Persistence;

public class EntityManagerTool {

    public static javax.persistence.EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private EntityManagerTool(){}

    public static javax.persistence.EntityManagerFactory getEntityManager() {
        return entityManagerFactory;
    }

    public static void close(){
        entityManagerFactory.close();
    }
}
