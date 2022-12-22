package org.corallosmart.actions;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersUtente.TableUtenteManager;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvaAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            TableUtenteManager manager = new TableUtenteManager(this.getSource(request));
            Utente utente = manager.get();
            request.getSession().setAttribute("sostenitore",utente);
            return view("prova");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
