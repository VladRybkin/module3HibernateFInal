package view;

import controller.Controller;
import javafx.application.Application;
import model.dao.CompaniesDAOImpl;
import model.dao.CustomersDAOImpl;
import model.dao.ProjectDAOImpl;
import model.entities.Company;
import model.entities.Developer;
import model.entities.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Console;
import java.io.IOException;

/**
 * Created by Vlad on 18.12.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        CompaniesDAOImpl companiesDAO=new CompaniesDAOImpl();
        Controller controller=new Controller();
        Company company= new Company();
        companiesDAO.create(company);



    }
}
