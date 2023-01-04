package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsContributo.Contributo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisualizzaIncassiAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            Date date = new Date(2022, 5, 12);
            Contributo c1 = new Contributo(15, date, 124.5);
            date = new Date(2022, 8, 21);
            Contributo c2 = new Contributo(16, date, 134.5);
            date = new Date(2022, 9, 26);
            Contributo c3 = new Contributo(17, date, 36.5);
            List<Contributo> contributi = new ArrayList<>();
            contributi.add(c1);
            contributi.add(c2);
            contributi.add(c3);

            double totale = 0;
            for (Contributo c: contributi)
            {
                    totale += c.getImporto();
            }

            HttpSession session = request.getSession();
            session.setAttribute("contributi", contributi);
            session.setAttribute("totale", totale);

            return view("visualizzaIncassi");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
