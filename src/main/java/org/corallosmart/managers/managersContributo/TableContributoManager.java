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
    public void createContributo(Contributo contributo) throws SQLException {
        runner.update("INSERT INTO Contributo(data, importo, idUtente, idEmail, idVoucher2) VALUES(?, ?, ?, ?, ?)", contributo.getData(), contributo.getImporto(), contributo.getIdUtente(), contributo.getIdEmail(), contributo.getIdVoucher2());
    }

    @Override
    public void createContributoNoVoucher(Contributo contributo) throws SQLException {
        runner.update("INSERT INTO Contributo(data, importo, idUtente, idEmail) VALUES(?, ?, ?, ?)", contributo.getData(), contributo.getImporto(), contributo.getIdUtente(), contributo.getIdEmail());
    }

    @Override
    public List<Contributo> cercaContributo(int id) throws SQLException {
       Contributo lista= runner.query("SELECT * FROM Contributo WHERE id = ?",SOS_MAPPER, id);
        return (List<Contributo>) lista;
    }
    public List cercaContributiVoucher(int id) throws SQLException{
        List lista= runner.query("SELECT * FROM Contributo JOIN Voucher ON Contributo.idVoucher2=Voucher.id WHERE idUtente = ?",SOS_LIST_MAPPER, id);
        return lista;
    }

    public List<Contributo> listaContributi() throws SQLException
    {
        List<Contributo> contributi = runner.query("SELECT * FROM Contributo", SOS_LIST_MAPPER);
        return contributi;
    }
}
