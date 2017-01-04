package model.dao;


import model.entities.Customer;
import model.entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class DevelopersDAOImpl implements DevelopersDAO<Developer> {
    private static SessionFactory sessionFactory;

    public DevelopersDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void create(Developer developer) {
        Session session =sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(developer);
            session.getTransaction().commit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Developer Create fail", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

    }

    @Override
    public Developer get(int id) {
        Session session = sessionFactory.openSession();
        Developer developer= null;
        try {
            session.beginTransaction();
            developer=(Developer) session.load(Developer.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return developer;
    }

    @Override
    public void update(Developer developer) {
        Session session =sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(developer);
            session.getTransaction().commit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Developer developer = null;
        try {
            session.beginTransaction();
            developer = (Developer) session.load(Developer.class, id);
            session.delete(developer);
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
    public Developer findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Developers where Developer_name = :name");
            query.setParameter("name", name).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
            return (Developer) query.uniqueResult();
        }
    }

    @Override
    public List<Developer> getAll() {
        Session session = sessionFactory.openSession();
        List<Developer> developers = new ArrayList<Developer>();
        try {
            session.beginTransaction();
            developers = session.createCriteria(Developer.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "get all fail", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return developers;

    }


}


