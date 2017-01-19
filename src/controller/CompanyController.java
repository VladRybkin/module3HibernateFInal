package controller;

import model.dao.CompaniesDAO;
import model.dao.CompaniesDAOImpl;
import model.entities.Company;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 29.12.2016.
 */
public class CompanyController implements GeneralController {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
        Company company = new Company();
        int id;
        String name;
        int controlValue;
        Configuration configuration = new Configuration().configure("resources\\HibernateConfig.cfg.xml").addAnnotatedClass(Company.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {

            CompaniesDAOImpl companyDAO = new CompaniesDAOImpl(sessionFactory);
            ConsoleDataInput.writeMessage("\"* * * COMPANY * * *\" + \"\\n\" +\n" +
                    "\"1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL COMPANIES | 5 - FIND BY NAME | 6 - GET BY ID\\\\n\"");
            controlValue=ConsoleDataInput.readInt();
            if ( controlValue==1){
                ConsoleDataInput.writeMessage("imput company name");
                name=ConsoleDataInput.readString();
                company.setCompanyName(name);
                companyDAO.create(company);
            }else if (controlValue==2){
                ConsoleDataInput.writeMessage("imput company id for delete");
                id=ConsoleDataInput.readInt();
                companyDAO.delete(id);
            }else if (controlValue==3){
                ConsoleDataInput.writeMessage("impput update company");
                id=ConsoleDataInput.readInt();
                company.setCompanyID(id);
                companyDAO.update(company);
            } else if (controlValue==4){
                System.out.println(companyDAO.getAll());
            }else if (controlValue==5){
                ConsoleDataInput.writeMessage("imput company name t find");
                name=ConsoleDataInput.readString();
                System.out.println(companyDAO.findByName(name));
            }else if (controlValue==6){
                ConsoleDataInput.writeMessage("imput get id");
                id=ConsoleDataInput.readInt();
                System.out.println(companyDAO.get(id));
            } else
                System.out.println("You have entered not correct value. Input 1, 2, 3, 4, 5 or 6.");

        }
    }
}


