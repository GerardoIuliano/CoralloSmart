package org.corallosmart.managers.managersDispositivo;

import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsDispositivo.Dispositivo;

import java.sql.SQLException;
import java.util.List;

public interface DispositivoManager {
    public List<Dispositivo> cercaDispositivo(int id) throws SQLException;
}
