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
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    @Override
    public Company get(int id) {
        Session session = sessionFactory.openSession();
        Company company = null;
        try {
            session.beginTransaction();
            company = (Company) session.load(Company.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return company;

    }

    @Override
    public void update(Company company) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Company company = null;
        try {
            session.beginTransaction();
            company = (Company) session.load(Company.class, id);
            session.delete(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'deleteById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

    }

    @Override
    public Company findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Companies where name = :name");
            query.setParameter("name", name).toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
            return (Company) query.uniqueResult();
        }
    }

    @Override
    public List<Company> getAll() {
        Session session = sessionFactory.openSession();
        List<Company> companies = new ArrayList<Company>();
        try {
            session.beginTransaction();
            companies = session.createCriteria(Company.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return companies;
    }


}
