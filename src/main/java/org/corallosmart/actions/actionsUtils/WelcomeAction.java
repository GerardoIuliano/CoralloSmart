package org.corallosmart.actions.actionsUtils;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
      return view("index");
    } catch (Exception e) {
      e.printStackTrace();
      return view("500");
    }
  }

}