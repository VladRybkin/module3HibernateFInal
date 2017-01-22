package controller;

import model.dao.CompaniesDAO;
import model.dao.CompaniesDAOImpl;
import model.entities.Company;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;
import view.HibernateUltill;

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
        try  {
            CompaniesDAOImpl companyDAO = new CompaniesDAOImpl(HibernateUltill.getSessionFactory());
            ConsoleDataInput.writeMessage("\"* * * COMPANY * * *\" + \"\\n\" +\n" +
                    "\"1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL COMPANIES | 5 - FIND BY NAME | 6 - GET BY ID\\\\n\"");
            controlValue=ConsoleDataInput.readInt();
            switch (controlValue) {
                case 1:  {
                    ConsoleDataInput.writeMessage("imput company name");
                    name = ConsoleDataInput.readString();
                    company.setCompanyName(name);
                    companyDAO.create(company);
                    break;
                }
                case 2: {
                    ConsoleDataInput.writeMessage("imput company id for delete");
                    id = ConsoleDataInput.readInt();
                    companyDAO.delete(id);
                    break;
                }
                case 3:  {
                    ConsoleDataInput.writeMessage("impput update company");
                    id = ConsoleDataInput.readInt();
                    company.setCompanyID(id);
                    companyDAO.update(company);
                    break;
                }
                case 4:{
                    System.out.println(companyDAO.getAll());
                    break;
                }
                case 5:{
                    ConsoleDataInput.writeMessage("imput company name t find");
                    name = ConsoleDataInput.readString();
                    System.out.println(companyDAO.findByName(name));
                    break;
                }
                case 6:{
                    ConsoleDataInput.writeMessage("imput get id");
                    id = ConsoleDataInput.readInt();
                    System.out.println(companyDAO.get(id));
                    break;
                }
                default:break;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


