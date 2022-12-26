package org.corallosmart.models.modelsUtente;

public class ResponsabileARPA extends Utente{
    public ResponsabileARPA(Utente utente) {
        this.id = utente.id;
        this.username = utente.username;
        this.password = utente.password;
        this.nome = utente.nome;
        this.cognome = utente.cognome;
        this.codiceFiscale = utente.codiceFiscale;
        this.email = utente.email;
        this.telefono = utente.telefono;
        this.tipo = utente.tipo;
    }
}
