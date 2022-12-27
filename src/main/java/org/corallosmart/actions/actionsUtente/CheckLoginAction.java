package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersUtente.TableUtenteManager;
import org.corallosmart.managers.managersUtente.UtenteManager;
import org.corallosmart.models.modelsUtente.ResponsabileARPA;
import org.corallosmart.models.modelsUtente.Sostenitore;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

/*
classe che controlla se l'utente è registrato e
verifica se si tratta di un sostenitore o responsabile ARPA
*/
public class CheckLoginAction implements ActionStrategy {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        String username = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            UtenteManager utenteManager = new TableUtenteManager(this.getSource(request));
            Optional<Utente> optUtente = utenteManager.findUtente(username, password);

            if(optUtente.isPresent()){
                Utente utente = optUtente.get();
                if(!utente.isTipo()){
                    Sostenitore sostenitore = new Sostenitore(utente);
                    request.getSession().setAttribute("sostenitore", sostenitore);
                } else {
                    ResponsabileARPA responsabileARPA = new ResponsabileARPA(utente);
                    request.getSession().setAttribute("responsabileARPA", responsabileARPA);
                }
                return redirect("/CoralloSmart/");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return view("500");
        }

        //TODO far funzionare messaggio
        request.setAttribute("messaggio", "Credenziali non corrette! Riprova.");
        return view("login");
    }
}
