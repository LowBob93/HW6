package ru.DaoClasses;


import ru.Factorys.HibernateFactory;
import ru.Models.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    private HibernateFactory factory;

    public ProductDao(HibernateFactory factory) {
        this.factory = factory;
    }

    public Product findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product ").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void delete(Product product) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Product product) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }


}
