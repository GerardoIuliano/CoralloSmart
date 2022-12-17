package org.corallosmart.managers.managersUtente;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsUtente.Sostenitore;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableSostenitoreManager extends TableManager implements SostenitoreManager {

    private static final ResultSetHandler<Sostenitore> SOS_MAPPER =
            new BeanHandler<>(Sostenitore.class);

    private static final ResultSetHandler<List<Sostenitore>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Sostenitore.class);

    public TableSostenitoreManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void create(String username, String password, String nome, String cognome, String codiceFiscale, String email, String telefono) throws SQLException {
        runner.update(""/* INSERT INTO UTENTE (username, password, nome, cognome, codiceFiscale, email, telefono) VALUES(?,?,?,?,?,?,?) */,
                username, password, nome, cognome, codiceFiscale, email, telefono);
    }
}
