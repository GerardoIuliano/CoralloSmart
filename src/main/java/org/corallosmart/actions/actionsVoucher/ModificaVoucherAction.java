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
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        try {
            String descrizione=request.getParameter("descrizione");
            double importo=Double.parseDouble(request.getParameter("importo"));
            int id= Integer.parseInt(request.getParameter("id"));

        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.getSession().setAttribute("erroreImporto", "Importo non corretto, inserisci un numero!");
            return redirect("/CoralloSmart/gestioneVoucher");
        }

        try{
            String descrizione=request.getParameter("descrizione");
            double importo=Double.parseDouble(request.getParameter("importo"));
            int id= Integer.parseInt(request.getParameter("id"));

            if(descrizione.length()>=10 && descrizione.length()<50)
            {
                VoucherManager voucherManager = new TableVoucherManager(this.getSource(request));
                voucherManager.modificaVoucher(descrizione, importo, id);
                request.getSession().setAttribute("Successo","Modifica effettuata con successo");
                return redirect("/CoralloSmart/gestioneVoucher");
            }
            else if(descrizione.length()>50)
            {
                request.getSession().setAttribute("erroreDescrizioneLunga", "Errore, la descrizione deve essere minore di 50 caratteri!");
                return redirect("/CoralloSmart/gestioneVoucher");
            }
            else
            {
                request.getSession().setAttribute("erroreDescrizioneCorta", "Errore, la descrizione deve essere almeno di 10 caratteri!");
                return redirect("/CoralloSmart/gestioneVoucher");
            }
        } catch(SQLException e) {
            System.out.println("Eccezione modifica voucher");
            return redirect("/CoralloSmart/gestioneVoucher");
        }
    }
}
