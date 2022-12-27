package org.corallosmart.actions.actionsUtente;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.managers.managersUtente.TableUtenteManager;
import org.corallosmart.managers.managersUtente.UtenteManager;
import org.corallosmart.models.modelsUtente.Utente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

public class CheckRegistrationAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        String username = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            UtenteManager utenteManager = new TableUtenteManager(this.getSource(request));
            //TODO sostituire findUtente con metodo che cerca utenti solo per email
            Optional<Utente> optUtente = utenteManager.findUtente(username, password);

            if (optUtente.isPresent()) {
                //TODO trovare un modo di avvisare l'utente che l'email è già in uso
            } return view ("index");
        }catch(SQLException e){
            e.printStackTrace();
            return view("500");
        }
    }
}
