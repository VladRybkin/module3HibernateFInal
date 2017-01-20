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
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(skill);
            session.getTransaction().commit();
        }
    }

    @Override
    public Skill get(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Skill.class, id);
        }
    }

    @Override
    public void update(Skill skill) {
        try (Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                session.update(skill);
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
                Skill skill = session.load(Skill.class, id);
                session.delete(skill);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    public String findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
//            return session.get(Skill.class, name);
            return session.createQuery("select skillName from Skill where skillName = :name").setParameter("name", name).toString();
        }
    }


    @Override
    public List<Skill> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createCriteria(Skill.class).list();
        }
    }
}
