package model.dao;

import model.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utilities.ConnectionUtils;

import javax.swing.*;
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

    public ProjectDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void create(Project project) {
        Session session =sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Create CustomerFail", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }


    }

    @Override
    public Project get(int id) {
        Session session =sessionFactory.getCurrentSession();
        Project project= null;
        try {
            session.beginTransaction();
            project=(Project) session.load(Project.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return project;
    }

    @Override
    public void update(Project project) {
        Session session =sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(project);
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
    public Project findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Project where Project_name = :name");
            query.setParameter("name", name).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
            return (Project) query.uniqueResult();
        }
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = null;
        try {
            session.beginTransaction();
            project = (Project) session.load(Project.class, id);
            session.delete(project);
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
    public List<Project> getAll() {
        Session session = sessionFactory.openSession();
        List<Project> projects = new ArrayList<Project>();
        try {
            session.beginTransaction();
            projects = session.createCriteria(Project.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "get all fail", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return projects;
    }
}
