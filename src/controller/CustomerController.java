package controller;

import model.dao.CompaniesDAOImpl;
import model.dao.CustomersDAOImpl;
import model.entities.Company;
import model.entities.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;

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
        Configuration configuration = new Configuration().addAnnotatedClass(Customer.class).configure("HibernateConfig.cfg.xml");
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            CustomersDAOImpl customersDAO=new CustomersDAOImpl(sessionFactory);
            ConsoleDataInput.writeMessage("\"* * * CUSTOMER * * *\" + \"\\n\" +\n" +
                    "\"1 - CREATE | 2 - DELETE | 3 - UPDATE | 4 - SHOW ALL Customers | 5 - FIND BY NAME | 6 - GET BY ID\\\\n\"");
            controlValue=ConsoleDataInput.readInt();
            if ( controlValue==1){
                ConsoleDataInput.writeMessage("imput customer name");
                name=ConsoleDataInput.readString();
                customer.setCustomerName(name);
                customersDAO.create(customer);
            }else if (controlValue==2){
                ConsoleDataInput.writeMessage("imput cutomer id for delete");
                id=ConsoleDataInput.readInt();
                customersDAO.delete(id);
            }else if (controlValue==3){
                ConsoleDataInput.writeMessage("impput update cutomer");
                id=ConsoleDataInput.readInt();
                customer.setCustomerId(id);
                customersDAO.update(customer);
            } else if (controlValue==4){
                System.out.println(customersDAO.getAll());
            }else if (controlValue==5){
                ConsoleDataInput.writeMessage("imput customer name t find");
                name=ConsoleDataInput.readString();
                System.out.println(customersDAO.findByName(name));
            }else if (controlValue==6){
                ConsoleDataInput.writeMessage("imput get id");
                id=ConsoleDataInput.readInt();
                System.out.println(customersDAO.get(id));
            } else
                System.out.println("You have entered not correct value. Input 1, 2, 3, 4, 5 or 6.");

        }
    }
}
