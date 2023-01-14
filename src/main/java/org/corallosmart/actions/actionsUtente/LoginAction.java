package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gerardo Iuliano
 * Reindirizza un utente alla pagina di login
 */
public class LoginAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{

            return view("login");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
