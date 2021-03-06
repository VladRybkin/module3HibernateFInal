package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import view.ConsoleDataInput;
import view.HibernateUltill;

import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by Vlad on 29.12.2016.
 */
public class MainClass {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        GeneralController generalController;
        int controlValue;
        ConsoleDataInput.writeMessage("hello");
//        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();




        while (true) {
            ConsoleDataInput.writeMessage("(\"\\\\nPlease Choose Entity: 1 - SKILL | 2 - CUSTOMER | 3 - COMPANY | 4 - DEVELOPER | 5 - PROJECT | 6 - EXIT FROM SYSTEM\"");
            controlValue = ConsoleDataInput.readInt();
            switch (controlValue) {
                case 1:
                    generalController = new SkillController();
                    generalController.execute();
                    break;
                case 2:
                    generalController = new CustomerController();
                    generalController.execute();
                    break;
                case 3:
                    generalController = new CompanyController();
                    generalController.execute();
                    break;
                case 4:
                    generalController = new DeveloperController();
                    generalController.execute();
                    break;
                case 5:
                    generalController = new ProjectController();
                    generalController.execute();
                    break;
                case 6:
                    System.out.println("EXIT FROM SYSTEM");
                    default: break;

            }

        }
    }
}
