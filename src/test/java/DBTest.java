/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entity.TEmployee;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import organizerpro.pl.DBManager;

/**
 *
 * @author Sluski_Laptop
 */
public class DBTest {
    
    public DBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   
//    @Test
//    public void addEmployess() {
//        TEmployee newEmployee = new TEmployee();
//        newEmployee.setFirstName("Jan");
//        newEmployee.setLastName("Kowalski");
//        newEmployee.setEmail("jan.kowalski@gmail.com");
//        newEmployee.setPassword("qwerty");
//        newEmployee.setReward(4000);
//        newEmployee.setPermissions(2);
//
//        EntityManager entityManager = DBManager.createInstance().getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(newEmployee);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
}
