package model.dao;

import model.entities.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import utilities.ConnectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements SkillDAO<Skill> {
    private static SessionFactory sessionFactory;
    @Override
    public void create(Skill skill) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Skill skill1=new Skill(skill.getSkillId(), skill.getSkillName());
        session.save(skill);
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
    public Skill get(int id) {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public void update(Skill skill) {
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
    public List<Skill> getAll() {
        Session session=sessionFactory.openSession();
        Transaction transaction=null;
        transaction=session.beginTransaction();

        transaction.commit();
        session.close();
        return null;
    }
}
