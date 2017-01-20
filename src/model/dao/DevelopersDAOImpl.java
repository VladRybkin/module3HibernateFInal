package model.dao;


import model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class DevelopersDAOImpl implements DevelopersDAO<Developer> {
    private static SessionFactory sessionFactory;

    public DevelopersDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void create(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            session.save(developer);
        }

    }

    @Override
    public Developer get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Developer.class, id);
        }

    }

    @Override
    public boolean update(Developer developer) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(developer);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }

        }

    }

    @Override
    public boolean delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Developer developer = session.load(Developer.class, id);
                session.delete(developer);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }

    }

    @Override
    public String findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Developer where developerName = :name").setParameter("name", name).toString();
        }
    }

    @Override
    public List<Developer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Developer.class).list();
        }
    }


}


