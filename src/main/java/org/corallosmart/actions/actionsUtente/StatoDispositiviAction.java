package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersDispositivo.DispositivoManager;
import org.corallosmart.managers.managersDispositivo.TableDispositivoManager;
import org.corallosmart.models.modelsDispositivo.Dispositivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Attilio Gismondi
 * Questa action permette di recuperare la lista di tutti i dispositivi installati dal db
 */
public class StatoDispositiviAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            DispositivoManager dm = new TableDispositivoManager(this.getSource(request));
            List<Dispositivo> dispositivi = dm.listaDispositivi();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            HttpSession session = request.getSession();
            session.setAttribute("dispositivi", dispositivi);
            session.setAttribute("sdf", sdf);

            return view("statoDispositivi");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
