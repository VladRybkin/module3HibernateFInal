package model.dao;

import model.entities.Customer;
import model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.ConnectionUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO<Customer> {
    private static SessionFactory sessionFactory;

    public CustomersDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public Customer get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = null;
        try {
            session.beginTransaction();
            customer = (Customer) session.load(Customer.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'customerget", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return customer;
    }

    @Override
    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = null;
        try {
            session.beginTransaction();
            customer = (Customer) session.load(Customer.class, id);
            session.delete(customer);
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
    public Customer findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Customers where Customers_name = :name");
            query.setParameter("name", name).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
            return (Customer) query.uniqueResult();
        }
    }

    @Override
    public List<Customer> getAll() {
        Session session = sessionFactory.openSession();
        List<Customer> customers = new ArrayList<Customer>();
        try {
            session.beginTransaction();
            customers = session.createCriteria(Customer.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "get all fail", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return customers;
    }


}
