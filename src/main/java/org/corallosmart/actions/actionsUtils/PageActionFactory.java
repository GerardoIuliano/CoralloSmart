package org.corallosmart.actions.actionsUtils;

import org.corallosmart.actions.ProvaAction;
import org.corallosmart.actions.actionsUtente.*;

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
      case"LogoutAction":
        return new LogoutAction();
      case"CheckoutAction":
        return new CheckoutAction();
      case"SostieniciAction":
        return new SostieniciAction();
      case"RegistrationResponsabileARPAAction":
        return new RegistrationResponsabileARPAAction();
      case"CheckRegistrationResponsabileARPAAction":
        return new CheckRegistrationResponsabileARPAAction();
      case "InfoAction":
        return new InfoAction();
      case "MioProfiloAction":
        return new MioProfiloAction();
      case"ModificaProfiloAction":
        return new ModificaProfiloAction();
      default:
        return new WelcomeAction();
    }
  }
}