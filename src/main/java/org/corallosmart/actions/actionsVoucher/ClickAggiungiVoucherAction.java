package org.corallosmart.actions.actionsVoucher;

import org.corallosmart.actions.actionsUtils.ActionStrategy;

import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;

import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClickAggiungiVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        try
        {
            String descrizione = request.getParameter("descrizione");
            String importo = request.getParameter("importo");
            HttpSession session = request.getSession();

            Pattern pattern = Pattern.compile("^[a-zA-Z]+(.|\\s)*$");
            Matcher matcher1 = pattern.matcher(descrizione);
            pattern = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");
            Matcher matcher2 = pattern.matcher(importo);

            if(descrizione == null || descrizione.equals(""))
            {
                session.setAttribute("esitoInserimentoV", "Descrizione non inserita");
            }
            else if (importo == null || importo.equals(""))
            {
                session.setAttribute("esitoInserimentoV", "Importo non inserito");
            }
            else if (descrizione.length() < 10 || descrizione.length() > 50)
            {
                session.setAttribute("esitoInserimentoV", "Descrizione inserita non valida! " +
                        "Inserire una descrizione di lunghezza compresa tra i 10 e i 50 caratteri");
            }
            else if (!matcher1.find())
            {
                session.setAttribute("esitoInserimentoV", "Descrizione inserita non valida! " +
                        "Non inserire caratteri speciali");
            }
            else if (!matcher2.find())
            {
                session.setAttribute("esitoInserimentoV", "Importo inserito non valido! Non inserire caratteri ma solo una cifra compresa tra 5 e 150");
            }
            else if(Double.valueOf(importo) < 5 || Double.valueOf(importo) > 150)
            {
                session.setAttribute("esitoInserimentoV", "Importo inserito non valido! Inserire un importo maggiore o uguale a 5 e minore o uguale di 150");
            }
            else
            {
                VoucherManager voucherManager = new TableVoucherManager(this.getSource(request));
                voucherManager.createVoucher(descrizione, importo);
                session.setAttribute("esitoInserimentoV", "Voucher aggiunto correttamente");
            }
            return view("aggiungiVoucher");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return view("500");
        }
    }
}
