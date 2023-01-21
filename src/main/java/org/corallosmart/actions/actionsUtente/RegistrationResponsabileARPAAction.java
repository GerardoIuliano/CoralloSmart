package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ersilio
 * Reindirizza alla pagina di registrazione di un Responsabile ARPA
 */
public class RegistrationResponsabileARPAAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{

            return view("registrationResponsabileARPA");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
