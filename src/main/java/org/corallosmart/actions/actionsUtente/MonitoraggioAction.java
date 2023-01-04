package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.models.modelsRilevamento.Rilevamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitoraggioAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            Date date = new Date(2022, 6, 24);
            Rilevamento r1 = new Rilevamento(15, date, "24343243", "45645646",
                    23.5, 6, 7, 8000, 4, "15");
            date = new Date(2022, 7, 24);
            Rilevamento r2 = new Rilevamento(16, date, "24343243", "45645646",
                    23.5, 8, 9, 8000, 4, "16");
            date = new Date(2022, 8, 24);
            Rilevamento r3 = new Rilevamento(17, date, "24343247", "45645646",
                    23.5, 6, 5, 5000, 4, "16");

            List<Rilevamento> rilevamenti = new ArrayList<>();
            rilevamenti.add(r1);
            rilevamenti.add(r2);
            rilevamenti.add(r3);

            HttpSession session = request.getSession();
            session.setAttribute("rilevamenti", rilevamenti);
            return view("monitoraggio");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
