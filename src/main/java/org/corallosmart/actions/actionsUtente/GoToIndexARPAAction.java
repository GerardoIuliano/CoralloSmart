package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Giuseppe Adinolfi
 * Questa action mostra la homepage
 */

public class GoToIndexARPAAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            Utente utente= (Utente) request.getSession().getAttribute("utente");
            if(utente!=null && utente.isTipo())
            {
                return view("indexARPA");
            }
            else if(utente!=null && !utente.isTipo())
            {
                return view("index");
            }
            else{
                return view("index");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}