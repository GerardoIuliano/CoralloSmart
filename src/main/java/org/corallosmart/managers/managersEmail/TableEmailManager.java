package org.corallosmart.managers.managersEmail;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsEmail.Email;
import org.corallosmart.models.modelsUtente.Utente;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class TableEmailManager extends TableManager implements EmailManager{
    private static final ResultSetHandler<Email> SOS_MAPPER =
            new BeanHandler<>(Email.class);

    private static final ResultSetHandler<List<Email>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Email.class);

    public TableEmailManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void createEmail(String oggetto, String corpo) throws SQLException {
        runner.update("INSERT INTO Email(oggetto, corpo) VALUES(?, ?)", oggetto, corpo);
    }

    @Override
    public void createEmail(Email email) throws SQLException {
        runner.update("INSERT INTO Email(oggetto, corpo, idUtente2, idVoucher) VALUES(?, ?, ?, ?)", email.getOggetto(), email.getCorpo(), email.getIdUtente2(), email.getIdVoucher());
    }

    @Override
    public void createEmailNoVoucher(Email email) throws SQLException {
        runner.update("INSERT INTO Email(oggetto, corpo, idUtente2) VALUES(?, ?, ?)", email.getOggetto(), email.getCorpo(), email.getIdUtente2());
    }

    @Override
    public Email cercaEmail(Email email) throws SQLException {
        List<Email> lista= runner.query("SELECT * FROM Email WHERE oggetto=? AND corpo=? AND idUtente2=? AND idVoucher=?",SOS_LIST_MAPPER, email.getOggetto(), email.getCorpo(), email.getIdUtente2(), email.getIdVoucher());
        if(lista != null && !lista.isEmpty()){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Email cercaEmailNoVoucher(Email email) throws SQLException {
        List<Email> lista= runner.query("SELECT * FROM Email WHERE oggetto=? AND corpo=? AND idUtente2=?",SOS_LIST_MAPPER, email.getOggetto(), email.getCorpo(), email.getIdUtente2());
        if(lista != null && !lista.isEmpty()){
            return lista.get(0);
        }else{
            return null;
        }
    }
}
