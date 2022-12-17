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
import java.util.HashMap;

@WebServlet(name = "FrontController", urlPatterns = {"/CoralloSmart/*"})
public class FrontController extends HttpServlet {
  private static final Router ROUTER = new Router(new HashMap<HttpMethod, HashMap<Object, Object>>());
  private static final PageActionFactory PAF = new PageActionFactory();
  @Resource(name = "jdbc/NomeDB")
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
    processRequest(HttpMethod.GET, request, response);
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
    processRequest(HttpMethod.POST, request, response);
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
      throws ServletException, IOException {
    ActionStrategy actionStrategy = (ActionStrategy) ROUTER.handleRoute(method, req.getPathInfo());
    String result = actionStrategy.execute(req, res);

    if (result != "ajax") {
      if (result.startsWith("redirect:")) {
        result = result.substring(9);
        res.sendRedirect(result);
      } else {
        req.getRequestDispatcher(result).forward(req, res);
      }
    }
  }

}