package ru.DaoClasses;

import ru.Factorys.HibernateFactory;
import ru.Models.Bucket;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BucketDao {
    private HibernateFactory factory;

    public BucketDao(HibernateFactory factory) {
        this.factory = factory;
    }

    public Bucket findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Bucket bucket = session.get(Bucket.class, id);
            session.getTransaction().commit();
            return bucket;
        }
    }

    public List<Bucket> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Bucket> orders = session.createQuery("from Bucket ").getResultList();
            session.getTransaction().commit();
            return orders;
        }
    }

    public void delete(Bucket bucket) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.delete(bucket);
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Bucket bucket) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(bucket);
            session.getTransaction().commit();
        }
    }

    public List<Bucket> getBuyerBucket(Long buyer_id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Bucket> result = session.createNamedQuery("byBuyer", Bucket.class).setParameter("id", buyer_id).getResultList();
            session.getTransaction().commit();
            return result;
        }
    }

    public List<Bucket> getBucketByProduct(Long product_id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Bucket> result = session.createNamedQuery("byProduct", Bucket.class).setParameter("id", product_id).getResultList();
            session.getTransaction().commit();
            return result;
        }
    }
}
