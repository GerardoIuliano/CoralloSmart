package org.corallosmart.models.modelsUtente;

public class Sostenitore extends Utente{
    public Sostenitore(String email, String password, String username, String nome, String cognome, String codiceFiscale, String telefono) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.telefono = telefono;
        this.tipo = false;
    }

    public Sostenitore(Utente utente) {
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
