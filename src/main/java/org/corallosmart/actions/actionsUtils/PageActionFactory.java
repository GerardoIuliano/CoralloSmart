package org.corallosmart.actions.actionsUtils;

import org.corallosmart.actions.ProvaAction;
import org.corallosmart.actions.actionsUtente.*;
import org.corallosmart.actions.actionsVoucher.*;

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
      case"OperazioneCompletataAction":
        return new OperazioneCompletataAction();
      case "InfoAction":
        return new InfoAction();
      case "MioProfiloAction":
        return new MioProfiloAction();
      case "AggiungiVoucherAction":
        return new AggiungiVoucherAction();
      case "ClickAggiungiVoucherAction":
        return new ClickAggiungiVoucherAction();
      case "GestioneVoucherAction":
        return new GestioneVoucherAction();
      case "ModificaVoucherAction":
        return new ModificaVoucherAction();
      case "EliminaVoucherAction":
        return new EliminaVoucherAction();
      case "MioProfiloARPAAction":
        return new MioProfiloARPAAction();
      case "MonitoraggioAction":
        return new MonitoraggioAction();
      case "StatoDispositiviAction":
        return new StatoDispositiviAction();
      case "VisualizzaIncassiAction":
        return new VisualizzaIncassiAction();
      case"ModificaProfiloAction":
        return new ModificaProfiloAction();
      case"CheckModificaProfiloAction":
        return new CheckModificaProfiloAction();
      default:
        return new WelcomeAction();
    }
  }
}