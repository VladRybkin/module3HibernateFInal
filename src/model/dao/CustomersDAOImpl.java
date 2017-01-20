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
        this.sessionFactory = sessionFactory;
    }

    public CustomersDAOImpl() {

    }

    @Override
    public void create(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.save(customer);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }

        }
    }

    @Override
    public Customer get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Customer.class, id);
        }
    }

    @Override
    public void update(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(customer);
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
                Customer customer = session.load(Customer.class, id);
                session.delete(customer);
                session.getTransaction().commit();
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
