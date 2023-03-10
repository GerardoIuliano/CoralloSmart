package org.corallosmart.managers.managersDispositivo;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsDispositivo.Dispositivo;
import org.corallosmart.models.modelsUtente.Utente;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableDispositivoManager extends TableManager implements DispositivoManager{
    private static final ResultSetHandler<Dispositivo> SOS_MAPPER =
            new BeanHandler<>(Dispositivo.class);

    private static final ResultSetHandler<List<Dispositivo>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Dispositivo.class);

    public TableDispositivoManager(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * Query per la ricerca si un dispositivo tramite ID
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<Dispositivo> cercaDispositivo(int id) throws SQLException {
        Dispositivo lista= runner.query("SELECT * FROM Dispositivo WHERE id = ?",SOS_MAPPER, id);
        return (List<Dispositivo>) lista;
    }

    /**
     * Query per la ricerca di tutti i dispostivi
     * @return
     * @throws SQLException
     */
    public List<Dispositivo> listaDispositivi() throws SQLException
    {
        List<Dispositivo> lista = runner.query("SELECT * FROM Dispositivo", SOS_LIST_MAPPER);
        return lista;
    }
}
