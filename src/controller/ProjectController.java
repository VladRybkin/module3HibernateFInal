package controller;

import model.dao.CompaniesDAOImpl;
import model.dao.ProjectDAOImpl;
import model.entities.Company;
import model.entities.Project;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vlad on 29.12.2016.
 */
public class ProjectController implements GeneralController {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Project project=new Project();
        int id;
        String name;
        int controlValue;
        Configuration configuration = new Configuration().addAnnotatedClass(Project.class).configure("resources\\HibernateConfig.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {


            ProjectDAOImpl projectDAO=new ProjectDAOImpl(sessionFactory);
            ConsoleDataInput.writeMessage("\"* * * PROJECT * * *\" + \"\\n\" +\n" +
                    "\"1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL COMPANIES | 5 - FIND BY NAME | 6 - GET BY ID\\\\n\"");
            controlValue=ConsoleDataInput.readInt();
            if ( controlValue==1){
                ConsoleDataInput.writeMessage("imput PROJECT name");
                name=ConsoleDataInput.readString();
                project.setProjectName(name);
                projectDAO.create(project);
            }else if (controlValue==2){
                ConsoleDataInput.writeMessage("imput project id for delete");
                id=ConsoleDataInput.readInt();
                projectDAO.delete(id);
            }else if (controlValue==3){
                ConsoleDataInput.writeMessage("impput update project");
                id=ConsoleDataInput.readInt();
                project.setProjectId(id);
                projectDAO.update(project);
            } else if (controlValue==4){
                System.out.println(projectDAO.getAll());
            }else if (controlValue==5){
                ConsoleDataInput.writeMessage("imput project name t find");
                name=ConsoleDataInput.readString();
                System.out.println(projectDAO.findByName(name));
            }else if (controlValue==6){
                ConsoleDataInput.writeMessage("imput get id");
                id=ConsoleDataInput.readInt();
                System.out.println(projectDAO.get(id));
            } else
                System.out.println("You have entered not correct value. Input 1, 2, 3, 4, 5 or 6.");

        }
    }
}
