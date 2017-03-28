package com.minorius.repository;

import com.minorius.entity.Category;
import com.minorius.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minorius on 20.03.2017.
 */

@Repository
public class ProductRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public List getAllProductByCategory(String nameOfCategory){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Category where name = :name").setParameter("name", nameOfCategory);
        List list = query.list();

        return list;

    }

    public void addProductByCategory(Product product, String name){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("select id from Category where name = :name");
        query.setParameter("name", name);
        List list = query.list();
        try {
            long id = (Long) list.get(0);
            Category category = session.load(Category.class, id);
            category.getProductList().add(product);
        }catch (Exception e){
            System.out.println(e+" Category not found ");
        }
    }
}
