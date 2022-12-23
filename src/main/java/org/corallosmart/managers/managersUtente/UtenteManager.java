package org.corallosmart.managers.managersUtente;

import org.corallosmart.models.modelsUtente.Utente;

import java.sql.SQLException;

public interface UtenteManager {
    Utente get()throws SQLException;
}
