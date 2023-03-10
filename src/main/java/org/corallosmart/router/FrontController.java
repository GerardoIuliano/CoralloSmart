package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.PageActionFactory;
import org.corallosmart.actions.actionsUtils.ActionStrategy;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "FrontController", urlPatterns = {"/CoralloSmart/*"})
public class FrontController extends HttpServlet {
  private static final Router ROUTER = new Router(new HashMap<HttpMethod, HashMap<Object, Object>>());
  private static final PageActionFactory PAF = new PageActionFactory();
  //Local
  //@Resource(name = "jdbc/cs")
  //Remote
  @Resource(name = "jdbc/corallosmart")
  private DataSource dataSource;

  /**
   * Inizializzazione del router
   * Associa ad ogni url la action da effettuare
   * @throws ServletException
   */
  @Override
  public void init() throws ServletException {
    getServletContext().setAttribute("db", dataSource);
    ROUTER.get("/", PAF.create("WelcomeAction"));
    ROUTER.get("/index", PAF.create("WelcomeAction"));
    ROUTER.get("/prova", PAF.create("ProvaAction"));
    ROUTER.get("/pippo", PAF.create("ProvaAction"));
    ROUTER.get("/login", PAF.create("LoginAction"));
    ROUTER.post("/checkLogin", PAF.create("CheckLoginAction"));
    ROUTER.get("/registrazione", PAF.create("RegistrationAction"));
    ROUTER.post("/checkRegistration", PAF.create("CheckRegistrationAction"));
    ROUTER.get("/logout", PAF.create("LogoutAction"));
    ROUTER.get("/sostienici", PAF.create("CheckSostieniciAction"));
    ROUTER.get("/checkout", PAF.create("CheckoutAction"));
    ROUTER.get("/registrationResponsabileARPA", PAF.create("RegistrationResponsabileARPAAction"));
    ROUTER.post("/checkRegistrationResponsabileARPA", PAF.create("CheckRegistrationResponsabileARPAAction"));
    ROUTER.post("/operazioneCompletata", PAF.create("OperazioneCompletataAction"));
    ROUTER.get("/info", PAF.create("InfoAction"));
    ROUTER.get("/mioProfilo", PAF.create("MioProfiloAction"));
    ROUTER.get("/aggiungiVoucher", PAF.create("AggiungiVoucherAction"));
    ROUTER.post("/clickAggiungiVoucher", PAF.create("ClickAggiungiVoucherAction"));
    ROUTER.get("/gestioneVoucher", PAF.create("GestioneVoucherAction"));
    ROUTER.post("/modificaVoucher", PAF.create("ModificaVoucherAction"));
    ROUTER.get("/eliminaVoucher", PAF.create("EliminaVoucherAction"));
    ROUTER.get("/mioProfiloARPA", PAF.create("MioProfiloARPAAction"));
    ROUTER.get("/monitoraggio", PAF.create("MonitoraggioAction"));
    ROUTER.get("/statoDispositivi", PAF.create("StatoDispositiviAction"));
    ROUTER.get("/visualizzaIncassi", PAF.create("VisualizzaIncassiAction"));
    ROUTER.get("/modificaProfilo", PAF.create("ModificaProfiloAction"));
    ROUTER.get("/modificaProfiloARPA", PAF.create("ModificaProfiloARPAAction"));
    ROUTER.get("/contributiEvoucher", PAF.create("ContributiEVoucherAction"));
    ROUTER.post("/checkModificaProfilo", PAF.create("CheckModificaProfiloAction"));
    ROUTER.get("/goToIndexARPA", PAF.create("GoToIndexARPAAction"));
    ROUTER.post("/ricercaData", PAF.create("RicercaDataAction"));
  }

  /**
   * metodo doGet
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      processRequest(HttpMethod.GET, request, response);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * metodo doPost
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      processRequest(HttpMethod.POST, request, response);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Processo di richiesta
   * @param method
   * @param req
   * @param res
   * @throws ServletException
   * @throws IOException
   */
  private void processRequest(HttpMethod method, HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException, SQLException {
    ActionStrategy actionStrategy = (ActionStrategy) ROUTER.handleRoute(method, req.getPathInfo());
    String result = actionStrategy.execute(req, res);

    if (!result.equals("ajax")) {
      if (result.startsWith("redirect:")) {
        result = result.substring(9);
        res.sendRedirect(result);
      } else {
        req.getRequestDispatcher(result).forward(req, res);
      }
    }
  }

}