package org.corallosmart.actions.actionsVoucher;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EliminaVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            VoucherManager voucherManager = new TableVoucherManager(this.getSource(request));
            voucherManager.eliminaVoucher(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return redirect("/CoralloSmart/gestioneVoucher");
        }
}
