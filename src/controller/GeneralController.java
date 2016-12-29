package controller;

import model.entities.Company;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Vlad on 29.12.2016.
 */
public interface GeneralController {
    public void execute() throws IOException, ClassNotFoundException, SQLException;
}
