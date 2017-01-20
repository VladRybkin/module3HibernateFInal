package model.dao;

import model.entities.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements SkillDAO<Skill> {
    private static SessionFactory sessionFactory;

    public SkillDAOImpl(SessionFactory sessionFactory) {
    }

    @Override
    public void create(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            session.save(skill);
        }
    }

    @Override
    public Skill get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Skill.class, id);
        }
    }

    @Override
    public boolean update(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(skill);
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
                Skill skill = session.load(Skill.class, id);
                session.delete(skill);
                session.getTransaction().commit();
                return true;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    public Skill findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Skill.class, name);
        }
    }


    @Override
    public List<Skill> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Skill.class).list();
        }
    }
}
