package model.dao;

import model.entities.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asevruk on 12/7/2016.
 */
public class CompaniesDAOImpl implements CompaniesDAO<Company> {
    private static SessionFactory sessionFactory;
    @Override
    public void create(Company company) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
    }

    @Override
    public Company get(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }

    @Override
    public void update(Company company) {
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
    public Company findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }

    @Override
    public List<Company> getAll() {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }
}
