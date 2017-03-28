package com.minorius.repository;

import com.minorius.entity.Category;
import com.minorius.entity.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public CategoryRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void addCategory(Category category){
        Session session = sessionFactory.getCurrentSession();
        session.save(category);

    }

    public Category getCategoryById(long id){
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM CATEGORY WHERE ID = ";
        Query query = session.createSQLQuery(sql+id).addEntity(Category.class);
        Category category = (Category) query.uniqueResult();
        return category;
    }

    public ArrayList<Category> getAllCategory(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM CATEGORY").addEntity(Category.class);

        ArrayList<Category> categoryList = new ArrayList<>();

        List list = query.list();

        for (Object category : list){
            categoryList.add((Category) category);
        }
        return categoryList;
    }
}
