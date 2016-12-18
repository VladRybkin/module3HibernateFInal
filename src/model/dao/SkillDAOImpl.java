package model.dao;

import model.entities.Developer;
import model.entities.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import utilities.ConnectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements SkillDAO<Skill> {
    private static SessionFactory sessionFactory;
    @Override
    public void create(Skill skill) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("insert into Skill (skillName) VALUES (?)");
        session.close();
    }

    @Override
    public Skill findByName(String name) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Skill where e.skillName like : name");
        query.setParameter("name", name);
        return (Skill) query.uniqueResult();
    }

    @Override
    public Skill get(int id) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("select e from Skill where e.skillId like :id");
        query.setParameter("id", id);
        return (Skill) query.uniqueResult();
    }

    @Override
    public void update(Skill skill) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("update Skill e set skillName like : e");
        session.close();
    }

    @Override
    public void delete(int id) {
        Session session =sessionFactory.getCurrentSession();
        session.createQuery("delete from Skill e where skillId like: e");
        session.close();
    }

    @Override
    public List<Skill> getAll() {
        Session session =sessionFactory.getCurrentSession();
        return session.createQuery("select e from Skill e").list();
    }
}
