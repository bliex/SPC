package com.spc.jpa.domain.relmapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class OneToManyAndManyToOneTest {
	
//	@Autowired
//    private EntityManagerFactory entityManagerFactory;
//    private EntityManager entityManager;
// 
//    @Test
//    public void oneToManyAndManyToOneTest() {
//        Order order = new Order();
//        order.setOrderName("test order");
//        order.setPrice(123);
//        order.setNote("test note");
//        User user = new User();
//        user.setUsername("SPC");
//        user.setNickname("SPC");
//        user.setAddress("seoul");
// 
//        // relationship
//        user.addOrder(order);
//        order.setUser(user);
//        entityManager.persist(user);
// 
//        Assert.assertEquals(user.getOrders().get(0).getOrderId(), order.getOrderId());
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
