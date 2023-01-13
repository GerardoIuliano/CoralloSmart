package org.corallosmart.actions.actionsVoucher;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;
import org.corallosmart.models.modelsUtente.Sostenitore;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Adinolfi
 * Questa action permette di aggiornare la lista dei voucher presenti all'interno del sistema
 */

public class GestioneVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        try{
            List<Voucher> listaVoucher= new ArrayList<Voucher>();
            VoucherManager voucherManager = new TableVoucherManager(this.getSource(request));
            listaVoucher=voucherManager.cercaVoucher();

            request.setAttribute("listaVoucher", listaVoucher);
            return view("gestioneVoucher");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
