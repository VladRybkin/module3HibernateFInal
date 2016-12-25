package model.dao;

import model.entities.Customer;
import model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.ConnectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO<Customer> {
    private static SessionFactory sessionFactory;
    @Override
    public void create(Customer customer) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("insert into e Customer(e.customerName) VALUES (?)");

    }

    @Override
    public Customer get(int id) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Customer where e.customerId like :id");
        query.setParameter("id", id);
        return (Customer) query.uniqueResult();
    }

    @Override
    public void update(Customer customer) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("update skills set skill_name = ?").list();

    }

    @Override
    public void delete(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("update Customer e set customerName like : e").executeUpdate();

    }

    @Override
    public Customer findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Customer where e.customerName like : name");
        query.setParameter("name", name);
        return (Customer) query.uniqueResult();
    }

    @Override
    public List<Customer> getAll() {
        Session session =sessionFactory.getCurrentSession();
        return session.createQuery("select e from Customer e").list();
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        CustomersDAOImpl.sessionFactory = sessionFactory;
    }
}
