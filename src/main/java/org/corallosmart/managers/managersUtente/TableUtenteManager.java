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

    /**
     * Query per la rcerca di un utente tramite username e password
     * @param email
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public Optional<Utente> findUtente(String email, String password) throws SQLException {
        Utente utente = runner.query("SELECT * FROM Utente WHERE email = ? AND password = ?",SOS_MAPPER, email, password);
        return Optional.ofNullable(utente);
    }

    /**
     * Query di ricerca di un utente tramite email
     * @param email
     * @return
     * @throws SQLException
     */
    @Override
    public Optional<Utente> findUtenteByEmail(String email) throws SQLException {
        Utente utente = runner.query("SELECT * FROM Utente WHERE email = ?",SOS_MAPPER, email);
        return Optional.ofNullable(utente);
    }

    /**
     * Query creazione nuovo utente
     * @param utente
     * @throws SQLException
     */
    @Override
    public void createUtente(Utente utente) throws SQLException {
        runner.update("INSERT INTO Utente(nome, cognome, codiceFiscale, username, email, telefono, tipo, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)", utente.getNome(), utente.getCognome(), utente.getCodiceFiscale(), utente.getUsername(), utente.getEmail(), utente.getTelefono(), utente.isTipo(), utente.getPassword());
    }

    /**
     * Query per la modifica di un utente
     * @param utente
     * @throws SQLException
     */
    @Override
    public void updateUtente(Utente utente) throws SQLException {
        runner.update("UPDATE utente SET nome=?, cognome=?, codiceFiscale=?, username=?, email=?, telefono=?, tipo=?, password=? WHERE id=?", utente.getNome(), utente.getCognome(), utente.getCodiceFiscale(), utente.getUsername(), utente.getEmail(), utente.getTelefono(), utente.isTipo(), utente.getPassword(), utente.getId());
    }

    /**
     * Ricerca di un utente tramite ID
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Optional<Utente> retrieveById(int id) throws SQLException {
        Utente utente = runner.query("SELECT * FROM Utente WHERE id = ?",SOS_MAPPER, id);
        return Optional.ofNullable(utente);
    }
}
