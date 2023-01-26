package org.corallosmart.models.modelsUtente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author team
 * Bean Utente
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utente{
    protected int id;
    protected String email;
    protected String password;
    protected String username;
    protected String nome;
    protected String cognome;
    protected String codiceFiscale;
    protected String telefono;
    protected boolean tipo;
}
