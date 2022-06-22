package ru.DaoClasses;

import ru.Factorys.HibernateFactory;
import ru.Models.Buyer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuyerDao {
    private HibernateFactory factory;

    public BuyerDao(HibernateFactory factory) {
        this.factory = factory;
    }

    public Buyer findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Buyer consumer = session.get(Buyer.class, id);
            consumer.getBucket();
            session.getTransaction().commit();
            return consumer;
        }
    }

    public List<Buyer> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Buyer> consumers = session.createQuery("from Buyer ").getResultList();
            session.getTransaction().commit();
            return consumers;
        }
    }


    public void saveOrUpdate(Buyer buyer) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }

    public void delete(Buyer buyer) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.delete(buyer);
            session.getTransaction().commit();
        }
    }

}
