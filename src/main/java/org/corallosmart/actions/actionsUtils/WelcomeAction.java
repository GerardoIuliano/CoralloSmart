package org.corallosmart.actions.actionsUtils;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersDispositivo.DispositivoManager;
import org.corallosmart.managers.managersDispositivo.TableDispositivoManager;
import org.corallosmart.models.modelsDispositivo.Dispositivo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class WelcomeAction implements ActionStrategy {
  /**
   * Questo metodo mostra la homepage
   * @param request the request
   * @param response the response
   * @return ritorna alla index
   */
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_ACCEPTED);
    try{
      DispositivoManager dm = new TableDispositivoManager(this.getSource(request));
      List<Dispositivo> dispositivi = dm.listaDispositivi();
      int numDispositivi = dispositivi.size();
      double kmBarriera = numDispositivi*KM_DISPOSITIVO;
      long numPesci = Math.round(kmBarriera*NUM_PESCI_KM);

      HttpSession session = request.getSession();
      session.setAttribute("numDispositivi", numDispositivi);
      session.setAttribute("kmBarriera", kmBarriera);
      session.setAttribute("numPesci", numPesci);

      return view("index");
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }

  /*Km coperti da un singolo dispositivo*/
  private final static double KM_DISPOSITIVO = 10;
  /*Numero medio di pesci nel raggio di 1km*/
  private final static double NUM_PESCI_KM = 50;
}