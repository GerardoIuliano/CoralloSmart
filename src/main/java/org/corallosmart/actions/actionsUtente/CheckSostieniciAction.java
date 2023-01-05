package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;
import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;
//import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public class CheckSostieniciAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        try{
            Utente utente=(Utente) request.getSession().getAttribute("utente");

            if(utente != null && utente.isTipo() == false){
                VoucherManager voucherManager= new TableVoucherManager(this.getSource(request));

                List<Voucher> listaVoucher= voucherManager.cercaVoucher();

                HttpSession session= request.getSession();
                //JSONObject jsonMap = new JSONObject(map);
                session.setAttribute("listaVoucher", listaVoucher);

                return view("sostienici");
            }else{
                return view("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}

