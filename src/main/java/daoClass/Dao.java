package daoClass;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import organizerpro.pl.DBManager;
import organizerpro.pl.QueryFactory;
import organizerpro.pl.WhereArgs;

public class Dao<AnyType> {
    private EntityManager entityManager;
    
    public void addObject(AnyType objectToAdd){
        entityManager = DBManager.createInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(objectToAdd);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public List<AnyType> findObject(String classToFind, List<WhereArgs> argsList){
        QueryFactory qf = new QueryFactory(classToFind);
        List<AnyType> foundObjects;
        entityManager = DBManager.createInstance().getEntityManager();
        Query query = entityManager.createQuery(qf.createQueryToFindMany(argsList));
        foundObjects = query.getResultList();
        return foundObjects;
    }
    
    public List<AnyType> findOneObject(String classToFind, WhereArgs objectToFind){
        QueryFactory qf = new QueryFactory(classToFind);
        List<AnyType> foundObjects;
        entityManager = DBManager.createInstance().getEntityManager();
        Query query = entityManager.createQuery(qf.createQueryToFindOne(objectToFind));
        foundObjects = query.getResultList();
        return foundObjects;
    }
    
    public List<AnyType> returnAllObjects(String classToFind){
        entityManager = DBManager.createInstance().getEntityManager();
        Query query = entityManager.createQuery("select e from " + classToFind + " e"); 
        query.setHint("javax.persistence.cache.storeMode", "REFRESH");
        return query.getResultList();
    }
    
    public void removeObject(AnyType entityName, Long idRemove){
        entityManager = DBManager.createInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(entityName.getClass(), idRemove));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void updateObject (AnyType objectToUpdate){
        entityManager = DBManager.createInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(objectToUpdate);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}