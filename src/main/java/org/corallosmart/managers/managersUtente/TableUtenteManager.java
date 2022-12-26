package org.corallosmart.managers.managersUtente;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsUtente.Utente;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TableUtenteManager extends TableManager implements UtenteManager{
    private static final ResultSetHandler<Utente> SOS_MAPPER =
            new BeanHandler<>(Utente.class);

    private static final ResultSetHandler<List<Utente>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Utente.class);

    public TableUtenteManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Utente get() throws SQLException {
        Utente utente = runner.query("SELECT nome,cognome FROM Utente WHERE nome = ?",SOS_MAPPER,"Gianluca");
        return utente;
    }

    @Override
    public Optional<Utente> findUtente(String email, String password) throws SQLException {
        //TODO togliere la query per i test
        //Utente utente = runner.query("SELECT * FROM Utente WHERE email = ? AND password = ?",SOS_MAPPER, email);
        Utente utente = runner.query("SELECT * FROM sql7585596.Utente WHERE email = ? AND password = ?",SOS_MAPPER, email, password);
        return Optional.ofNullable(utente);
    }

    @Override
    public void addUtente(String email, String password, String username, String nome, String cognome, String codiceFiscale, String telefono) throws SQLException {
        Utente utente = runner.query("INSERT INTO sql7585596.Utente(nome, cognome, codiceFiscale, username, email, telefono, tipo, password) VALUES(?, ?, ?, ?, ?, ?, 0, ?)",SOS_MAPPER, nome, cognome, codiceFiscale, username, email, telefono, password);
    }
}
