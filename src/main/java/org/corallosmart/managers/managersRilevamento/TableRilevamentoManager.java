package org.corallosmart.managers.managersRilevamento;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.corallosmart.managers.managersUtils.TableManager;
import org.corallosmart.models.modelsContributo.Contributo;
import org.corallosmart.models.modelsRilevamento.Rilevamento;
import org.corallosmart.models.modelsUtente.Utente;
import org.corallosmart.models.modelsVoucher.Voucher;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TableRilevamentoManager extends TableManager implements RilevamentoManager{
    private static final ResultSetHandler<Rilevamento> SOS_MAPPER =
            new BeanHandler<>(Rilevamento.class);

    private static final ResultSetHandler<List<Rilevamento>> SOS_LIST_MAPPER =
            new BeanListHandler<>(Rilevamento.class);

    public TableRilevamentoManager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Rilevamento> cercaRilevamento(int id) throws SQLException {
        List<Rilevamento> lista = runner.query("SELECT * FROM Rilevamento where id=?",SOS_LIST_MAPPER, id);
        return lista;

    }

    @Override
    public void inserisciRilevamento(Date dataRicezione,String latitudine, String longitudine, Double DissolvedOxygen, Double OxidationReductionPotential, Double pHTurbidity,Double TotalDissolvedSolids, Double turbidity,String temperatura) throws SQLException {
        runner.update("INSERT INTO Rilevamento(dataRicezione, latitudine, longitudine,DissolvedOxygen,OxidationReductionPotential,pHTurbidity,TotalDissolvedSolids, turbidity, temperatura) VALUES(?,?,?,?,?,?,?,?,?)", dataRicezione, latitudine, longitudine,DissolvedOxygen,OxidationReductionPotential,pHTurbidity,TotalDissolvedSolids, turbidity, temperatura)
    ;}

    @Override
    public List<Rilevamento> cercaRilevamentoData(Date data) throws SQLException {
        List<Rilevamento> lista= runner.query("SELECT * FROM Rilevamento where data<=? AND data <=?",SOS_LIST_MAPPER, data);
                return lista;
    }
}
