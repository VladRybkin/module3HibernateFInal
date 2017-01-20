package model.dao;

import model.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO<Customer> {
    private static SessionFactory sessionFactory;

    public CustomersDAOImpl(SessionFactory sessionFactory) {
    }

    public CustomersDAOImpl() {

    }

    @Override
    public void create(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            session.save(customer);
        }
    }

    @Override
    public Customer get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, id);
        }
    }

    @Override
    public boolean update(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(customer);
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
                Customer customer = session.load(Customer.class, id);
                session.delete(customer);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Customer findByName(String name) {

        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, name);
        }
    }

    @Override
    public List<Customer> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Customer.class).list();
        }
    }

}
