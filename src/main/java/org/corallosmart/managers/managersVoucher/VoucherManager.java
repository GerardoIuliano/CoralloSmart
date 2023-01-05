package org.corallosmart.managers.managersVoucher;

import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface VoucherManager {
    void createVoucher(String descrizione, String importo) throws SQLException;

    List<Voucher> cercaVoucher() throws SQLException;
    Optional<Voucher> cercaVoucherImporto(double importo) throws SQLException;
    Voucher cercaVoucherId(int id) throws SQLException;
    void modificaVoucher(String descrizione, double importo, int id) throws SQLException;

    void eliminaVoucher(int id) throws SQLException;
}
