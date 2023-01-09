package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsUtente.Sostenitore;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificaProfiloAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            Utente utente=(Utente) request.getSession().getAttribute("utente");
            if(utente != null) {
                return view("modificaProfilo");
            }else{
                return view("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
