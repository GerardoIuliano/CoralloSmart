package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.actions.actionsUtils.NotFoundAction;
import java.util.HashMap;
import java.util.Map;

/**
 * @author team
 */
class Router {

  private final Map<HttpMethod, HashMap<Object, Object>> actionMap;

  /**
   * Costruttore
   *
   * @param actionMap
   */
  public Router(Map<HttpMethod, HashMap<Object, Object>> actionMap) {
    this.actionMap = actionMap;
  }

  /**
   * Aggiunta alla Route
   *
   * @param method
   * @param url
   * @param actionStrategy
   * @return
   */
  public Router addRoute(HttpMethod method, String url, ActionStrategy actionStrategy) {
    if(url != null && method != null && actionStrategy != null && url.startsWith("/")) {
      if (!actionMap.containsKey(method)) {
        actionMap.put(method, new HashMap<>());
      }
      actionMap.get(method).put(url, actionStrategy);
      return this;
    }else
      return null;
  }

  /**
   * get Route
   *
   * @param url
   * @param actionStrategy
   * @return
   */
  public Router get(String url, ActionStrategy actionStrategy) {
    return addRoute(HttpMethod.GET, url, actionStrategy);
  }

  /**
   * post Route
   *
   * @param url
   * @param actionStrategy
   * @return
   */
  public Router post(String url, ActionStrategy actionStrategy) {
    return addRoute(HttpMethod.POST, url, actionStrategy);
  }

  /**
   * gestione della Route
   *
   * @param method
   * @param route
   * @return Action
   */
  public Object handleRoute(HttpMethod method, String route) {
    if (!actionMap.containsKey(method)) {
      return new NotFoundAction();
    } else if (!actionMap.get(method).containsKey(route)) {
      return new NotFoundAction();
    } else {
      return actionMap.get(method).get(route);
    }
  }

  /**
   *
   * @return una map
   */
  public Map<HttpMethod, HashMap<Object, Object>> getActionMap() {
    return actionMap;
  }

  public void printMap(){
    try {
      for (HttpMethod method : actionMap.keySet()) {
        System.out.println(method.toString());
        for (Object url : actionMap.get(method).keySet()) {
          System.out.println(url);
          System.out.println(actionMap.get(method).get(url).toString());
        }
      }
    }catch (NullPointerException e){
      System.out.println("\nqualcosa è null nel router!");
      e.printStackTrace();
    }
  }

}
