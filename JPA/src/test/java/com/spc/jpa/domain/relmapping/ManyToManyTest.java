package com.spc.jpa.domain.relmapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ManyToManyTest {
//	@Autowired
//    private EntityManagerFactory entityManagerFactory;
//    private EntityManager entityManager;
// 
//    @Test
//    public void manyToManyTest() {
// 
//        Category category = new Category();
//        category.setName("IT");
//        entityManager.persist(category);
// 
//        Product product = new Product();
//        product.setName("MacBook");
//        product.setPrice(1000);
// 
//        product.addCategory(category);
//        category.addProduct(product);
//        entityManager.persist(product);
// 
//        Assert.assertEquals(product.getProductId(), category.getProducts().get(0).getProductId());
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
