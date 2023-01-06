package org.corallosmart.actions.actionsVoucher;

import org.corallosmart.actions.actionsUtils.ActionStrategy;

import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;

import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ClickAggiungiVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        String descrizione = request.getParameter("descrizione");
        String importo = request.getParameter("importo");

        try {
            VoucherManager voucherManager = new TableVoucherManager(this.getSource(request));
            voucherManager.createVoucher(descrizione, importo);

            return view("aggiungiVoucher");
        } catch (SQLException e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
