package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersRilevamento.RilevamentoManager;
import org.corallosmart.managers.managersRilevamento.TableRilevamentoManager;
import org.corallosmart.models.modelsRilevamento.Rilevamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class RicercaDataAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            Date fromDate = Date.valueOf(request.getParameter("fromDate"));
            Date toDate = Date.valueOf(request.getParameter("toDate"));
            System.out.println("aooo");
            RilevamentoManager rm = new TableRilevamentoManager(this.getSource(request));
            List<Rilevamento> rilevamenti = rm.cercaRilevamentoData(fromDate, toDate);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            HttpSession session = request.getSession();
            session.setAttribute("rilevamenti", rilevamenti);
            session.setAttribute("sdf", sdf);

            return view("monitoraggio");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
