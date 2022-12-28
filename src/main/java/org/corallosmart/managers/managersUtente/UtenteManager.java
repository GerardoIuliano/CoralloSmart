package org.corallosmart.managers.managersUtente;

import org.corallosmart.models.modelsUtente.Utente;

import java.sql.SQLException;
import java.util.Optional;

public interface UtenteManager {
    Utente get()throws SQLException;

    Optional<Utente> findUtente(String email, String password) throws SQLException;
    Optional<Utente> findUtenteByEmail(String email) throws SQLException;
    void createUtente(String email, String password, String username, String nome, String cognome, String codiceFiscale, String telefono) throws SQLException;
}
