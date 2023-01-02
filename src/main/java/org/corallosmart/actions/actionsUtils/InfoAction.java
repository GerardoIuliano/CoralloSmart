package org.corallosmart.actions.actionsUtils;

import org.corallosmart.managers.managersUtente.TableUtenteManager;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            return view("info");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
