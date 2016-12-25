package view;

import controller.Controller;
import model.dao.CompaniesDAOImpl;
import model.dao.ProjectDAOImpl;
import model.entities.Company;
import model.entities.Developer;
import model.entities.Project;

import java.io.Console;
import java.io.IOException;

/**
 * Created by Vlad on 18.12.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        ProjectDAOImpl project=new ProjectDAOImpl();
       Controller controller=new Controller();
        controller.createProject(project);


    }
}
