package org.corallosmart.managers.managersContributo;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsUtente.Utente;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TableContributoManager extends TableManager implements ContributoManager{
    private static final ResultSetHandler<Contributo> SOS_MAPPER =
            new BeanHandler<>(Contributo.class);

    private static final ResultSetHandler<List<Contributo>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Contributo.class);

    public TableContributoManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createContributo(Date data, Double importo) throws SQLException {
        runner.update("INSERT INTO Contributo(data, importo) VALUES(?, ?)", data, importo);
    }

    @Override
    public List<Contributo> cercaContributo(int id) throws SQLException {
       Contributo lista= runner.query("SELECT * FROM Contributo WHERE id = ?",SOS_MAPPER, id);
        return (List<Contributo>) lista;
    }

    public List cercaContributiVoucher() throws SQLException{
        List lista= runner.query("SELECT * FROM Contributo JOIN Voucher ON Contributo.idVoucher2=Voucher.id",SOS_LIST_MAPPER );
        return lista;
    }
}
