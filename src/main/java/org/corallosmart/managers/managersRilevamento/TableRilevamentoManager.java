package org.corallosmart.managers.managersRilevamento;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsRilevamento.Rilevamento;
import org.corallosmart.models.modelsUtente.Utente;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableRilevamentoManager extends TableManager implements RilevamentoManager{
    private static final ResultSetHandler<Rilevamento> SOS_MAPPER =
            new BeanHandler<>(Rilevamento.class);

    private static final ResultSetHandler<List<Rilevamento>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Rilevamento.class);

    public TableRilevamentoManager(DataSource dataSource) {
        super(dataSource);
    }
}
