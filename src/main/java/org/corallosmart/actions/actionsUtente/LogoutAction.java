package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements ActionStrategy {
    //TODO funziona il logout ma quando si torna indietro con la pagina
    // si torna alla schermata da "loggati" ma non lo si è veramente quindi
    // non si possono fare la operazioni come tale e quindi
    // dovrebbe andare bene

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        request.getSession().removeAttribute("utente");
        return view("index");
    }
}
