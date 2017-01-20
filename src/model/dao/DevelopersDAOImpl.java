package model.dao;


import model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class DevelopersDAOImpl implements DevelopersDAO<Developer> {
    private static SessionFactory sessionFactory;

    public DevelopersDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.save(developer);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }

        }

    }

    @Override
    public Developer get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Developer.class, id);
        }

    }

    @Override
    public void update(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(developer);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }

        }

    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Developer developer = session.load(Developer.class, id);
                session.delete(developer);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }

    }

    @Override
    public Developer findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Developer.class, name);
        }
    }

    @Override
    public List<Developer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Developer.class).list();
        }
    }


}


