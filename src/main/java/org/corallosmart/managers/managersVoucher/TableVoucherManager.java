package org.corallosmart.managers.managersVoucher;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableVoucherManager extends TableManager implements VoucherManager{
    private static final ResultSetHandler<Voucher> VOU_MAPPER =
            new BeanHandler<>(Voucher.class);

    private static final ResultSetHandler<List<Voucher>> VOU_LIST_MAPPER =
            new BeanListHandler<>(Voucher.class);

    public TableVoucherManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createVoucher(String descrizione, String importo) throws SQLException {
        runner.update("INSERT INTO Voucher(descrizione, importo) VALUES(?, ?)", descrizione, importo);
    }

    @Override
    public List<Voucher> cercaVoucher() throws SQLException {
        List<Voucher> lista = runner.query("SELECT * FROM Voucher",VOU_LIST_MAPPER);
        return lista;
    }

    @Override
    public void modificaVoucher(String descrizione, double importo, int id) throws SQLException {
        runner.update("UPDATE voucher SET descrizione=?, importo=? WHERE id=?",descrizione, importo, id);
    }

    @Override
    public void eliminaVoucher(int id) throws SQLException {
        runner.update("DELETE Voucher FROM voucher WHERE id=?",id);
    }
}

