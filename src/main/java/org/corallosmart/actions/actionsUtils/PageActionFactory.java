package org.corallosmart.actions.actionsUtils;

import org.corallosmart.actions.ProvaAction;
import org.corallosmart.actions.actionsUtente.CheckLoginAction;
import org.corallosmart.actions.actionsUtente.CheckRegistrationAction;
import org.corallosmart.actions.actionsUtente.LoginAction;
import org.corallosmart.actions.actionsUtente.RegistrationAction;

/**
 * @author theBoys
 */
public class PageActionFactory implements ActionFactory {


  /**
   * Crea la Action associata alla stringa che prende in input
   *
   * @param type name action to create
   * @return un action
   */
  @Override
  public ActionStrategy create(String type) {
    switch (type) {
      case "WelcomeAction":
        return new WelcomeAction();
      case "ProvaAction":
        return new ProvaAction();
      case "LoginAction":
        return new LoginAction();
      case "CheckLoginAction":
          return new CheckLoginAction();
      case"RegistrationAction":
        return new RegistrationAction();
      case"CheckRegistrationAction":
        return new CheckRegistrationAction();
      default:
        return new WelcomeAction();
    }
  }
}