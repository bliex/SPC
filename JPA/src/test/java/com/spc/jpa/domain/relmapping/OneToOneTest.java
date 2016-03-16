package com.spc.jpa.domain.relmapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spc.jpa.domain.onetoone.Cellular;
import com.spc.jpa.domain.onetoone.Person;

import org.junit.Assert;

public class OneToOneTest {
//	@Autowired
//    private EntityManagerFactory entityManagerFactory;
//    private EntityManager entityManager;
// 
//    @Test
//    public void oneToOneTest() {
//        Cellular cellular = new Cellular();
//        cellular.setNumber(521);
//        entityManager.persist(cellular);
// 
//        Person person = new Person();
//        person.setName("SPC");
//        person.setCellular(cellular);
//        entityManager.persist(person);
// 
//        Assert.assertEquals(person.getCellular().getId(), cellular.getId());
//    }
// 
//    @Before
//    public void setUp() throws Exception {
//        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//    }
// 
//    @After
//    public void after() {
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
}
