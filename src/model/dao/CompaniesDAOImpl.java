package model.dao;

import model.entities.Company;
import model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
        session.createQuery("insert into Company(companyName) VALUES (?)");
        session.close();
    }

    @Override
    public Company get(int id) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Company where e.companyId like :id");
        query.setParameter("id", id);
        return (Company) query.uniqueResult();
    }

    @Override
    public void update(Company company) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("update Company e set companyName like : e");
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("delete from Company e where companyId like: e");
        session.close();
    }

    @Override
    public Company findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Developer where e.developerName like : name");
        query.setParameter("name", name);
        return (Company) query.uniqueResult();
    }

    @Override
    public List<Company> getAll() {
        Session session =sessionFactory.getCurrentSession();
        return session.createQuery("select e from Company e").list();
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        CompaniesDAOImpl.sessionFactory = sessionFactory;
    }
}
