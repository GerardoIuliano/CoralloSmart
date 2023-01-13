package org.corallosmart.actions.actionsVoucher;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsUtente.Sostenitore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Giuseppe Adinolfi
 * Questa action mostra la pagina di aggiunta dei voucher
 */

public class AggiungiVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        try{
            return view("aggiungiVoucher");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
