package org.corallosmart.managers.managersEmail;

import org.corallosmart.models.modelsEmail.Email;

import java.sql.SQLException;
import java.util.List;

public interface EmailManager {

    void createEmail(String oggetto, String corpo) throws SQLException;
    void createEmail(Email email) throws SQLException;


    Email cercaEmail(Email email) throws SQLException;

}
