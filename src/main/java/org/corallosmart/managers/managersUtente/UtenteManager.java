package org.corallosmart.managers.managersUtente;

import org.corallosmart.models.modelsUtente.Utente;

import java.sql.SQLException;
import java.util.Optional;

public interface UtenteManager {
    Utente get()throws SQLException;

    Optional<Utente> findUtente(String email, String password) throws SQLException;
    Optional<Utente> findUtenteByEmail(String email) throws SQLException;
    void createUtente(Utente utente) throws SQLException;
    void updateUtente(Utente utente) throws SQLException;
}
