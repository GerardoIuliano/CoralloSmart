package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsUtente.Sostenitore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckoutAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);


        try{
            //Sostenitore sos=(Sostenitore) request.getSession().getAttribute("sostenitore");
            //if (sos==null)
              //  return view("login");
            //else {
                return view("checkout");
            //}
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
    }

