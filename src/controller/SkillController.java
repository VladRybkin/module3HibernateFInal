package controller;

import model.dao.CompaniesDAOImpl;
import model.dao.SkillDAOImpl;
import model.entities.Company;
import model.entities.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vlad on 29.12.2016.
 */
public class SkillController implements GeneralController{

    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Skill skill=new Skill();
        int id;
        String name;
        int controlValue;
        Configuration configuration = new Configuration().addAnnotatedClass(Skill.class).configure("\\resources\\HibernateConfig.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            SkillDAOImpl skillDAO=new SkillDAOImpl(sessionFactory);
            ConsoleDataInput.writeMessage("\"* * * Skill * * *\" + \"\\n\" +\n" +
                    "\"1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL COMPANIES | 5 - FIND BY NAME | 6 - GET BY ID\\\\n\"");
            controlValue=ConsoleDataInput.readInt();
            if ( controlValue==1){
                ConsoleDataInput.writeMessage("imput skill name");
                name=ConsoleDataInput.readString();
                skill.setSkillName(name);
                skillDAO.create(skill);
            }else if (controlValue==2){
                ConsoleDataInput.writeMessage("imput skill id for delete");
                id=ConsoleDataInput.readInt();
                skillDAO.delete(id);
            }else if (controlValue==3){
                ConsoleDataInput.writeMessage("impput update skill");
                id=ConsoleDataInput.readInt();
                skill.setSkillId(id);
                skillDAO.update(skill);
            } else if (controlValue==4){
                System.out.println(skillDAO.getAll());
            }else if (controlValue==5){
                ConsoleDataInput.writeMessage("imput skill name t find");
                name=ConsoleDataInput.readString();
                System.out.println(skillDAO.findByName(name));
            }else if (controlValue==6){
                ConsoleDataInput.writeMessage("imput get id");
                id=ConsoleDataInput.readInt();
                System.out.println(skillDAO.get(id));
            } else
                System.out.println("You have entered not correct value. Input 1, 2, 3, 4, 5 or 6.");

        }
    }
}
