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

public class ModificaVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String importo = request.getParameter("importo" + id);
            String descrizione = request.getParameter("descrizione" + id);

            if (descrizione.matches("^([^0-9]*)$") == false) {
                request.getSession().setAttribute("erroreDescrizione", "Errore, la descrizione non puo contenere numeri!");
            } else {
                if (importo.matches("^[0-9]+(\\.[0-9]+)?$") == false) {
                    request.getSession().setAttribute("erroreImporto", "Importo non corretto, inserisci un numero!");
                } else {
                    Double importo2 = Double.parseDouble(request.getParameter("importo" + id));

                    if (descrizione.length() >= 10 && descrizione.length() < 50 && importo2 <= 150) {
                        VoucherManager voucherManager = new TableVoucherManager(this.getSource(request));
                        voucherManager.modificaVoucher(descrizione, importo2, id);
                        request.getSession().setAttribute("Successo", "Modifica effettuata con successo");
                    } else if (descrizione.length() >= 10 && descrizione.length() < 50 && importo2 > 150) {
                        request.getSession().setAttribute("erroreImportoFuoriRange", "Errore, l'importo deve essere massimo di 150 euro");
                    } else if (descrizione.length() > 50) {
                        request.getSession().setAttribute("erroreDescrizioneLunga", "Errore, la descrizione deve essere minore di 50 caratteri!");
                    } else {
                        request.getSession().setAttribute("erroreDescrizioneCorta", "Errore, la descrizione deve essere almeno di 10 caratteri!");
                    }
                }
            }
            return redirect("gestioneVoucher");
        } catch (NumberFormatException e) {
            return view("500");
        }
    }
}