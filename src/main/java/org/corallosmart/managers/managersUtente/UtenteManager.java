package org.corallosmart.managers.managersUtente;

import org.corallosmart.models.modelsUtente.Utente;

import java.sql.SQLException;
import java.util.Optional;

public interface UtenteManager {
    Utente get()throws SQLException;

    Optional<Utente> findUtente(String username, String password) throws SQLException;

}
