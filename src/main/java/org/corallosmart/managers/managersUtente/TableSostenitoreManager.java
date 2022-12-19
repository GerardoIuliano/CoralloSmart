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
    public Sostenitore get() throws SQLException {
        Sostenitore sostenitore = runner.query("SELECT nome,cognome FROM Utente WHERE nome = ?",SOS_MAPPER,"Mario");
        return sostenitore;
    }
}
