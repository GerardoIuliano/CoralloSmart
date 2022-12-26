package org.corallosmart.models.modelsUtente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utente{
    protected int id;
    protected String username;
    protected String password;
    protected String nome;
    protected String cognome;
    protected String codiceFiscale;
    protected String email;
    protected String telefono;
    protected boolean tipo;
}
