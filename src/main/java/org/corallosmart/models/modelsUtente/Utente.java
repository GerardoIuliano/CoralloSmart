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
    private int id;
    private String username;
    private String password;
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String email;
    private String telefono;
    private boolean tipo;
}
