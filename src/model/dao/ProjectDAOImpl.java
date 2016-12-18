package model.dao;

import model.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
        session.createQuery("insert into Project(projectName) VALUES (?)");
        session.close();

    }

    @Override
    public Project get(int id) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Project where e.developerId like :id");
        query.setParameter("id", id);
        return (Project) query.uniqueResult();
    }

    @Override
    public void update(Project project) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("update Project e set projectName like : e");
        session.close();
    }

    @Override
    public Project findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Project where e.projectName like : name");
        query.setParameter("name", name);
        return (Project) query.uniqueResult();
    }

    @Override
    public void delete(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("delete from Project e where projectId like: e");
        session.close();

    }

    @Override
    public List<Project> getAll() {
        Session session =sessionFactory.getCurrentSession();
        return session.createQuery("select e from Project e").list();
    }
}
