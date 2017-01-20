package model.dao;

import model.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by asevruk on 12/9/2016.
 */
public class ProjectDAOImpl implements ProjectDAO<Project> {
    private static SessionFactory sessionFactory;

    public ProjectDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Project project) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.save(project);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }

        }
    }

    @Override
    public Project get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, id);
        }
    }

    @Override
    public void update(Project project) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(project);
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
                Project project = session.load(Project.class, id);
                session.delete(project);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Project findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Project.class, name);
        }
    }

    @Override
    public List<Project> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Project.class).list();
        }
    }
}
