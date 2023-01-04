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
    public List<Email> cercaEmail(Email email) throws SQLException {
        Email lista= runner.query("SELECT * FROM Email WHERE oggetto= ?, corpo=?, idUtente2=?, idVoucher=? ",SOS_MAPPER, email);
        return (List<Email>) lista;
    }
}
