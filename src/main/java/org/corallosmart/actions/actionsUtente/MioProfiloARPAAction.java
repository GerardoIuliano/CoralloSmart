package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Attilio Gismondi
 * Questa action permette a un responsabile ARPA di accedere alla pagina di riepilogo dei suoi dati, inseriti durante la registrazione
 */
public class MioProfiloARPAAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            return view("mioProfiloARPA");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
