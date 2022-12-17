package org.corallosmart.managers.managersUtente;

import java.sql.SQLException;

public interface SostenitoreManager {

    void create(
        String username,
        String password,
        String nome,
        String cognome,
        String codiceFiscale,
        String email,
        String telefono
    ) throws SQLException;

}
