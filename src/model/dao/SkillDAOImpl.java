package model.dao;

import model.entities.Developer;
import model.entities.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import utilities.ConnectionUtils;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements SkillDAO<Skill> {
    private static SessionFactory sessionFactory;

    public SkillDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void create(Skill skill) {
        Session session =sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(skill);
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
    public Skill findByName(String name) {
        Session session = sessionFactory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Skills where skill_name = :name");
            query.setParameter("name", name).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
            return (Skill) query.uniqueResult();
        }
    }

    @Override
    public Skill get(int id) {
        Session session = sessionFactory.openSession();
        Skill skill= null;
        try {
            session.beginTransaction();
            skill=(Skill) session.load(Skill.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return skill;
    }

    @Override
    public void update(Skill skill) {
        Session session =sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(skill);
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
        Skill skill = null;
        try {
            session.beginTransaction();
            skill= (Skill) session.load(Skill.class, id);
            session.delete(skill);
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
    public List<Skill> getAll() {
        Session session = sessionFactory.openSession();
        List<Skill> skills = new ArrayList<Skill>();
        try {
            session.beginTransaction();
            skills = session.createCriteria(Skill.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "get all fail", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }

        return skills;
    }
}
