package controller;

import model.dao.*;
import model.entities.*;
import org.springframework.transaction.annotation.Transactional;
import view.ConsoleDataInput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Controller {

    SkillDAOImpl skillDAOImpl;
    CustomersDAOImpl customersDAOimpl;
    CompaniesDAOImpl companiesDAOimpl;
    DevelopersDAOImpl developersDAOimpl;
    ProjectDAOImpl projectDAOimpl;


    @Transactional
    public void createSkillDB() throws IOException {
        Skill skill = new Skill(ConsoleDataInput.readString());
        skillDAOImpl.create(skill);
    }
    @Transactional
    public void createCustomersDB(CustomersDAOImpl customersDAOimpl) throws IOException{
        Customer customer=new Customer(ConsoleDataInput.readString());
        customersDAOimpl.create(customer);
    }
    @Transactional
    public void createCompaniesDB(CompaniesDAOImpl companiesDAOimpl) throws IOException{
        Company company=new Company(ConsoleDataInput.readString());
        companiesDAOimpl.create(company);
    }
    @Transactional
    public void createDeveloperDB(DevelopersDAOImpl developersDAOimpl) throws IOException{
        Developer developer=new Developer(ConsoleDataInput.readString());
        developersDAOimpl.create(developer);
    }
    @Transactional
    public void createProject(ProjectDAOImpl projectDAOimpl) throws IOException{
        Project project=new Project(ConsoleDataInput.readString());
        projectDAOimpl.create(project);
    }

    @Transactional
    public void updateCustomersDB() throws IOException{
        Customer customer=new Customer(ConsoleDataInput.readString());
        customersDAOimpl.update(customer);
    }
    @Transactional
    public void updateCompaniesDB() throws IOException{
        Company company=new Company(ConsoleDataInput.readString());
        companiesDAOimpl.update(company);
    }
    @Transactional
    public void updateDeveloperDB() throws IOException{
        Developer developer=new Developer(ConsoleDataInput.readString());
        developersDAOimpl.update(developer);
    }
    @Transactional
    public void updateProject() throws IOException {
        Project project = new Project(ConsoleDataInput.readString());
        projectDAOimpl.update(project);
    }
    @Transactional
    public void updateSkillDB() throws IOException {
        Skill skill = new Skill(ConsoleDataInput.readString());
        skillDAOImpl.update(skill);
    }






    @Transactional
    public Company getcompanyDB() throws IOException {
       Company company = companiesDAOimpl.get(ConsoleDataInput.readInt());
        return company;
    }
    @Transactional
    public Customer getCustomerDB() throws IOException {
       Customer customer = customersDAOimpl.get(ConsoleDataInput.readInt());
        return customer;
    }
    @Transactional
    public Developer getDeveloperDB() throws IOException {
        Developer developer = developersDAOimpl.get(ConsoleDataInput.readInt());
        return developer;
    }
    @Transactional
    public Project getProjectDB() throws IOException {
        Project project = projectDAOimpl.get(ConsoleDataInput.readInt());
        return project;
    }
    @Transactional
    public Skill getSkillDB() throws IOException {
        Skill skill = skillDAOImpl.get(ConsoleDataInput.readInt());
        return skill;
    }
    @Transactional
    public void deleteCompanyFromDb() throws IOException {
        companiesDAOimpl.delete(ConsoleDataInput.readInt());
    }
    @Transactional
    public void deleteCustomerFromDb() throws IOException {
        customersDAOimpl.delete(ConsoleDataInput.readInt());
    }
    @Transactional
    public void deleteDeveloperFromDb() throws IOException {
        developersDAOimpl.delete(ConsoleDataInput.readInt());
    }
    @Transactional
    public void deleteProjectFromDb() throws IOException {
        projectDAOimpl.delete(ConsoleDataInput.readInt());
    }

    public void deleteSkillFromDb() throws IOException {
        skillDAOImpl.delete(ConsoleDataInput.readInt());
    }



    @Transactional
    public Developer findByNameDeveloperDB() throws IOException {
        Developer developer=developersDAOimpl.findByName(ConsoleDataInput.readString());
        return developer;
    }
    @Transactional
    public Customer findByNameCustomerDB() throws IOException{
        Customer customer=customersDAOimpl.findByName(ConsoleDataInput.readString());
        return customer;
    }
    @Transactional
    public Project findByNameprojectDB() throws IOException{
        Project project=projectDAOimpl.findByName(ConsoleDataInput.readString());
        return project;
    }

    @Transactional
    public Company findbyCompanyDB() throws IOException{
        Company company=companiesDAOimpl.findByName(ConsoleDataInput.readString());
        return company;
    }
    @Transactional
    public Skill findByNameSkillDB() throws IOException {
        Skill skill = skillDAOImpl.findByName(ConsoleDataInput.readString());
        return skill;
    }



    @Transactional
    public List<Company> getAllcompanyFromDb() throws IOException {
        List<Company> companies = new ArrayList<Company>();
        return companies = companiesDAOimpl.getAll();
    }

    @Transactional
    public List<Customer> getAllCustomerFromDb() throws IOException {
    List<Customer> customers = new ArrayList<Customer>();
    return customers = customersDAOimpl.getAll();
    }
    @Transactional
    public List<Developer> getAllDeveloperFromDb() throws IOException {
        List<Developer> developers = new ArrayList<Developer>();
        return developers = developersDAOimpl.getAll();
    }
    @Transactional
    public List<Project> getAllprojcetFromDb() throws IOException {
        List<Project> projects = new ArrayList<Project>();
        return projects = projectDAOimpl.getAll();
    }

    @Transactional
    public List<Skill> getAllSkillsFromDb() throws IOException {
        List<Skill> skills = new ArrayList<Skill>();
        return skills = skillDAOImpl.getAll();
    }



}
