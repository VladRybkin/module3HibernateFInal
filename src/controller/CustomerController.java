package controller;

import model.dao.CompaniesDAOImpl;
import model.dao.CustomersDAOImpl;
import model.entities.Company;
import model.entities.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;
import view.HibernateUltill;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vlad on 29.12.2016.
 */
public class CustomerController implements GeneralController {
    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {
       Customer customer=new Customer();
        int id;
        String name;
        int controlValue;

        try  {
            CustomersDAOImpl customersDAO=new CustomersDAOImpl(HibernateUltill.getSessionFactory());
            ConsoleDataInput.writeMessage("\"* * * CUSTOMER * * *\" + \"\\n\" +\n" +
                    "\"1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL Customers | 5 - FIND BY NAME | 6 - GET BY ID\\\\n\"");
            controlValue=ConsoleDataInput.readInt();
            switch (controlValue) {
                case 1:{
                    ConsoleDataInput.writeMessage("imput customer name");
                    name = ConsoleDataInput.readString();
                    customer.setCustomerName(name);
                    customersDAO.create(customer);
                    break;
                }case 2:{
                    ConsoleDataInput.writeMessage("imput cutomer id for delete");
                    id = ConsoleDataInput.readInt();
                    customersDAO.delete(id);
                    break;
                }case 3:{
                    ConsoleDataInput.writeMessage("impput update cutomer");
                    id = ConsoleDataInput.readInt();
                    customer.setCustomerId(id);
                    customersDAO.update(customer);
                    break;
                }case 4:{
                    System.out.println(customersDAO.getAll());
                    break;
                }case 5:{
                    ConsoleDataInput.writeMessage("imput customer name t find");
                    name = ConsoleDataInput.readString();
                    System.out.println(customersDAO.findByName(name));
                    break;
                }case 6:{
                    ConsoleDataInput.writeMessage("imput get id");
                    id = ConsoleDataInput.readInt();
                    System.out.println(customersDAO.get(id));
                    break;
                }
                default:break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
