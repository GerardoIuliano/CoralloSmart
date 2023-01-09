package org.corallosmart.actions.actionsUtente;

import com.google.gson.Gson;
import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersUtente.TableUtenteManager;
import org.corallosmart.managers.managersUtente.UtenteManager;
import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;
import org.corallosmart.models.modelsUtente.Sostenitore;
import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CheckoutAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);


        try{
            Sostenitore sos=(Sostenitore) request.getSession().getAttribute("utente");
            if(sos != null && sos.isTipo() == false) {
                double importo = Double.parseDouble(request.getParameter("importo"));
                request.getSession().setAttribute("importo", importo);

                VoucherManager voucherManager = new TableVoucherManager(this.getSource(request));
                Optional<Voucher> optVoucher = voucherManager.cercaVoucherImporto(importo);

                if(optVoucher.isPresent()){
                    Voucher voucher = optVoucher.get();
                    request.getSession().setAttribute("voucher", voucher);
                    request.getSession().setAttribute("isVoucher", true);
                }else{
                    request.getSession().setAttribute("isVoucher", false);
                }



                return view("checkout");
            }else{
                return view("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}

