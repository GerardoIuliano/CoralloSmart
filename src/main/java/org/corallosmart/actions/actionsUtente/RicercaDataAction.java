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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Attilio Gismondi
 * Questa action permette di ricercare i rilevamenti inserendo una data iniziale e una data finale
 */
public class RicercaDataAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            String strIDate = request.getParameter("fromDate");
            String strFDate = request.getParameter("toDate");

            Date fromDate;
            Date toDate;
            
            RilevamentoManager rm = new TableRilevamentoManager(this.getSource(request));

            if(strIDate == null || strIDate.equals(""))
            {
                fromDate = new Date(0, 01, 01);
            }
            else
            {
                fromDate = Date.valueOf(strIDate);
            }

            if(strFDate == null || strFDate.equals(""))
            {
                toDate = new Date(System.currentTimeMillis());
            }
            else
            {
                toDate = Date.valueOf(strFDate);
            }

            HttpSession session = request.getSession();

            if((strIDate == null || strIDate.equals("")) && (strFDate == null || strFDate.equals("")))
            {
                session.setAttribute("esitoRicerca", "Non sono state selezionate date, verranno mostrati tutti i rilevamenti");
            }
            else if((strIDate != null && !strIDate.equals("")) && (strFDate == null || strFDate.equals("")) && fromDate.compareTo(toDate) > 0)
            {
                session.setAttribute("esitoRicerca", "Errore! E' stata inserita data iniziale > data odierna");
            }
            else if(fromDate.compareTo(toDate) <= 0)
            {
                session.setAttribute("esitoRicerca", "Ricerca effettuata con successo!");
            }
            else
            {
                session.setAttribute("esitoRicerca", "Errore! E' stata inserita data iniziale > data finale");
            }

            List<Rilevamento> rilevamenti = rm.cercaRilevamentoData(fromDate, toDate);
            session.setAttribute("rilevamenti", rilevamenti);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            session.setAttribute("sdf", sdf);

            return view("monitoraggio");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
