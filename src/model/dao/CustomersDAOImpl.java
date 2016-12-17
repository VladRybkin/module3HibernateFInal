package model.dao;

import model.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.ConnectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO<Customer> {
    private static SessionFactory sessionFactory;
    @Override
    public void create(Customer customer) {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
    }

    @Override
    public Customer get(int id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public void update(Customer customer) {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
    }

    @Override
    public String findByName(String name) {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public List<Customer> getAll() {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
        return null;
    }
}
