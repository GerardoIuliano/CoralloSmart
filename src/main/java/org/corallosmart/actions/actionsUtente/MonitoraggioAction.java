package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersRilevamento.RilevamentoManager;
import org.corallosmart.managers.managersRilevamento.TableRilevamentoManager;
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
            RilevamentoManager rm = new TableRilevamentoManager(this.getSource(request));
            List<Rilevamento> rilevamenti = rm.listaRilevamenti();

            HttpSession session = request.getSession();
            session.setAttribute("rilevamenti", rilevamenti);
            return view("monitoraggio");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
