package org.corallosmart.actions.actionsContributo;

import com.google.gson.Gson;
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

/**
 * @author Graziano Giuseffi, Ersilio Petretta
 * Action che permette di visualizzare i voicher disponibili in base all'importo che si intede versare
 */
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
                session.setAttribute("listaVoucher", listaVoucher);

                //conversione in Gson di un array
                List<Voucher> list = (List<Voucher>) request.getSession().getAttribute("listaVoucher");
                String listaGson = new Gson().toJson(list);
                request.getSession().setAttribute("listaGson", listaGson);

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

