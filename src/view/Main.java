package view;

import model.dao.CompaniesDAOImpl;
import model.entities.Company;

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
