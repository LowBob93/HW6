package ru.Factorys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateFactory {

        private SessionFactory factory;

        public HibernateFactory() {
            factory = new Configuration().configure().buildSessionFactory();
        }

        public Session getSession() {
            return factory.getCurrentSession();
        }
    }
