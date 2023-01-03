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

public class CheckModificaProfiloAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

        try {
            UtenteManager utenteManager = new TableUtenteManager(this.getSource(request));
            Optional<Utente> optUtente = utenteManager.retrieveById(Integer.parseInt(request.getParameter("idUtente")));

            if (optUtente.isPresent()) {
                Utente utente = optUtente.get();

                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String username = request.getParameter("username");
                String nome = request.getParameter("name");
                String cognome = request.getParameter("cognome");
                String codiceFiscale = request.getParameter("codiceFiscale");
                String telefono = request.getParameter("telefono");

                if(email != null && !email.isEmpty()){
                    utente.setEmail(email);
                }
                if(password != null && !password.isEmpty()){
                    utente.setPassword(password);
                }
                if(username != null && !username.isEmpty()){
                    utente.setUsername(username);
                }
                if(nome != null && !nome.isEmpty()){
                    utente.setNome(nome);
                }
                if(cognome != null && !cognome.isEmpty()){
                    utente.setCognome(cognome);
                }
                if(codiceFiscale != null && !codiceFiscale.isEmpty()){
                    utente.setCodiceFiscale(codiceFiscale);
                }
                if(telefono != null && !telefono.isEmpty()){
                    utente.setTelefono(telefono);
                }
                utenteManager.updateUtente(utente);
                request.getSession().setAttribute("utente", utente);
            }else{
                System.out.println("\nUtente non trovato in CheckModificaProfiloAction");
                return view("500");
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nException in CheckModificaProfiloAction");
            return view("500");
        }

        return view("modificaProfilo");
    }
}
