package model.dao;


import model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;


public class DevelopersDAOImpl implements DevelopersDAO<Developer> {
    private static SessionFactory sessionFactory;
    @Override
    public void create(Developer developer) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("insert into Developer(developerName) VALUES (?)");
        session.close();

    }

    @Override
    public Developer get(int id) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Developer where e.developerId like :id");
        query.setParameter("id", id);
        return (Developer) query.uniqueResult();
    }

    @Override
    public void update(Developer developer) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("update Developer e set developerName like : e");
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("delete from Developer e where developerId like: e");
        session.close();
    }

    @Override
    public Developer findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Developer where e.developerName like : name");
        query.setParameter("name", name);
        return (Developer) query.uniqueResult();
    }

    @Override
    public List<Developer> getAll() {
        Session session =sessionFactory.getCurrentSession();
        return session.createQuery("select e from Developer e").list();
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        DevelopersDAOImpl.sessionFactory = sessionFactory;
    }
}


