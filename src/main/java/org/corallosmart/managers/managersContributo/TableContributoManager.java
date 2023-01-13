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


    /**
     * Query che permette l'inserimento di un nuovo contributo nel DB
     * @param contributo
     * @throws SQLException
     */
    @Override
    public void createContributo(Contributo contributo) throws SQLException {
        runner.update("INSERT INTO Contributo(data, importo, idUtente, idEmail, idVoucher2) VALUES(?, ?, ?, ?, ?)", contributo.getData(), contributo.getImporto(), contributo.getIdUtente(), contributo.getIdEmail(), contributo.getIdVoucher2());
    }


    /**
     * Query che permette l'inserimento di un nuovo contributo nel DB senza voucher associato
     * @param contributo
     * @throws SQLException
     */
    @Override
    public void createContributoNoVoucher(Contributo contributo) throws SQLException {
        runner.update("INSERT INTO Contributo(data, importo, idUtente, idEmail) VALUES(?, ?, ?, ?)", contributo.getData(), contributo.getImporto(), contributo.getIdUtente(), contributo.getIdEmail());
    }

    /**
     * Query di ricerca di un contributo tramite l'ID
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<Contributo> cercaContributo(int id) throws SQLException {
       Contributo lista= runner.query("SELECT * FROM Contributo WHERE id = ?",SOS_MAPPER, id);
        return (List<Contributo>) lista;
    }

    /**
     * Query che permette la ricerca di contributi e voucher tramite l'ID dell'utente
     * @param id
     * @return
     * @throws SQLException
     */
    public List cercaContributiVoucher(int id) throws SQLException{
        List lista= runner.query("SELECT * FROM Contributo WHERE idUtente = ?",SOS_LIST_MAPPER, id);
        return lista;
    }

    /**
     * Query che permette la visualizzazione di tutti i contributi
     * @return
     * @throws SQLException
     */
    public List<Contributo> listaContributi() throws SQLException
    {
        List<Contributo> contributi = runner.query("SELECT * FROM Contributo", SOS_LIST_MAPPER);
        return contributi;
    }
}
