package model.dao;


import model.entities.Company;
import model.entities.Developer;
import model.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.ConnectionUtils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DevelopersDAOImpl implements DevelopersDAO<Developer> {
    private static SessionFactory sessionFactory;
    @Override
    public void create(Developer developer) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();

    }

    @Override
    public Developer get(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }

    @Override
    public void update(Developer developer) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
    }

    @Override
    public String findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }

    @Override
    public List<Developer> getAll() {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }
}


