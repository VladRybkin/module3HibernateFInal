package view;

import model.entities.*;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;

/**
 * Created by Vlad on 20.01.2017.
 */
public class HibernateUltill {
        private static  SessionFactory sessionFactory;
        static {
            try {
                org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration()
                        .configure("\\resources\\HibernateConfig.cfg.xml")
                        .addAnnotatedClass(Company.class).addAnnotatedClass(Customer.class).addAnnotatedClass(Developer.class)
                        .addAnnotatedClass(Project.class).addAnnotatedClass(Skill.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed.» + ex");
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }
}

