package model.dao;

import model.entities.Company;
import model.entities.Customer;
import model.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.ConnectionUtils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asevruk on 12/9/2016.
 */
public class ProjectDAOImpl implements ProjectDAO<Project> {
    private static SessionFactory sessionFactory;

    @Override
    public void create(Project project) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();

    }

    @Override
    public Project get(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }

    @Override
    public void update(Project project) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
    }

    @Override
    public String findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }

    @Override
    public void delete(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();

    }

    @Override
    public List<Project> getAll() {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("").list();
        session.close();
        return null;
    }
}
