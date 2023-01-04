package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;

public class ContributiEVoucherAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            HttpSession session = request.getSession();
            session.setAttribute("sdf", sdf);

            return view("contributiEvoucher");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}