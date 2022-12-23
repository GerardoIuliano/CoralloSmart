package org.corallosmart.managers.managersContributo;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsUtente.Utente;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableContributoManager extends TableManager implements ContributoManager{
    private static final ResultSetHandler<Contributo> SOS_MAPPER =
            new BeanHandler<>(Contributo.class);

    private static final ResultSetHandler<List<Contributo>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Contributo.class);

    public TableContributoManager(DataSource dataSource) {
        super(dataSource);
    }
}
