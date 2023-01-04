package org.corallosmart.managers.managersContributo;

import org.corallosmart.models.modelsContributo.Contributo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ContributoManager {

    void createContributo(Date data, Double importo) throws SQLException;
    List<Contributo> cercaContributo(int id) throws SQLException;
    public List cercaContributiVoucher() throws SQLException;
    public List<Contributo> listaContributi() throws SQLException;
}
