package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersContributo.ContributoManager;
import org.corallosmart.managers.managersContributo.TableContributoManager;
import org.corallosmart.managers.managersEmail.EmailManager;
import org.corallosmart.managers.managersEmail.TableEmailManager;
import org.corallosmart.managers.managersUtente.TableUtenteManager;
import org.corallosmart.managers.managersUtente.UtenteManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsEmail.Email;
import org.corallosmart.models.modelsUtente.Sostenitore;
import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Date;

public class OperazioneCompletataAction implements ActionStrategy {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);


        try{
            Sostenitore sos=(Sostenitore) request.getSession().getAttribute("utente");
            if(sos != null && sos.isTipo() == false) {
                double importo = (Double) request.getSession().getAttribute("importo");

                Utente utente = (Utente) request.getSession().getAttribute("utente");
                int idUtente = utente.getId();

                Date date = new Date(System.currentTimeMillis());

                boolean isVoucher = (boolean) request.getSession().getAttribute("isVoucher");
                if(isVoucher == true) {
                    Voucher voucher = (Voucher) request.getSession().getAttribute("voucher");
                    int idVoucher = voucher.getId();

                    String oggetto = "voucher ottenuto";
                    String corpo = "è stato ottenuto il voucher " + voucher.getDescrizione();

                    EmailManager emailManager = new TableEmailManager(this.getSource(request));
                    Email email = new Email(oggetto, corpo, idUtente, idVoucher);
                    emailManager.createEmail(email);
                    Email emailConId = emailManager.cercaEmail(email);
                    int idEmail = emailConId.getId();

                    ContributoManager contributoManager = new TableContributoManager(this.getSource(request));
                    Contributo contributo = new Contributo(date, importo, idUtente, idEmail, idVoucher);
                    contributoManager.createContributo(contributo);
                }else{
                    String oggetto = "Nessun voucher";
                    String corpo = "Non è stato sbloccato nessun voucher";

                    EmailManager emailManager = new TableEmailManager(this.getSource(request));
                    Email email = new Email(oggetto, corpo, idUtente);
                    emailManager.createEmailNoVoucher(email);
                    Email emailConId = emailManager.cercaEmailNoVoucher(email);
                    int idEmail = emailConId.getId();

                    ContributoManager contributoManager = new TableContributoManager(this.getSource(request));
                    Contributo contributo = new Contributo(date, importo, idUtente, idEmail);
                    contributoManager.createContributoNoVoucher(contributo);
                }

                return view("operazioneCompletata");
            }else{
                return view("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
