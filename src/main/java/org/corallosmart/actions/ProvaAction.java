package org.corallosmart.actions;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersUtente.TableSostenitoreManager;
import org.corallosmart.models.modelsUtente.Sostenitore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvaAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            TableSostenitoreManager manager = new TableSostenitoreManager(this.getSource(request));
            Sostenitore sostenitore = manager.get();
            request.getSession().setAttribute("sostenitore",sostenitore);

            return view("prova");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
