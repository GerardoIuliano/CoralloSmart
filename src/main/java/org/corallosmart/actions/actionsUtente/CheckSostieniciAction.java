package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionFactory;
import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersVoucher.TableVoucherManager;
import org.corallosmart.managers.managersVoucher.VoucherManager;
import org.corallosmart.models.modelsUtente.Sostenitore;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CheckSostieniciAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        Sostenitore sos=(Sostenitore) request.getSession().getAttribute("sostenitore");
        HashMap<String, Double> map=new HashMap<>();
        try{

            VoucherManager voucherManager=new TableVoucherManager(this.getSource(request));
            
            List<Voucher> listaVoucher=voucherManager.cercaVoucher();
            for (Voucher v: listaVoucher) {
                map.put(v.getDescrizione(),v.getImporto());
            }
            HttpSession session= request.getSession();
            if(session.isNew()){

                session.setAttribute("map", map);
            } else{
                map=(HashMap<String,Double>) session.getAttribute("map");
            }









            // if (sos==null)
            //   return view("login");
            //else{
            return view("sostienici");
            //}
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }

    }
    }

