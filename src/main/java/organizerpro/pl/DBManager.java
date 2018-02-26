package organizerpro.pl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {
    private static DBManager instance;
    private static EntityManagerFactory entityManagerFactory;
    
    private DBManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sluski_OptimalizerPro");
    }
    
    public static DBManager createInstance(){
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }
    
    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
