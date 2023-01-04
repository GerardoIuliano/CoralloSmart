package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsDispositivo.Dispositivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatoDispositiviAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            Date date = new Date(2022, 4, 15);
            Dispositivo d1 = new Dispositivo(13, "21323213", "4545454", "Alta",
                    date, 1, 1, 1, 1, 2, 2);
            date = new Date(2022, 4, 15);
            Dispositivo d2 = new Dispositivo(14, "21323213", "4545454", "Media",
                    date, 1, 0, 1, 1, 0, 1);
            Dispositivo d3 = new Dispositivo(15, "21323213", "4545454", "Bassa",
                    date, 0, 0, 1, 0, 0, 1);

            List<Dispositivo> dispositivi = new ArrayList<>();
            dispositivi.add(d1);
            dispositivi.add(d2);
            dispositivi.add(d3);

            HttpSession session = request.getSession();
            session.setAttribute("dispositivi", dispositivi);
            
            return view("statoDispositivi");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
