package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersContributo.ContributoManager;
import org.corallosmart.managers.managersContributo.TableContributoManager;
import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Attilio Gismondi
 * Questa action permette di recuperare la lista di tutti i contributi e i relativi voucher di un determinato utente dal db
 */
public class ContributiEVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            HttpSession session = request.getSession();

            ContributoManager cm = new TableContributoManager(this.getSource(request));
            VoucherManager vm = new TableVoucherManager(this.getSource(request));

            Utente u = (Utente) session.getAttribute("utente");
            List<Contributo> contributi = cm.cercaContributiVoucher(u.getId());

            List<Voucher> vouchers = new ArrayList<>();

            for (Contributo c: contributi)
            {
                if(c.getIdVoucher2() != 0)
                {
                    vouchers.add(vm.cercaVoucherId(c.getIdVoucher2()));
                }
            }

            session.setAttribute("sdf", sdf);
            session.setAttribute("contributi", contributi);
            session.setAttribute("vouchers", vouchers);
            session.setAttribute("index", 0);

            return view("contributiEvoucher");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}