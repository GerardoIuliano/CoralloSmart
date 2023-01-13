package org.corallosmart.managers.managersVoucher;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TableVoucherManager extends TableManager implements VoucherManager{
    private static final ResultSetHandler<Voucher> VOU_MAPPER =
            new BeanHandler<>(Voucher.class);

    private static final ResultSetHandler<List<Voucher>> VOU_LIST_MAPPER =
            new BeanListHandler<>(Voucher.class);

    public TableVoucherManager(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * Query per l'inserimento di un Voucher all'interno del sistema
     * @param descrizione
     * @param importo
     * @throws SQLException
     */

    @Override
    public void createVoucher(String descrizione, String importo) throws SQLException {
        runner.update("INSERT INTO Voucher(descrizione, importo) VALUES(?, ?)", descrizione, importo);
    }

    /**
     * Query per la ricerca di tutti i voucher presenti nel sistema
     * @return una lista con i voucher presenti nel sistema
     * @throws SQLException
     */

    @Override
    public List<Voucher> cercaVoucher() throws SQLException {
        List<Voucher> lista = runner.query("SELECT * FROM Voucher",VOU_LIST_MAPPER);
        return lista;
    }

    /**
     * Query per la ricerca dei voucher con importo minore di quello passato come parametro. I voucher saranno poi ordinati per importo in modo decrescente
     * @param importo
     * @return una lista opzionale di voucher
     * @throws SQLException
     */

    @Override
    public Optional<Voucher> cercaVoucherImporto(double importo) throws SQLException {
        List<Voucher> voucher = runner.query("SELECT * FROM Voucher WHERE importo <= ? ORDER BY importo DESC",VOU_LIST_MAPPER, importo);
        if(voucher != null && !voucher.isEmpty()){
            return Optional.ofNullable(voucher.get(0));
        }else{
            return Optional.ofNullable(null);
        }
    }

    /**
     * Query per la ricerca del voucher con l'id passato come parametro
     * @param id
     * @return un Voucher
     * @throws SQLException
     */

    public Voucher cercaVoucherId(int id) throws SQLException {
        Voucher v = runner.query("SELECT * FROM Voucher WHERE id = ?", VOU_MAPPER, id);
        return v;
    }

    /**
     * Query per la modifica di descrizione e importo del voucher con l'id passato come parametro
     * @param descrizione
     * @param importo
     * @param id
     * @throws SQLException
     */

    @Override
    public void modificaVoucher(String descrizione, double importo, int id) throws SQLException {
        runner.update("UPDATE voucher SET descrizione=?, importo=? WHERE id=?",descrizione, importo, id);
    }

    /**
     * Query per la modifica della descrizione del voucher con l'id passato come parametro
     * @param descrizione
     * @param id
     * @throws SQLException
     */

    public void modificaDescVoucher(String descrizione,int id) throws SQLException {
        runner.update("UPDATE voucher SET descrizione=? WHERE id=?",descrizione, id);
    }

    /**
     * Query per la modifica dell'importo del voucher con l'id passato come parametro
     * @param importo
     * @param id
     * @throws SQLException
     */

    public void modificaImpVoucher(double importo, int id) throws SQLException {
        runner.update("UPDATE voucher SET importo=? WHERE id=?",importo, id);
    }

    /**
     * Query per l'eliminazione del voucher con l'id passato come parametro
     * @param id
     * @throws SQLException
     */

    @Override
    public void eliminaVoucher(int id) throws SQLException {
        runner.update("DELETE Voucher FROM voucher WHERE id=?",id);
    }
}

