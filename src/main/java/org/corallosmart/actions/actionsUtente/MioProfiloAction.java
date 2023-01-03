package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MioProfiloAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            Utente u = new Utente(10, "utente@gmail.com", "abc123", "utente123",
                    "utente", "utonto", "ABC123DFG123HV", "340-123456", false);
            HttpSession session = request.getSession();
            session.setAttribute("utente", u);
            return view("mioProfilo");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
