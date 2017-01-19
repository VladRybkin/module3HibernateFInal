package controller;

import model.dao.CompaniesDAOImpl;
import model.dao.DevelopersDAOImpl;
import model.entities.Company;
import model.entities.Developer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vlad on 29.12.2016.
 */
public class DeveloperController implements GeneralController {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Developer developer=new Developer();
        int id;
        String name;
        int controlValue;
        Configuration configuration = new Configuration().addAnnotatedClass(Developer.class).configure("resources\\HibernateConfig.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            DevelopersDAOImpl developersDAO = new DevelopersDAOImpl(sessionFactory);
            ConsoleDataInput.writeMessage("\"* * * DEVELOPER * * *\" + \"\\n\" +\n" +
                    "\"1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL COMPANIES | 5 - FIND BY NAME | 6 - GET BY ID\\\\n\"");
            controlValue=ConsoleDataInput.readInt();
            if ( controlValue==1){
                ConsoleDataInput.writeMessage("imput developer name");
                name=ConsoleDataInput.readString();
                developer.setDeveloperName(name);
                developersDAO.create(developer);
            }else if (controlValue==2){
                ConsoleDataInput.writeMessage("imput developer id for delete");
                id=ConsoleDataInput.readInt();
                developersDAO.delete(id);
            }else if (controlValue==3){
                ConsoleDataInput.writeMessage("impput update developer");
                id=ConsoleDataInput.readInt();
                developer.setDeveloperId(id);
                developersDAO.update(developer);
            } else if (controlValue==4){
                System.out.println(developersDAO.getAll());
            }else if (controlValue==5){
                ConsoleDataInput.writeMessage("imput developer name t find");
                name=ConsoleDataInput.readString();
                System.out.println(developersDAO.findByName(name));
            }else if (controlValue==6){
                ConsoleDataInput.writeMessage("imput get id");
                id=ConsoleDataInput.readInt();
                System.out.println(developersDAO.get(id));
            } else
                System.out.println("You have entered not correct value. Input 1, 2, 3, 4, 5 or 6.");

        }
    }
}
