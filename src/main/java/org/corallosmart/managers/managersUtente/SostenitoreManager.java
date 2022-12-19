package org.corallosmart.managers.managersUtente;

import org.corallosmart.models.modelsUtente.Sostenitore;

import java.sql.SQLException;

public interface SostenitoreManager {
    Sostenitore get()throws SQLException;

}
