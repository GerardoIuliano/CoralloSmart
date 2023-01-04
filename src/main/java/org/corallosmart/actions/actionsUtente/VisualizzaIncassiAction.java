package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersContributo.ContributoManager;
import org.corallosmart.managers.managersContributo.TableContributoManager;
import org.corallosmart.models.modelsContributo.Contributo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisualizzaIncassiAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            ContributoManager cm = new TableContributoManager(this.getSource(request));
            List<Contributo> contributi = cm.listaContributi();

            double totale = 0;
            for (Contributo c: contributi)
            {
                    totale += c.getImporto();
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            HttpSession session = request.getSession();
            session.setAttribute("contributi", contributi);
            session.setAttribute("totale", totale);
            session.setAttribute("sdf", sdf);

            return view("visualizzaIncassi");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
