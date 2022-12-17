package org.corallosmart.actions.actionsUtils;

import org.corallosmart.actions.ProvaAction;

/**
 * @author theBoys
 */
public class PageActionFactory implements ActionFactory {


  /**
   * Crea la Action associata alla stringa che prende in input
   *
   * @param type
   * @return un action
   */
  @Override
  public ActionStrategy create(String type) {
    switch (type) {
      case "WelcomeAction":
        return new WelcomeAction();
      case "ProvaAction":
        return new ProvaAction();

      default:
        return new WelcomeAction();
    }
  }
}