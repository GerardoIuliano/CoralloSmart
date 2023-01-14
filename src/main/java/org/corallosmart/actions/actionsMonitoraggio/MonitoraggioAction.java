package org.corallosmart.actions.actionsMonitoraggio;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersRilevamento.RilevamentoManager;
import org.corallosmart.managers.managersRilevamento.TableRilevamentoManager;
import org.corallosmart.models.modelsRilevamento.Rilevamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Attilio Gismondi
 * Questa action permette di recuperare la lista di tutti i rilevamenti dal db
 */
public class MonitoraggioAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            RilevamentoManager rm = new TableRilevamentoManager(this.getSource(request));
            List<Rilevamento> rilevamenti = rm.listaRilevamenti();

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
