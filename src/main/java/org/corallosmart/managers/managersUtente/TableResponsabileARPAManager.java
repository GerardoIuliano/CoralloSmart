package org.corallosmart.managers.managersUtente;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsUtente.ResponsabileARPA;
import org.corallosmart.models.modelsUtente.Utente;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableResponsabileARPAManager extends TableManager implements ResponsabileARPAManager{
    private static final ResultSetHandler<Utente> TUR_MAPPER =
            new BeanHandler<>(Utente.class);

    private static final ResultSetHandler<List<Utente>> TUR_MAPPER_LIST =
            new BeanListHandler<>(Utente.class);

    public TableResponsabileARPAManager(DataSource dataSource) {
        super(dataSource);
    }
}
