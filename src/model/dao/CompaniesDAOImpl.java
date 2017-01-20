package model.dao;

import model.entities.Company;
import model.entities.Developer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by asevruk on 12/7/2016.
 */
public class CompaniesDAOImpl implements CompaniesDAO<Company> {
    private static SessionFactory sessionFactory;

    public CompaniesDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void create(Company company) {
        try (Session session = sessionFactory.openSession()) {
            session.save(company);
        }
    }

    @Override
    public Company get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Company.class, id);
        }
    }

    @Override
    public boolean update(Company company) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(company);
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
                Company company = session.load(Company.class, id);
                session.delete(company);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Company findByName(String name) {

        try (Session session = sessionFactory.openSession()) {
            return session.get(Company.class, name);
        }
    }

    @Override
    public List<Company> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Company.class).list();
        }
    }

}
