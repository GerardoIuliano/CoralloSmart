package org.corallosmart.managers.managersVoucher;

import org.corallosmart.models.modelsVoucher.Voucher;

import java.sql.SQLException;
import java.util.List;

public interface VoucherManager {
    void createVoucher(String descrizione, String importo) throws SQLException;

    List<Voucher> cercaVoucher() throws SQLException;

    void modificaVoucher(String descrizione, double importo, int id) throws SQLException;

    void eliminaVoucher(int id) throws SQLException;
}
