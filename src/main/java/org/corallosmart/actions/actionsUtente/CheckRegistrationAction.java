package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersUtente.TableUtenteManager;
import org.corallosmart.managers.managersUtente.UtenteManager;
import org.corallosmart.models.modelsUtente.Sostenitore;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author Ersilio
 * Crea un nuovo Sostenitore controllando prima che l'email non sia già in uso
 */
public class CheckRegistrationAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String nome = request.getParameter("name");
            String cognome = request.getParameter("cognome");
            String codiceFiscale = request.getParameter("codiceFiscale");
            String telefono = request.getParameter("telefono");


            UtenteManager utenteManager = new TableUtenteManager(this.getSource(request));
            Optional<Utente> optUtente = utenteManager.findUtenteByEmail(email);

            if (optUtente.isPresent()) {
                request.setAttribute("messaggio", "Email già in uso!");
                return view("registrazione");
            }else{
                Sostenitore sostenitore = new Sostenitore(email, password, username, nome, cognome, codiceFiscale, telefono);
                utenteManager.createUtente(sostenitore);
                request.setAttribute("messaggio", "Registrazione avvenuta con successo! è possibile effetuare il login");
                return view("login");
            }
        }catch(Exception e){
            e.printStackTrace();
            return view("500");
        }
    }
}

