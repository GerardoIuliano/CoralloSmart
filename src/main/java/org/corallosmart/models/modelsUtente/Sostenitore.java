package org.corallosmart.models.modelsUtente;

/**
 * @author tutti
 * Bean Sostenitore
 */

public class Sostenitore extends Utente{

    /**
     * Costruttore con tutti gli attributi passati come parametri
     * @param email
     * @param password
     * @param username
     * @param nome
     * @param cognome
     * @param codiceFiscale
     * @param telefono
     */

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

    /**
     * Costruttore con Utente passato come parametro
     * @param utente
     */

    public Sostenitore(Utente utente) {
        this.id = utente.id;
        this.username = utente.username;
        this.password = utente.password;
        this.nome = utente.nome;
        this.cognome = utente.cognome;
        this.codiceFiscale = utente.codiceFiscale;
        this.email = utente.email;
        this.telefono = utente.telefono;
        this.tipo = false;
    }
}
